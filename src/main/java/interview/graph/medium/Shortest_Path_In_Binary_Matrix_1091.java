package interview.graph.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Shortest_Path_In_Binary_Matrix_1091 {
	
	class Solution {
	    
	    private //static 
	    int[][] distance = {
	                                            {-1, 0}, // north
	                                            {1,  0}, // south
	                                            {0,  1}, // east
	                                            {0, -1},  // west
	                                            {-1, 1},  //NE
	                                            {-1,-1}, // NW
	                                            {1,  1}, //SE
	                                            {1, -1} //SW
	                                      };
	    public int shortestPathBinaryMatrix(int[][] grid) {
	        if (grid[0][0] == 1 || grid[grid.length - 1] [grid[0].length -1] == 1)
	            return -1;
	        return findShortestPathLengthUsingBFS(grid);
	    }
	    
	    private List<int[]> getNeighbours(int row, int col, int [][] grid, int[][] seen) {
	        List<int[]> neighbours = new ArrayList<>();
	        for(int [] d : this.distance) {
	            int nRow = row + d[0];
	            int nCol = col + d[1];
	            if(nRow < 0 || nRow >= grid.length || nCol < 0 ||
	                        nCol >= grid[0].length || grid[nRow][nCol] == 1 || seen[nRow][nCol] == 1) {
	                continue;
	            }
	            neighbours.add(new int[] {nRow, nCol, 0});
	        }
	        return neighbours;
	    }
	    
	    private int findShortestPathLengthUsingBFS(int [][] grid) {
	        ArrayDeque<int[]> queue = new ArrayDeque<>();
	        queue.addLast(new int[] {0,0,1});
	        
	        int [][] seen = new int[grid.length][grid.length];
	        seen[0][0] = 1;
	        
	        while(!queue.isEmpty()) {
	            int[] eleIndex = queue.removeFirst();
	            int nRow = eleIndex[0];
	            int nCol = eleIndex[1];

	            if(nRow == grid.length -1 && nCol == grid.length - 1)
	                return eleIndex[2];

	            List<int[]> neighbours = getNeighbours(nRow, nCol, grid, seen);
	            for(int[] neighbour : neighbours){
	                neighbour[2] = eleIndex[2] +1;
	                seen[neighbour[0]][neighbour[1]] = 1;
	                queue.addLast(neighbour);
	            }
	        }
	        return -1;
	    }
	}
	
}
