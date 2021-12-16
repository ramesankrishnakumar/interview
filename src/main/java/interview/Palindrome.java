package interview;

import java.util.stream.Collectors;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(new Palindrome().approach1("malayalam"));

	}
	
	public boolean approach1(String s) {
        if(null == s || s.trim().equals(""))
            return true;
        
        String abc = s.toLowerCase().chars()
		.filter(c1 -> (c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9') )
		.mapToObj(Character::toString)
		.collect(Collectors.joining());
        
        char [] ch  = abc.toCharArray();
		char [] rCh = new char[ch.length];
		int j = 0;
		for (int i = ch.length - 1; i >=0; i-- ) {
			rCh[j++] = ch[i];
		}	
        String rString = String.valueOf(rCh);
        
        return abc.equals(rString);
        
    }

}
