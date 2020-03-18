# Tree

+ [Binary Tree Inorder Traversal](#Binary-Tree-Inorder-Traversal)
+ [Symmetric Tree](#Symmetric-Tree)

## Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        down(root, res);
        return res;
    }
    
    public void down(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                down(root.left, res);
            }
            res.add(root.val);
            
            if (root.right != null) {
                down(root.right , res);
            }
        }
    }
}
```
## Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
```java
 public boolean isSymmetricIteratively(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {return true;}
            if (leftNode == null || rightNode == null) {return false;}
            if (leftNode.val != rightNode.val) return false;
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
```
