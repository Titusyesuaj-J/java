package randomproblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class productarrayexceptcurrent {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j]!='.'){
                    Boolean res=check(board[i][j],i,j,hs);
                    if(!res){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check(int element,int i,int j, HashSet<String> hs){
        String rows=element+"in row "+i;
        String col=element+"in col "+j;
        String box=element+"in box "+((i/3)*3+(j/3));
        if(!hs.contains(rows)){
            hs.add(rows);
        }
        else{
            return false;
        }
        if(!hs.contains(col)){
            hs.add(col);
        }
        else{
            return false;
        }
        if(!hs.contains(box)){
            hs.add(box);
        }
        else{
            return false;
        }
        return true;
    }

   // public static int[] test(int[] x){

    //}
}
