package recursion;

public class count_zeros {
    static int c=0;
    static int value=0;
    public static int count(int number){

        if (number==0){
            return c;
        } else if (number%2==0) {
            value=number/2;
            c=c+1;
        } else {
            value=number-1;
            c=c+1;
        }

        return count(value);
    }
}

