package interview.easy;

public class Plus_One_66 {
	class Solution {
		public int[] plusOne(int[] digits) {

			int i = digits.length - 1;

			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			}

			int carry = 1;

			while (i >= 0) {
				if (carry == 1) {
					if (digits[i] == 9) {
						digits[i] = 0;
						carry = 1;
					} else {
						digits[i] = digits[i] + carry;
						carry = 0;
					}
				} else {
					break;
				}
				i--;
			}
			if (carry == 1) {
				digits = new int[digits.length + 1];
				digits[0] = 1;
			}
			return digits;

		}
	}
}
