package interview.graph.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllPathFromSourceToDestination797 {
	class Solution {
		private List<List<Integer>> allPaths = new ArrayList<>();
		private int[][] graph = null;

		public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
			this.graph = graph;
			LinkedList<Integer> paths = new LinkedList<>();
			paths.add(0);
			buildAllPathsUsingDFS(paths, 0);
			// buildAllPathsUsingBFS(graph.length);
			return allPaths;
		}

		private void buildAllPathsUsingDFS(LinkedList<Integer> paths, int s) {
			if (s == graph.length - 1) {
				allPaths.add(new ArrayList<>(paths));
				return;
			}
			int[] neighbors = graph[s];
			for (int ns : neighbors) {
				paths.addLast(ns);
				buildAllPathsUsingDFS(paths, ns);
				paths.removeLast();
			}
			return;
		}

		@SuppressWarnings("unused")
		private void buildAllPathsUsingBFS(int n) {
			int start = 0;
			int end = n - 1;
			Deque<List<Integer>> queue = new ArrayDeque<>();
			queue.addLast(Arrays.asList(start));

			while (!queue.isEmpty()) {
				List<Integer> path = queue.removeFirst();
				int lastNode = path.get(path.size() - 1);
				if (lastNode == end) {
					allPaths.add(path);
					continue;
				}
				for (int neighbor : graph[lastNode]) {
					List<Integer> nextPath = new ArrayList<>(path);
					nextPath.add(neighbor);
					queue.addLast(nextPath);
				}
			}
		}

	}
}
