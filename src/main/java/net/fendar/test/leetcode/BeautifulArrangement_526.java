package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongchao on 17/2/26.
 */
public class BeautifulArrangement_526 {
    @Test
    public void t() {
        System.out.println(countArrangement(4));
    }

    public int countArrangement(int N) {
        return backtrack(N, 1, new HashSet<Integer>());
    }

    private int backtrack(int n, int idx, Set<Integer> color) {
        if (idx > n) {
            return 1;
        }
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if (color.contains(i) || (idx % i) != 0 && (i % idx) != 0)
                continue;
            color.add(i);
            r += backtrack(n, idx+1, color);
            color.remove(i);
        }
        return r;
    }
}
