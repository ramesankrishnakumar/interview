package interview.easy;

public class LCP14 {

	public static void main(String[] args) {
		String s1 = "leetsss";
		String s2 = "leetcode";
		System.out.println(s2.indexOf(s1));
		
		while(s2.indexOf(s1)!= 0) {
			s1 = s1.substring(0, s1.length() -1);
			if(s1.isEmpty()) break;
		}
		
		System.out.println(s1);
	}

}
