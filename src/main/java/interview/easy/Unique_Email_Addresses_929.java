package interview.easy;

import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses_929 {
	class Solution {
	    public int numUniqueEmails(String[] emails) {
	        Set<String> uniqueEmails = new HashSet<>();
	        for(int i = 0 ; i < emails.length ; i ++) {
	            uniqueEmails.add(getCleanEmail(emails[i]));
	        }
	        
	        return uniqueEmails.size();
	    }
	    
	    private String getCleanEmail(String inputEmail) {
	        StringBuilder bldr = new StringBuilder();
	        boolean isBeforeDomain = true;
	        for(int i = 0 ; i < inputEmail.length(); i++) {
	            if(isBeforeDomain && inputEmail.charAt(i) == '.' ) continue;
	            if(isBeforeDomain && inputEmail.charAt(i) == '+' ) {
	                while(inputEmail.charAt(i) != '@') {
	                    i++;
	                }
	                isBeforeDomain = false;
	            }
	            if(inputEmail.charAt(i) == '@') isBeforeDomain = false;
	            bldr.append(inputEmail.charAt(i));
	        }
	        
	        return bldr.toString();
	    }
	}
}
