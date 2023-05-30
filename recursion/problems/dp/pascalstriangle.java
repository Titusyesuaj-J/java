package recursion.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascalstriangle {
    public static void main(String[] args) {
        int x=5;
        List<List<Long>> y=new ArrayList<>();
        List<Long> q = new ArrayList<>(Arrays.asList(1l));
        y.add(q);
        System.out.println(generate2(74,y));
    }
    public static List<List<Integer>> generate(int n,List<List<Integer>> y) {
        for(int i=1;i<n;i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if((j==0) || (j==i)){
                    sub.add(1);
                }
                else{
                    int q=y.get(i-1).get(j-1) + y.get(i-1).get(j);
                    sub.add(q);
                }
            }
            y.add(sub);
        }
        return y;
    }
    public static List<Long> generate2(int n, List<List<Long>> y) {
        for(int i=1;i<n;i++){
            List<Long> sub = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if((j==0) || (j==i)){
                    sub.add(1l);
                }
                else{
                    Long k=y.get(i-1).get(j-1) + y.get(i-1).get(j);
                    sub.add(k);
                }
            }
            y.add(sub);
        }
        return y.get(n-1);
    }
}
