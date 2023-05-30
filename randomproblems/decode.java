package randomproblems;

import java.util.Stack;

public class decode {
    public static void main(String[] args) {
        String x = "3[a]2[bc]";
        StringBuilder k = new StringBuilder();
        k.append(x);
        System.out.println(Decode(x));
    }

    public static String Decode(String x){
        String res="";
        Stack<String> s=new Stack<>();
        for(int i=0;i<x.length();i++){
            String str="";
            String n="";
            if(x.charAt(i)==']'){
                while(true) {
                    String k=String.valueOf(s.pop());
                    if(k.equals("[")) {
                        break;
                    }
                    str=k+str;
                }
                while(s.size()>0 && (s.peek().charAt(0)>='0' && s.peek().charAt(0)<='9')){
                    String k=s.pop();
                    n=k+n;
                }

                String dup=str;
                for(int k=0;k<Integer.parseInt(n)-1;k++){
                    str=dup+str;
                }
                s.push(str);
            }
            else{
                s.push(Character.toString(x.charAt(i)));
            }

        }
        while(!s.isEmpty()){
            res=s.pop()+res;
        }
        return res;
    }
    public static String decode(StringBuilder x) {
        while (true) {
            int s = 0;
            int e = 0;
            for (int i = 0; i < x.length(); i++) {
                char n = x.charAt(i);
                if (n >= '0' && n <= '9') {
                    s = i;
                }
                if (x.charAt(i) == ']') {
                    e = i + 1;
                    break;
                }
            }
            if (s == 0 && e == 0) {
                break;
            }
            String r = x.substring(s + 2, e - 1);
            String k = r;
            for (int j = 0; j < Integer.parseInt(String.valueOf(x.charAt(s)))-1; j++) {
                r = r + k;
            }
            x.replace(s, e, r);
        }
        String res = x.substring(0);
        return res;
    }
}
