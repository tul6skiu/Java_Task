# Tree

+ [Binary Tree Inorder Traversal](#Binary-Tree-Inorder-Traversal)
+ [Symmetric Tree](#Symmetric-Tree)
+ [Maximum Depth](#Maximum-Depth)
+ [Same Tree](#Same-Tree)

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

## Maximum-Depth
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

```java
 public int maxDepth(TreeNode root) {
    if (root == null) return 0;
     int Left = maxDepth(root.left);
     int Right = maxDepth(root.right);
     return Math.max(Left,Right) + 1;
    }
```

## Same Tree
```java
 public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSymmetricTwoTree(p, q);
    }
    private boolean isSymmetricTwoTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {return true;}
        if (t1 == null || t2 == null) {return false;}
        if (t1.val != t2.val) {return false;}
        return isSymmetricTwoTree(t1.left, t2.left) && isSymmetricTwoTree(t1.right, t2.right);
    }
```
