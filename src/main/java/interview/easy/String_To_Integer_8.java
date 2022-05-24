package interview.easy;

public class String_To_Integer_8 {
	
	class Solution {
		
		public int myAtoi(String s) {
			int i = 0;
			int result = 0;
			int sign = 1;
			int n = s.length();
			
			while (i < n && s.charAt(i) == ' ')
				i++;

			if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
				if (s.charAt(i) == '-')
					sign = -1;
				i++;
			}

			while ((i < n) && Character.isDigit(s.charAt(i))) {
				int num = s.charAt(i) - '0';
				if (result > Integer.MAX_VALUE / 10
						|| (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

				result = result * 10 + num;
				i++;
			}
			return sign * result;
		}
	}
}
