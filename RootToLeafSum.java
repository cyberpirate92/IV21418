public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> x = traverse(A, B, 0);
        if (x == null)
            x = new ArrayList<ArrayList<Integer>>();
        else {
            for(ArrayList<Integer> l: x) {
                Collections.reverse(l);
            }
        }
        return x;
    }
    
    public ArrayList<ArrayList<Integer>> traverse(TreeNode A, int totalSum, int partialSum) {
        if (isLeafNode(A)) {
            if (partialSum + A.val == totalSum) {
                ArrayList<Integer> pathList = new ArrayList<Integer>();
                pathList.add(A.val);
                
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                list.add(pathList);
                return list;
            }
            else {
                return null;
            }
        }
        else {
            ArrayList<ArrayList<Integer>> leftList = null, rightList = null;
            if (A.left != null)
                leftList = traverse(A.left, totalSum, A.val + partialSum);
            if (A.right != null)
                rightList = traverse(A.right, totalSum, A.val+partialSum);
            
            if (leftList == null && rightList == null) {
                return null;
            }
            
            ArrayList<ArrayList<Integer>> mergedList = null;
            if (leftList != null) {
                for(ArrayList<Integer> l: leftList) {
                    l.add(A.val);
                    if (mergedList == null) {
                        mergedList = new ArrayList<ArrayList<Integer>>();
                    }
                    if (l != null)
                        mergedList.add(l);
                }
            }
            if (rightList != null) {
                for (ArrayList<Integer> l: rightList) {
                    l.add(A.val);
                    if (mergedList == null) {
                        mergedList = new ArrayList<ArrayList<Integer>>();
                    }
                    if (l != null)
                        mergedList.add(l);
                }
            }
            return mergedList;
        }
    }
    
    public boolean isLeafNode(TreeNode t) {
        return t.left == null && t.right == null;
    }
}