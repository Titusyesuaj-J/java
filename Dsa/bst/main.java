package Dsa.bst;
import java.util.*;

import java.util.Stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        binarysearchtree res=new binarysearchtree();
        binarysearchtree bst1=new binarysearchtree();
        binarysearchtree bst2=new binarysearchtree();
        bst1.add(8);
        bst1.add(3);
        bst1.add(1);
        bst1.add(6);
        bst1.add(4);
        bst1.add(7);
        bst1.add(10);
        bst1.add(14);
        bst1.add(13);
        HashMap<Integer,Integer> hi=new HashMap<>();
        int[] p={3,9,20,15,7};
        int[] i={9,3,15,20,7};
        int[] x=new int[45];
        x[0]=565;
        x[1]=78;
        System.out.println(Arrays.toString(x));
        //System.out.println(bst1.construct_binarytree_from_pre_and_inorder(p,i,hi).val);
    }
}
