package interview.graph.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindIfPathExistsInGraph1971 {
	class Solution {

		private int[] visited = null;

		public boolean validPath(int n, int[][] edges, int source, int destination) {
			if (n == 1)
				return true;
			List<Integer>[] graph = buildGraph(edges, n);
			this.visited = new int[n];
			Arrays.fill(visited, 0);
			return findBFSValidPath(graph, source, destination);
		}

		@SuppressWarnings("unused")
		private boolean findDFSValidPath(List<Integer>[] graph, int source, int destination) {
			if (source == destination)
				return true;
			for (int newVertex : graph[source]) {
				if (visited[newVertex] == 0) {
					visited[newVertex] = 1;
					if (findDFSValidPath(graph, newVertex, destination))
						return true;
				}
			}
			return false;
		}

		private boolean findBFSValidPath(List<Integer>[] graph, int source, int destination) {
			Deque<Integer> queue = new ArrayDeque<>();
			queue.addLast(source);
			while (!queue.isEmpty()) {
				int val = queue.removeFirst();
				if (val == destination)
					return true;
				List<Integer> neighbors = graph[val];
				for (int neighbor : neighbors) {
					if (visited[neighbor] == 0) {
						visited[neighbor] = 1;
						queue.addLast(neighbor);
					}
				}
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		private List<Integer>[] buildGraph(int[][] edges, int n) {
			List<Integer>[] graph = new ArrayList[n];
			for (int i = 0; i < edges.length; i++) {
				int s = edges[i][0];
				int d = edges[i][1];

				if (graph[s] == null)
					graph[s] = new ArrayList<>();
				if (graph[d] == null)
					graph[d] = new ArrayList<>();

				graph[s].add(d);
				graph[d].add(s);
			}

			return graph;
		}
	}
}
