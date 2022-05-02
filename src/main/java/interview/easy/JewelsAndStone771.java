package interview.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStone771 {
	class Solution {
	    public int numJewelsInStones(String jewels, String stones) {
	        return bestsolution(jewels, stones);
	    }
	    
	    public int bestsolution(String jewels, String stones) {
	        Set<Character> jewelsSet = new HashSet<>();
	        int count = 0;
	        for(char j : jewels.toCharArray()){
	            jewelsSet.add(j);
	        }
	        
	        for(char s : stones.toCharArray()) {
	            if(jewelsSet.contains(s)) count++;
	        }
	        
	        return count;
	    }
	    
	    
	    
	    public int badSolution(String jewels, String stones) {
	        Map<String, Integer> jemCount = new HashMap<>();
	        int count = 0;
	        for (int i = 0;  i< stones.length(); i++ ) {
	            String stone = Character.toString(stones.charAt(i)).intern();
	            if(null != jemCount.get(stone)){
	                Integer jCount = jemCount.get(stone) + 1;
	                jemCount.put(stone, jCount);
	            }else{
	                jemCount.put(stone, 1);
	            }
	        }
	        
	        for (int i = 0; i< jewels.length(); i++){
	             String pieceOfJewel = Character.toString(jewels.charAt(i));
	             Integer jewelCount = jemCount.get(pieceOfJewel);
	             if(null != jewelCount)
	                 count +=jewelCount;
	        }
	        return count;
	    }
	    
	    
	    public int goodSolution(String jewels, String stones) { 
	        int count = 0;
	        for(int i = 0; i < jewels.length(); i ++ ){
	            for (int j = 0; j < stones.length(); j++){
	                if (jewels.charAt(i) == stones.charAt(j))
	                    count ++;
	            }
	        }
	        return count;
	    }
	    
	    
	    public int goodSolution2(String jewels, String stones) { 
	        int count = 0;
	        for(int i = 0; i < stones.length(); i ++ ){
	            if(jewels.indexOf(stones.charAt(i)) > -1)
	                count ++;
	        }
	        return count;
	    }
	    
	}
}
