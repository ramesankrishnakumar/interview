package interview.graph.TopologicalSort.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_II_210 {
	class Solution {

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			int[] topologicalOrder = new int[numCourses];
			int[] inDegree = new int[numCourses];
			Map<Integer, List<Integer>> adj = new HashMap<>();

			buildAdjListAndIndegree(prerequisites, adj, inDegree);

			Queue<Integer> queue = new ArrayDeque<>();

			for (int i = 0; i < numCourses; i++)
				if (inDegree[i] == 0)
					queue.add(i);

			int j = 0;
			while (!queue.isEmpty()) {
				int course = queue.remove();
				topologicalOrder[j++] = course;
				for (Integer dependentCourse : adj.getOrDefault(course, new ArrayList<>())) {
					inDegree[dependentCourse] -= 1;
					if (inDegree[dependentCourse] == 0)
						queue.add(dependentCourse);
				}
			}

			return j == numCourses ? topologicalOrder : new int[0];

		}

		private void buildAdjListAndIndegree(int[][] prerequisites, Map<Integer, List<Integer>> adj, int[] inDegree) {
			for (int i = 0; i < prerequisites.length; i++) {
				int dest = prerequisites[i][0];
				int src = prerequisites[i][1];
				List<Integer> lst = adj.getOrDefault(src, new ArrayList<>());
				lst.add(dest);
				adj.put(src, lst);
				inDegree[dest] += 1;
			}
		}
	}
}
