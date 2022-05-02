package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

	class SolutionInOrderTraversal {

		public boolean isValidBST(TreeNode root) {
			if (null == root)
				return false;
			List<Integer> sorted = inOrderTraversal(root, new ArrayList<Integer>());
			boolean isValid = true;
			for (int i = 0; i < sorted.size(); i++) {
				if (i + 1 < sorted.size() && sorted.get(i) >= sorted.get(i + 1)) {
					isValid = false;
					break;
				}

			}
			return isValid;

		}

		private List<Integer> inOrderTraversal(TreeNode node, List<Integer> sorted) {
			if (null == node)
				return sorted;
			if (null != node.left)
				inOrderTraversal(node.left, sorted);
			sorted.add(node.val);
			if (null != node.right)
				inOrderTraversal(node.right, sorted);
			return sorted;
		}
	}

	class SolutionCheckWithinRange {

		public boolean isValidBST(TreeNode root) {
			return validate(root, null, null);

		}

		public boolean validate(TreeNode node, Integer lowerBound, Integer upperBound) {
			if (null == node)
				return true;
			if (null != lowerBound && node.val <= lowerBound || null != upperBound && node.val > upperBound)
				return false;
			return validate(node.left, lowerBound, node.val) && validate(node.right, node.val, upperBound);
		}

	}
	
	class Solution {
	    private Integer prev = null;
	    
	    public boolean isValidBST(TreeNode root) {
	        return validate(root) ;
	    }
	    
	    public boolean validate(TreeNode node) {
	        if(null == node ) return true;
	        if (null != node.left && !validate(node.left)) return false;
	        if(null != prev && prev >= node.val) return false;
	        this.prev = node.val;
	        return null == node.right || validate(node.right);      
	    }
	}

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
