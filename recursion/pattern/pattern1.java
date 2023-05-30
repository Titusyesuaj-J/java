package recursion.pattern;

public class pattern1 {
    public static void pattern1(int rows,int col){

        if(rows==0){
            return;
        }
        if(rows>col){
            System.out.print("* ");
            pattern1(rows, col+1);
        }
        else{
            System.out.println("");
            pattern1(rows-1,0);
        }
    }
}
