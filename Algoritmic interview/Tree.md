# Tree

+ [Binary Tree Inorder Traversal](#Binary-Tree-Inorder-Traversal)
+ [Symmetric Tree](#Symmetric-Tree)
+ [Maximum Depth](#Maximum-Depth)
+ [Same Tree](#Same-Tree)
+ [Invert Binary Tree](#Invert-Binary-Tree)
+ [Path Sum](#Path-Sum)

## Обход Inorder ( практика ):
Алгоритм Inorder (дерево)
```
   1 Пройдите по левому поддереву, т.е. вызовите Inorder (левое поддерево)
   2 Посетите корень.
   3 Пройдите по правому поддереву, т.е. вызовите Inorder (правое поддерево)
```
## Preorder Traversal
```text
   1. Посетите корень. 
   2. Пройдите по левому поддереву, т.е. вызовите предзаказ (левое поддерево) 
   3. Пройдите по правому поддереву, то есть вызовите предзаказ (правое поддерево)
```
## Postorder Traversal
```
   1. Обход левого поддерева, т. Е. Вызов Postorder (левое поддерево) 
   2. Обход правого поддерева, т. Е. Вызов Postorder (правое поддерево) 
   3. Посетите корень.
```

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
## Рекурсивная реализация
```java
     public boolean isSymmetric(TreeNode root) {
          return check(root, root);
    }

   public boolean check(TreeNode nodeLeft, TreeNode nodeRight) {
       if (nodeLeft == null && nodeRight == null) {return true;}
       if (nodeLeft == null || nodeRight == null) {return false;}
       if (nodeLeft.val != nodeRight.val) {return false;}
       return check(nodeLeft.left, nodeRight.right);
    
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
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

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
## Invert Binary Tree
Invert a binary tree.
```java
   public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
```

## Path Sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum
```java
public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {return false;}
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }
```
