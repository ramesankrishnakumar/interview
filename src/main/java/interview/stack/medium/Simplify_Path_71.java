package interview.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Simplify_Path_71 {
	class Solution {
		public String simplifyPath2(String path) {
			Deque<String> stack = new ArrayDeque<>();
			String[] components = path.split("/");
			for (String directory : components) {
				if (directory.equals(".") || directory.isEmpty())
					continue;
				if (directory.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else
					stack.add(directory);
			}

			// Stich together all the directory names together
			StringBuilder result = new StringBuilder();
			for (String dir : stack) {
				result.append("/");
				result.append(dir);
			}

			return result.length() > 0 ? result.toString() : "/";
		}

		public String simplifyPath(String path) {
			String[] components = path.split("/");
			StringBuilder bldr = new StringBuilder();
			for (int i = 0; i < components.length; i++) {
				String val = components[i];
				if (val.equals("") || val.equals("."))
					continue;
				if (val.equals("..")) {
					int last = bldr.lastIndexOf("/");
					if (last >= 0)
						bldr.delete(last, bldr.length());
				} else {
					bldr.append("/");
					bldr.append(val);
				}
			}
			if (bldr.length() == 0)
				bldr.append("/");
			return bldr.toString();
		}
	}
}
