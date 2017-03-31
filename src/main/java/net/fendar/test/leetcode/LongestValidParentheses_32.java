package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by zhongchao on 17/3/2.
 */
public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<>();

        int max = 0;
        int rmax = 0;

        for (int i = 0, j = s.length(); i < j; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (stack.isEmpty()){
                max = max > rmax ? max : rmax;
                rmax = 0;
                if (max >= j - i)
                    break;
            } else {
                stack.pop();
                rmax += 2;
            }
        }
        max = max > rmax ? max : rmax;

        return max;
    }

    private int recursive(String s, int end) {
        if (end == 0)
            return 0;
        if (s.charAt(end) == '(')
            return recursive(s, end - 1);
        // end====> ')'
        if (s.charAt(end - 1) == '(') {
            if (s.charAt(end - 2) == '(')
                return Math.max(2, recursive(s, end - 3));
            else
                return recursive(s, end - 2) + 2;
        }
        //end - 1 ====> ')'
        return -1;
    }

    @Test
    public void test() {
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("("));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(")"));
        System.out.println(longestValidParentheses(")("));
        System.out.println(longestValidParentheses(")()()("));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
    }

    private boolean isPair(char c1, char c2) {
        return c1 != c2;
    }
}
