#-*- coding:utf-8 –*-

import urllib2
import urllib
import cookielib
import re
import webbrowser

imgCode = ""
class LQLogin:
    def __init__(self):
        self.loginURL = "http://wsyc.lqwang.com/Login.aspx"
        self.loginHeaders = {
            'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
            'Accept-Encoding':'gzip, deflate, sdch',
            'Accept-Language':'zh-CN,zh;q=0.8,en;q=0.6,gl;q=0.4',
            'Connection':'keep-alive',
            'Host':'wsyc.lqwang.com',
            'Upgrade-Insecure-Requests':'1',
            'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36'
        }
        self.post = {
            '__VIEWSTATE':'/wEPDwUKMTg0NDI4MDE5OGRk5fUBYNDgEyCFMqLG67nHjWu4h3Y=',
            'txtUserName': '371311198811222878',
            'txtPassword': "19881122",
            'txtIMGCode': imgCode,
            'btnLogin': '登  录',
            'rcode': ''
        }
        self.postData = urllib.urlencode(self.post)
        self.cookie = cookielib.LWPCookieJar()
        self.cookieHandler = urllib2.HTTPCookieProcessor(self.cookie)
        self.opener = urllib2.build_opener(self.cookieHandler, urllib2.HTTPHandler)
        self.checkUrl = "http://wsyc.lqwang.com/Tools/km2.aspx?date=Fri%20Nov%2013%202015%2014:43:33%20GMT+0800%20(CST)&filters%5Byyrq%5D=20151119&filters%5Bxnsd%5D=15&filters%5Bxllxid%5D=3&filters%5Btype%5D=km2Car&filters%5Borderby%5D=&filters%5Bcnbh%5D=&orderBy=&pageno=1&pagesize=10&_=1447397013078";
        self.imageUrl = "http://wsyc.lqwang.com/tools/CreateCode.ashx?key=ImgCode&random=0.34685747139155865"

    def sendPostData(self, loop):
        self.postData = urllib.urlencode(self.post)
        request = urllib2.Request(self.loginURL, self.postData, self.loginHeaders)
        self.opener.open(request)
        if loop == 1:
            self.loop()

    def loop(self):
        request = urllib2.Request(self.checkUrl)
        response = self.opener.open(request)
        if response.getcode() == 200:
            while 1:
                url = raw_input("please input url:")
                request = urllib2.Request(url)
                response = self.opener.open(request)
                print response.read()


    def getimagecode(self):
        request = urllib2.Request(self.imageUrl)
        response = self.opener.open(request)
        locpath = open("img.gif", "wb")
        locpath.write(response.read())
        locpath.flush()
        checkcode = raw_input("please input img code:")
        self.post["txtIMGCode"] = checkcode

    def main(self):
        self.sendPostData(0)
        self.getimagecode()
        self.sendPostData(1)

login = LQLogin()
login.main()