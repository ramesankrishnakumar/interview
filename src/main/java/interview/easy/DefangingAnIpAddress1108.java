package interview.easy;

public class DefangingAnIpAddress1108 {
	class Solution {
	    public String defangIPaddr(String address) {
	        // 1. char array of size string size + 6 192.168.4.1 -> 192[.]168[.]4[.]1
	        // 2. access string each char and check equals "."
	        char []  defangedIps = new char [address.length() + 6];
	        for(int i = 0, j = 0; i< address.length(); i++) {
	            if ('.' == address.charAt(i)) {
	                defangedIps[j++] = '[';
	                defangedIps[j++] = '.';
	                defangedIps[j++] = ']';
	            } else {
	                defangedIps[j++] = address.charAt(i);
	            }       
	        }
	        
	        return new String(defangedIps);
	    }
	}
}
