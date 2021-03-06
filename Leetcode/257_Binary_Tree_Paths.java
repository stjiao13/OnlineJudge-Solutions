/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        String str = "";
        path(root, list, str);
        return list;
    }
    
    public void path(TreeNode r, List<String> list, String str) {
        if (r.left == null && r.right == null) {
            str = str + r.val;
            list.add(str);
            return;
        }
        str = str + r.val + "->";
        if (r.left  != null)
            path(r.left,  list, str);
        if (r.right != null)
            path(r.right, list, str);
        return;
    }
}

// new 
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        list.addAll(binaryTreePaths(root.left));
        list.addAll(binaryTreePaths(root.right));
        for (int i = 0; i < list.size(); i ++)
            list.set(i, root.val + "->" + list.get(i));
        if (list.isEmpty()) list.add("" + root.val);
        return list;
    }
}