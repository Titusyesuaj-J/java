package recursion;

public class sum_of_number {
    public static int sum(int n) {
        int div,rem;
        if(n==0){
            return 1 ;
        }
        div=n/10;
        rem=n%10;

        return rem*sum(div);

    }
}
