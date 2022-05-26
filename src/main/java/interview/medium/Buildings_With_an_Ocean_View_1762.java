package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class Buildings_With_an_Ocean_View_1762 {
	class Solution { // see only from right
	    public int[] findBuildings(int[] heights) {
	        int bHeight = -1;
	        List<Integer> resultList = new ArrayList<>();
	        for(int i = heights.length - 1; i >= 0 ; i--) {
	            if(heights[i] > bHeight) {
	                resultList.add(i);
	            }
	            bHeight = Math.max(bHeight, heights[i]);
	        }
	        int [] result  = new int[resultList.size()];
	        int j = 0;
	        for(int i = resultList.size() - 1; i >=0 ; i--) {
	            result[j++] = resultList.get(i);
	        }
	        return result;
	    }
	}
}
