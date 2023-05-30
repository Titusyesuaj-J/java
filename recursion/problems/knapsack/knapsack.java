package recursion.problems.knapsack;

import static java.lang.Math.max;

public class knapsack {
    public static void main(String[] args) {
        int[] pw = {30, 10, 40,20}; //product weight
        int[] p = {10, 20, 30,40};  // profit
        int c=40; //space capacity
        System.out.println(knaptable(pw,p,c));



    }

    public static int knap(int[] pw,int p[],int c,int n){  //using recursion
        if((n==0) || (c==0)){
            return 0;
        }
        //reject
        if (pw[n-1]>c){
            int reject=knap(pw,p,c,n-1);
            return reject;
            //return knap(pw,p,c,n-1);
        }
        else{
            int accept=max(p[n-1]+knap(pw,p,c-pw[n-1],n-1),knap(pw,p,c,n-1));
            return accept;
            //return max(p[n-1]+knap(pw,p,c-pw[n-1],n-1),knap(pw,p,c,n-1));
        }
    }

    public static int dp(int[] pw,int p[],int c){
        int dp[][] = new int[pw.length+1][c+1];

        return knapmem(pw,p,c,pw.length,dp);
    }
    public static int knapmem(int[] pw,int p[],int c,int n,int[][]dp){  //using recursion


        if((n==0) || (c==0)){
            return 0;
        }
        if (dp[n][c]!=0){
            return dp[n][c];
        }
        //reject
        if (pw[n-1]>c){
            dp[n][c]=knapmem(pw,p,c,n-1,dp);
            //return knap(pw,p,c,n-1);
        }
        else{
            dp[n][c]=max(p[n-1]+knapmem(pw,p,c-pw[n-1],n-1,dp),knapmem(pw,p,c,n-1,dp));
            //return max(p[n-1]+knap(pw,p,c-pw[n-1],n-1),knap(pw,p,c,n-1));
        }

        return dp[n][c];
    }

    //  remainder always subtract previous row space- respective row weight!!!!!!!!!!!!!!
    public static int knaptable(int[] pw,int p[],int c){
        int[][] table = new int[pw.length+1][c+1];
        for (int i = 0; i < pw.length + 1; i++) {

            for (int j = 0; j < c + 1; j++) {

                if(i==0 || j==0){
                    table[i][j]=0;
                }
                else if (pw[i-1]>j) {
                    table[i][j]=table[i-1][j];
                }
                else{
                    table[i][j]=max(table[i-1][j],p[i-1]+table[i-1][j-pw[i-1]]);
                }
            }
        }
        return table[pw.length][c];
    }
}