package recursion.pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(s());
        }

    public static int s() {
        Integer sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + i;

        }
        return sum;
    }

}
