package randomproblems;

import java.util.ArrayList;
import java.util.List;

public class generateparanthesies {
    public static void main(String[] args) {
        int x=8;
        List<String> y=new ArrayList<>();
        generateParenthesis(x,x,"",y);
        System.out.println(y);
    }
    public static void generateParenthesis(int o,int c,String x, List<String> res) {
        if(o==0 && c==0){
            res.add(x);
            return;
        }
        if(o==c){
            generateParenthesis(o-1,c,x+"(",res);
        }
        else if(o==0 && c!=0){
            generateParenthesis(o,c-1,x+")",res);
        }
        else{
             generateParenthesis(o-1,c,x+"(",res);
             generateParenthesis(o,c-1,x+")",res);
        }
    }
}
