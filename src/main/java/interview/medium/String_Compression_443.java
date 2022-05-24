package interview.medium;

public class String_Compression_443 {
	class Solution_best {
	    public int compress(char[] chars) {
	        if(chars.length == 1) return 1;
	        int i = 1; int count = 1; int runningIndex = 0;
	        while(i < chars.length) {
	            if(chars[i] == chars[i-1]) {
	                ++ count;
	            } else {
	                runningIndex = handleAppend(chars[i-1], count, chars, runningIndex);
	                count = 1;
	            }
	            i++;
	        }
	        runningIndex = handleAppend(chars[i-1], count, chars, runningIndex);
	        return runningIndex;
	    }
	    
	    private int handleAppend(char c, int count, char[] chars, int runningIndex) {
	        chars[runningIndex++] = c;
	        if(count != 1) {
	            for(char num :  Integer.toString(count).toCharArray()) {
	                chars[runningIndex++] = num;                   
	            }
	        }
	        return runningIndex;
	    }
	    
	}
	
	
	class Solution_ExtraSpace {
	    public int compress(char[] chars) {
	        if(chars.length == 1) return 1;
	        StringBuilder bldr = new StringBuilder();
	        int i = 1; int count = 1;
	        while(i < chars.length) {
	            if(chars[i] == chars[i-1]) {
	                ++ count;
	            } else {
	                handleAppend(chars[i-1], count, bldr);
	                count = 1;
	            }
	            i++;
	        }
	        
	        handleAppend(chars[chars.length - 1 ], count, bldr);
	        int j = 0;
	        for(char c : bldr.toString().toCharArray()) {
	            chars[j] = c;
	            j++;
	        }
	        return j;
	    }
	    
	    private void handleAppend(char c, int count, StringBuilder bldr) {
	        bldr.append(c);
	        if(count != 1) {
	            String countVal = Integer.toString(count);
	            bldr.append(countVal.toCharArray());
	        }
	    }
	    
	}
}
