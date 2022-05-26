package interview.graph.medium;

public class Max_Area_Of_Island_695 {
	class Solution {
	    private int [][] seen;
	    private int rows;
	    private int cols;
	    private int[][] grid;
	    public int maxAreaOfIsland(int[][] grid) {
	        int maxArea = 0;
	        this.rows = grid.length;
	        this.cols = grid[0].length;
	        this.grid = grid;
	        seen = new int[rows][cols];
	        for(int i = 0; i < rows ; i ++) {
	            for(int j = 0 ; j < cols ; j++) {
	                if(grid[i][j] == 1 && seen[i][j] == 0) {
	                    maxArea = Math.max(maxArea, search(i, j));
	                }
	            }
	        }
	        
	        return maxArea;
	    }
	    
	    
	    private int search(int i, int j) {
	        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1 || seen[i][j] == 1)
	            return 0;
	        seen[i][j] = 1;        
	        return 1 + search(i+1, j) + search(i - 1, j) + search(i, j+1) + search(i, j-1);
	    }
	}
}
