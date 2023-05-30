package recursion.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ratinamaze {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int[][] input =
                       {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        maze("",input,0,0);
    }
    public static void maze(String s,int[][] input,int m,int n) {
        if ((m == 3 && n == 3) && (input[m][n]==1)) {
            System.out.println(s);
            return;
        }

        /////////////down//////////
        ////n<input.length////////  (rows )
        if (m < 3 && input[m][n] == 1) {
            input[m][n] = 0;
            maze(s + "D", input, m + 1, n);
            input[m][n] = 1;

        }
        /////////right///////////
        ///n<input[0].length///  (columns)
        if (n < 3 && input[m][n] == 1) {
            input[m][n] = 0;
            maze(s + "R", input, m, n + 1);
            input[m][n] = 1;
        }

        ///////////left/////////////
        if (n > 0 & input[m][n] == 1) {
            input[m][n] = 0;
            maze(s + "L", input, m, n - 1);
            input[m][n] = 1;

        }
        ///////////up///////////////////
        if (m > 0 && input[m][n] == 1) {
            input[m][n] = 0;
            maze(s + "U", input, m - 1, n);
            input[m][n] = 1;

        }
    }
}

