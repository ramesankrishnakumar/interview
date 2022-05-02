package interview.graph.medium;

public class NumOfConnComponents323 {
	class Solution {
		public int countComponents(int n, int[][] edges) {
			if (null == edges)
				return 0;

			UnionFind ds = new UnionFind(n);
			for (int i = 0; i < edges.length; i++) {
				int vertex1 = edges[i][0];
				int vertex2 = edges[i][1];
				ds.union(vertex1, vertex2);
			}
			return ds.getCount();
		}

		class UnionFind {
			int[] root;
			int[] rank;
			int count = 0;

			public UnionFind(int n) {
				this.root = new int[n];
				this.rank = new int[n];
				for (int i = 0; i < n; i++) {
					this.root[i] = i; // initially the root of each vertex is itself
					this.rank[i] = 1;
				}
				this.count = n;
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
					--count;
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

			public int getCount() {
				return this.count;
			}
		}
	}
}
