package randomproblems;

import java.util.*;

public class validparanthesis {
    public static void main(String[] args) {
        String[] j={"4","13","5","/","+"};
        System.out.println(evalRPN(j));
        // System.out.println(isValid(j));
    }
    public static int evalRPN(String[] tokens) {
        int z,y;
        Stack<Integer> s=new Stack<>();
        for(String x:tokens){
            if(x!="*"&&x!="/"&&x!="+"&&x!="-"){
                s.push(Integer.parseInt(x));
            }
            else{
                if(s.size()>=2){
                    switch(x){
                        case "+":
                            z=s.pop();
                            y=s.pop();
                            s.push(y+z);
                            break;
                        case "-":
                            z=s.pop();
                            y=s.pop();
                            s.push(y-z);
                            break;
                        case "*":
                            z=s.pop();
                            y=s.pop();
                            s.push(y*z);
                            break;
                        case "/":
                            z=s.pop();
                            y=s.pop();
                            s.push(y/z);
                            break;
                    }
                }
            }
        }
        return s.peek();
    }
}
