package leetcode.problems.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import leetcode.problems.Problem;

public class Q207CourseSchedule implements Problem {

		/**
		 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
		 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
		 * indicates that you must take course bi first if you want to take course ai.

		 * Return true if you can finish all courses. Otherwise, return false.
		 *
		 **/

		private int numCourses;
		private int[][] prerequisites;

		public Q207CourseSchedule(){
				this.numCourses = 3;
				this.prerequisites = new int[][] {{0,1},{0,2},{1,2}};
		}

		Map<Integer, List<Integer>> premap = new HashMap<>();
		private boolean solve() {

				// build premap
				for (int i=0; i<numCourses; i++){
						premap.put(i, new ArrayList<>());
				}

				for (int[] p : prerequisites){
						int course = p[0];
						int prerequisite = p[1];

						List<Integer> newList;
						newList = premap.get(course);
						newList.add(prerequisite);
						premap.put(course,newList);
				}

				// for each course, perform dfs. use visit set
				for (int course : premap.keySet()){
						Set<Integer> visitMap = new HashSet<>();
						if (!search(course, visitMap)) return false;
				}

				// if loop, false. else if all ok, return true
				return true;

		}

		private boolean search(int course, Set<Integer> visitMap){
				if (visitMap.contains(course)) return false;
				else visitMap.add(course);

				List<Integer> prereq = premap.get(course);
				if (prereq.size() == 0) {
						visitMap.remove(course);  // Backtrack after finishing the course
						return true;
				}

				Iterator<Integer> iterator = prereq.iterator();
				while (iterator.hasNext()) {
						int p = iterator.next();
						boolean b = search(p, visitMap);
						if (b) {
								iterator.remove(); // Safe way to remove elements during iteration
						} else {
								return false;
						}
				}
				visitMap.remove(course); // Backtrack from the current path
				return true;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + Arrays.deepToString(prerequisites));
				System.out.println("Answer: " + solve());
		}
}
