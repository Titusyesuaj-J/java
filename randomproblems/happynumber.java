package randomproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class happynumber {
    public static void main(String[] args) {
        int n=29;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(1,1);
        hm.put(2,2);
        hm.remove(1);
        System.out.println(hm);
        //System.out.println(happy(n,hm));

    }
    public static boolean happy(int n,HashMap<Integer,Integer> hm){
        while(n!=1){
            if(!hm.containsKey(n)){
                int store=n;
                n=helper(n);
                hm.put(store,n);
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static int helper(int n){
        int res=0;
        int rem;
         while(n!=0){
             rem=n%10;
             n=n/10;
           res=res+(int)Math.pow(rem,2);
       }
        return res;
    }
}
