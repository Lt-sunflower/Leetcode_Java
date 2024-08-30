package leetcode.problems.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import leetcode.problems.Problem;

public class Q57InsertInterval implements Problem {

		/**
		 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
		 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
		 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
		 *
		 * Insert newInterval into intervals such that intervals is still sorted in ascending
		 * order by starti and intervals still does not have any overlapping intervals
		 * (merge overlapping intervals if necessary).
		 *
		 * Return intervals after the insertion.
		 **/

		int[][] intervals;
		int[] newInterval;

		public Q57InsertInterval(){
//				this.intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
				this.intervals = new int[][] {{1,5}};
				this.newInterval = new int[] {6,8};
		}

		private int[][] solve(){

				ArrayList<int[]> result = new ArrayList<>();

				int newStart = newInterval[0];
				int newEnd = newInterval[1];

				int i = 0;

				// add all where newInt > start
				while (i<intervals.length && intervals[i][1]<newStart)
				{
						result.add(intervals[i]);
						i++;
				}

				// merge all that falls within range
				while (i<intervals.length && intervals[i][0]<=newEnd)
				{
						newStart = Math.min(newStart, intervals[i][0]);
						newEnd = Math.max(newEnd,intervals[i][1]);
						i++;
				}

				// add new interval
				result.add(new int[] {newStart, newEnd});

				// add all the rest
				while (i<intervals.length)
				{
						result.add(intervals[i]);
						i++;
				}

				return convertListToArray(result);
		}

		public static int[][] convertListToArray(List<int[]> list) {

				// helper method by chatgpt

				int[][] array = new int[list.size()][];

				for (int i = 0; i < list.size(); i++) {
						array[i] = list.get(i);
				}

				return array;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: intervals=" + Arrays.deepToString(intervals) + " , newInterval=" + Arrays.toString(
						newInterval));
				System.out.println("Answer: " + Arrays.deepToString(solve()));
		}
}
