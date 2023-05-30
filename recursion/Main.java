package recursion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int x=1;
        number(x);

    }


    public static void number(int n){
        if(n==6){
            return;
        }
        System.out.println(n);
        number(n+1);
    }
}







