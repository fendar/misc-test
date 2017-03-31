package net.fendar.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhongchao on 17/2/25.
 */
public class InsertInterval_57 {

    public static void main(String[] args) {
        InsertInterval_57 main = new InsertInterval_57();

        System.out.println(
                main.insert(Arrays.asList(main.new Interval(1, 3), main.new Interval(6, 9)), main.new Interval(2, 5))
        );
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<Interval>();
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            results.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end)
            );
            i++;
        }

        results.add(newInterval);

        while (i < intervals.size()) {
            results.add(intervals.get(i++));
        }

        return results;
    }


    public  class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" +
                     start +
                    "," + end +
                    ']';
        }
    }
}
