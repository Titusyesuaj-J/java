package recursion;


public class rev {
    public static int sum;
    public static int rev(int n) {
        int rem, div;
        if (n == 0) {
            return sum;
        }
        rem = n % 10;
        div = n / 10;
        sum = (sum * 10) + rem;
        return rev(div);

    }

    int n = 1984;
    int k= (int)Math.log10(n)+1;

    int x= (int)Math.pow(10,k-1);
    ////

}
