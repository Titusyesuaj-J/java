package randomproblems;

import java.util.Arrays;

public class rotate2d {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        int x[][]=rotate(arr);
        for(int i=0;i<x.length;i++){
            System.out.println(Arrays.toString(x[i]));
        }

    }
    /////using extra space brute force
    public static int[][] rot(int arr[][]){
        int a[][]=new int[3][3];
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                a[j][2-i]=a[i][j];
            }
        }
        return a;

    }
    public static int[][] rotate(int arr[][]) {
        ////transpose of matrix
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[0].length;j++){
                int x=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=x;
            }
        }
        ////reverse the array
        for(int i=0;i< arr.length;i++){
            int x=0;
            int y=arr[0].length-1;
            while(x<y){
                int d=arr[i][x];
                arr[i][x]=arr[i][y];
                arr[i][y]=d;
                x++;
                y--;
            }
        }
        return arr;
    }
}
