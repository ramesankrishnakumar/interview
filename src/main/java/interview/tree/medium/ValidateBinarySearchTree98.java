package interview.tree.medium;

import interview.TreeNode;

public class ValidateBinarySearchTree98 {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
	    private Integer prev = null;
	    
	    public boolean isValidBST(TreeNode root) {
	        return validate(root) ;
	    }
	    
	    public boolean validateWithinRange(TreeNode node, Integer lowerBound, Integer upperBound) {
	        if ( null == node ) return true;
	        if ( null != lowerBound && node.val <= lowerBound || null != upperBound && node.val > upperBound ) return false;
	        return validateWithinRange(node.left, lowerBound, node.val) && validateWithinRange(node.right, node.val , upperBound);
	    }
	    
	    
	    
	    public boolean validate(TreeNode node) {
	        if(null == node ) return true;
	        if (null != node.left && !validate(node.left)) return false;
	        if(null != prev && prev >= node.val) return false;
	        this.prev = node.val;
	        return null == node.right || validate(node.right);      
	    }
	    
	}
	
}
