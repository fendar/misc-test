package net.fendar.test.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhongchao on 17/2/23.
 */
public class ValidParentheses_20 {
    public boolean solution(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0, j = s.length(); i < j; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c =='[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                Character pop = stack.pop();
                if (map.get(pop) != c)
                    return false;
            }

        }

        return stack.isEmpty();
    }
}
