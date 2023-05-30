package randomproblems;

public class pow {
    public static void main(String[] args) {

        int x='0';
        int y=-10;
        System.out.println(x);
        ;
        if(y<0){
         //   System.out.println(1/power(2,10));
        }
        else{
         //   System.out.println(power(2,10));
        }

    }
    public static int power(int x,int y){
        if(y==0){
            return 1;
        }
        ////if y is even;
        if(y%2==0){
            return power(x*x,y/2);
        }
        ////if y is odd;
        else{
            return x*power(x,y-1);
        }
    }
}
