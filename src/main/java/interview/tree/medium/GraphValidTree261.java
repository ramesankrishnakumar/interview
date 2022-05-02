package interview.tree.medium;

public class GraphValidTree261 {
	
	/*
	 * Intuition
	 * 
	 * Note that this same approach also works with recursive depth-first search and
	 * iterative breadth-first search. We'll look at these briefly in the Algorithm
	 * section.
	 * 
	 * Recall that a graph, G, is a tree iff the following two conditions are met:
	 * 
	 * G is fully connected. In other words, for every pair of nodes in G, there is
	 * a path between them. G contains no cycles. In other words, there is exactly
	 * one path between each pair of nodes in G.
	 */
	
	
	class Solution {
		public boolean validTree(int n, int[][] edges) {
			if (edges.length < n - 1)
				return false;
			UnionFind ds = new UnionFind(n);
			for (int i = 0; i < edges.length; i++) {
				int a = edges[i][0];
				int b = edges[i][1];
				if (ds.isConnected(a, b))
					return false;
				else
					ds.union(a, b);
			}
			return true;
		}

		class UnionFind {
			int[] root;
			int[] rank;

			public UnionFind(int n) {
				this.root = new int[n];
				this.rank = new int[n];
				for (int i = 0; i < n; i++) {
					this.root[i] = i; // initially the root of each vertex is itself
					this.rank[i] = 1;
				}
			}

			public void union(int x, int y) {
				int X = find(x);
				int Y = find(y);
				if (X != Y) {
					if (rank[X] > rank[Y])
						root[Y] = X;
					else if (rank[X] < rank[Y])
						root[X] = Y;
					else {
						root[Y] = X;
						rank[X] = rank[X] + 1;
					}
				}

			}

			public int find(int x) {
				if (x == root[x])
					return x;
				root[x] = find(root[x]); // path compression
				return root[x];
			}

			public boolean isConnected(int x, int y) {
				return find(x) == find(y);
			}

		}
	}
}
