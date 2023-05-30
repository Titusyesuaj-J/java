package recursion.problems.knapsack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

  //

public class subset {
    public static void main(String[] args) {
        System.out.println(subsetarray("","abc"));
        //subset("","abcdefhij");
        String k=" ";
        System.out.println(k.length());
        System.out.println(res.size());
        HashSet<String> hs=new HashSet<>();


    }
    static List<String> res = new ArrayList<>();
    static void subset(String x, String y){

        if (y.isEmpty() && x.isEmpty()){
            return;
        }
        if(y.isEmpty()){
            res.add(x);
            return;
        }
        String q=x+y.charAt(0);

        subset(q,y.substring(1));
        subset(x,y.substring(1));
    }

    //with array inside function!!!!!!!!
    static ArrayList<String> subsetarray(String x, String y){

        if (y.isEmpty() && x.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            return list;
        }

        if(y.isEmpty()){
            ArrayList<String> list=new ArrayList<String>();
            list.add(x);
            return list;
        }
        String q=x+y.charAt(0);

        ArrayList<String>left = subsetarray(q,y.substring(1));
        ArrayList<String>right=subsetarray(x,y.substring(1));

        left.addAll(right);
        return left;
    }
}


