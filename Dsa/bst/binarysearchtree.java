package Dsa.bst;


import java.util.*;

public class binarysearchtree {
    node root = null;

    public class node {
        node left;
        node right;
        int val;

        public node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public void add(int x) {
        node n = new node(x);
        n.val=x;
        if (root == null) {
            root = n;
        } else {
            insert(root, n);
        }
    }

    //change  //node to be inserted
    public node insert(node n, node x) {
        if (n == null) {
            return x;
        }
        if (n.val < x.val) {
            n.right = insert(n.right, x);
        } else {
            n.left = insert(n.left, x);
        }
        return n;
    }

    public void deletenode(int target) {
        delete(target, root, null);
    }

    public void delete(int target, node n, node prev) {
        if (n.val == target) {////no child nodes;
            if ((n.left == null) && (n.right == null)) {
                if (prev.right == n) {
                    prev.right = null;
                } else {
                    prev.left = null;
                }
                return;
            } else if ((n.left != null) && (n.right == null)) { ///one child node
                prev.right = n.left;
                return;
            } else if ((n.right != null) && (n.left == null)) { ////one child node
                prev.left = n.right;
                return;
            } else { ////two child node
                int flag = 0; /////target is in right of previous
                node left = n.left;
                node right = n.right;
                if (prev.left.val == target) { ///target is in left of previous
                    flag = 1;
                }
                n = n.right;
                if (n.left == null) {
                    prev.right = n;
                } else {
                    while (n.left.left != null) {
                        n = n.left;
                    }
                    node least = n.left;
                    least.left = left;
                    least.right = right;
                    n.left = null;
                    if (flag == 0) {
                        prev.right = least;
                    } else {
                        prev.left = least;
                    }
                }
                return;
            }

        }
        if (n.val > target) {
            delete(target, n.left, n);
        } else {
            delete(target, n.right, n);
        }
    }

    ///recursion
    public void inordertransverse(node n) {
        if ((n.left == null) && (n.right == null)) {
            System.out.println(n.val);
            return;
        }
        if ((n.left != null) && (n.right != null)) {
            inordertransverse(n.left);
            System.out.println(n.val);
            inordertransverse(n.right);
            return;
        }
        if (n.left == null) {
            System.out.println(n.val);
            inordertransverse(n.right);
        }
        if (n.right == null) {
            inordertransverse(n.left);
            System.out.println(n.val);
        }
    }
    public void inordertrans2(node n){
        if(n==null){
            return;
        }
        inordertrans2(n.left);
        System.out.println(n.val);
        inordertrans2(n.right);
    }


    public void inordertran3(node n) {
        Stack<node> s = new Stack<>();
        s.add(n);
        node p;
        n = n.left;
        while (true) {
            while (n != null) {
                s.push(n);
                n = n.left;
            }
            if (s.isEmpty()) {
                break;
            }
            p = s.pop();
            System.out.println(p.val);
            n = p.right;
        }
    }

    public void preordertransverse(node n) {
        System.out.println(n.val);
        if ((n.left == null) && (n.right == null)) {
            return;
        }
        if ((n.left != null) && (n.right != null)) {
            preordertransverse(n.left);
            preordertransverse(n.right);
            return;
        }
        if (n.left == null) {
            preordertransverse(n.right);
        }
        if (n.right == null) {
            preordertransverse(n.left);
        }
    }

    public void postordertransverse(node n) {
        if ((n.left == null) && (n.right == null)) {
            System.out.println(n.val);
            return;
        }
        if ((n.left != null) && (n.right != null)) {
            postordertransverse(n.left);
            postordertransverse(n.right);
            System.out.println(n.val);
            return;
        }
        if (n.left == null) {
            postordertransverse(n.right);
            System.out.println(n.val);
        }
        if (n.right == null) {
            postordertransverse(n.left);
            System.out.println(n.val);
        }
    }

    public void levelordertransverse(node n) {
        Queue<node> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            node sample = q.poll();
            System.out.println(sample.val);
            if ((sample.left != null) && (sample.right != null)) {
                q.add(sample.left);
                q.add(sample.right);
            } else if (sample.left != null) {
                q.add(sample.left);
            } else if (sample.right != null) {
                q.add(sample.right);
            }
        }
    }

    public node invert(node n) {
        if (n == null) {
            return n;
        } else if ((n.left == null) && (n.right == null)) {
            return n;
        } else {
            if ((n.left != null) && (n.right != null)) {
                node left = invert(n.left);
                node right = invert(n.right);
                n.left = right;
                n.right = left;
            } else if (n.right == null) {
                node left = invert(n.left);
                node right = null;
                n.left = right;
                n.right = left;
            } else {
                node left = null;
                node right = invert(n.right);
                n.left = right;
                n.right = left;
            }

            return n;
        }
    }

    public int height(node n, int res) {
        if (n == null) {
            res = res - 1;
            return res;
        }
        return Math.max(height(n.left, res + 1), height(n.right, res + 1));
    }

    public int balance(node n) {
        if (n == null) {
            return 0;
        }
        int left = balance(n.left);
        if (left == -1) {
            return -1;
        }
        int right = balance(n.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public Boolean sametree(node n1, node n2) {
        Boolean left, right;
        if ((n1 == null) && (n2 == null)) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        } else if (n1.val == n2.val) {
            left = sametree(n1.left, n2.left);
            right = sametree(n1.right, n2.right);
        } else {
            return false;
        }
        if (!left || !right) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean subtree(node n1, node n2) {
        if (n1 == null) {
            return false;
        }
        else if (n1.val != n2.val) {
            Boolean left = subtree(n1.left, n2);
            Boolean right = subtree(n1.right, n2);
            if (left==true || right==true) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return after(n1, n2);
        }
    }

    public Boolean after(node n1, node n2) {
        if ((n1 == null) && (n2 == null)) {
            return true;
        }
        if (((n1 == null) && (n2 != null)) || ((n1 != null) && (n2 == null))) {
            return false;
        }
        if (n1.val == n2.val) {
            Boolean left = after(n1.left, n2.left);
            Boolean right = after(n1.right, n2.right);
            if (!left || !right) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int ancestor(node n,int target){
        if(n==null){
            return 0;
        }
        if(n.val==target){
            return 1;
        }
        int left=ancestor(n.left,target);
        int right=ancestor(n.right,target);
        if(left==1||right==1){
            System.out.println(n.val);
            return 1;
        }
        else{
            return 0;
        }
    }
    public List<Integer> leftview(node n,int count,List<Integer> res){
        if(n==null){
            return res;
        }
        if(count==res.size()){
            res.add(n.val);
        }
        leftview(n.left,count+1,res);
        leftview(n.right,count+1,res);
        return res;
    }

    public int goodnodes(node n,int prev){
            if(n==null){
                return 0;
            }
            if(n.val>=prev){
                return 1+goodnodes(n.left,Math.max(n.val,prev))+goodnodes(n.right,Math.max(n.val,prev));
            }
            else{
                return goodnodes(n.left,prev)+goodnodes(n.right,prev);
            }
        }
//////////////////////////////
    public boolean isValidBST(node root) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return validbst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }
    public boolean validbst(node n,int min,int max){
        if(n==null){
            return true;
        }
        if(n.val>min && n.val<max){
            Boolean left=validbst(n.left,min,n.val);
            Boolean right=validbst(n.right,n.val,max);
            if(!left||!right){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    ///////////////////////////
    public int kthsmallest(node n,int k){
        if(n==null){
            return 0;
        }
        int left=kthsmallest(n.left,k);
        if(left!=0){
            return left;
        }
        k=k-1;
        int right=kthsmallest(n.right,k);
        return right;
    }
                                                                /////    hashmap for array i
    public node construct_binarytree_from_pre_and_inorder(int[] p,int[] i,HashMap<Integer,Integer> hi) {
        for (int j = 0; j < i.length; j++) {
            hi.put(i[j], j);
        }
        for (int k = 0; k < p.length; k++) {
            if (hi.containsKey(p[k])) {
                int element = p[k];
                int index = hi.get(p[k]);

                node n = new node(element);
                if (i.length != 0) {
                    hi.clear();
                    n.left = construct_binarytree_from_pre_and_inorder(p, Arrays.copyOfRange(i, 0, index), hi);
                    n.right = construct_binarytree_from_pre_and_inorder(p, Arrays.copyOfRange(i, index + 1, i.length), hi);
                }
                return n;
            }
        }
        return null;
    }
}

