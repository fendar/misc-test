package net.fendar.test.sort;

import com.google.common.primitives.Ints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongchao on 17/2/22.
 */
public class MergeSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        List<Integer> list = new ArrayList<Integer>();
        while ((s = reader.readLine()) != null) {
            Integer i = Integer.parseInt(s);
            if (i == -1) {
                int[] arr = Ints.toArray(list);
                merge_sort(arr);
                System.out.println(Arrays.toString(arr));
                list.clear();
            } else {
                list.add(i);
            }
        }
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                if (start1 < end1) {
                    int l = end1 -start1;
                    System.arraycopy(arr, start1, result, low, l);
                    low += l;
                }
//                while(start1 < end1) {
//                    result[low++] = arr[start1++];
//                }
                if (start2 < end2) {
                    System.arraycopy(arr, start2, result, low, end2 -start2);
                }
//                while(start2 < end2) {
//                    result[low++] = arr[start2++];
//                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }
}
