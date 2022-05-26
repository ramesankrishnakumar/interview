package interview.graph.mst.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Min_Cost_to_connect_all_points_1584 {
	class Solution {
		private int[][] points;

		public int minCostConnectPoints(int[][] points) {
			this.points = points;
			List<int[]> costs = constructCost();
			int totalCost = 0;
			Collections.sort(costs, (a, b) -> a[0] - b[0]);
			UnionFind uf = new UnionFind(points.length);
			int totalEdges = 0;
			for (int i = 0; i < costs.size() && totalEdges < points.length - 1; i++) { // important optimization if
																						// there are n nodes n-1 is the
																						// required edges to avoid
																						// cycles
				int[] cost = costs.get(i);
				if (!uf.isConnected(cost[1], cost[2])) {
					uf.union(cost[1], cost[2]);
					totalCost += cost[0];
					totalEdges++;
				}
			}
			return totalCost;
		}

		private List<int[]> constructCost() {
			List<int[]> costs = new LinkedList<>();
			for (int i = 0; i < this.points.length; i++) {
				for (int j = i + 1; j < this.points.length; j++) { // important optimization
					// distance 0,1 is same as 1,0
					int weight = Math.abs(this.points[i][0] - this.points[j][0])
							+ Math.abs(this.points[i][1] - this.points[j][1]);
					int[] cost = { weight, i, j };
					costs.add(cost);
				}
			}
			return costs;
		}

		class UnionFind {
			private int[] root;
			private int[] rank;

			public UnionFind(int n) {
				this.root = new int[n];
				this.rank = new int[n];
				for (int i = 0; i < n; i++) {
					root[i] = i;
					rank[i] = 1;
				}
			}

			public int find(int x) {
				int rootx = root[x];
				if (rootx != x)
					root[x] = find(rootx);
				return root[x];
			}

			public boolean isConnected(int x, int y) {
				return find(x) == find(y);
			}

			public void union(int x, int y) {
				int rootx = find(x);
				int rooty = find(y);

				if (rootx != rooty) {
					if (rank[rootx] > rank[rooty]) {
						root[rooty] = rootx;
					} else if (rank[rootx] < rank[rooty]) {
						root[rootx] = rooty;
					} else {
						root[rootx] = rooty;
						rank[rooty] += 1;
					}
				}
			}
		}
	}
}
