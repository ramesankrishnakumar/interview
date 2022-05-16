package interview;

public class Test {

	private int[] root;
	private int[] rank;

	public Test(int n) {
		root = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		int rootX = root[x];
		if (x == rootX) return x;
			
		return root[x] = find(root[rootX]);
	}

	public boolean isConnected(int x, int y) {
		return root[x] == root[y];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rank[rootX] < rank[rootY])
				root[rootX] = rootY;
			else if (rank[rootX] > rank[rootY])
				root[rootY] = rootX;
			else {
				root[rootX] = rootY;
				rank[rootY] += 1;
			}
		}
	}

}
