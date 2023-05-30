package recursion.sort;

import java.util.Arrays;

 //int arr[]={1,44,33,2,4,66,41};
     //    arr=mergesort(arr);
     //    System.out.println(Arrays.toString(arr));
public class merge {
    public static int[] mergesort(int[] arr){
        int mid=(arr.length)/2;
        if(arr.length==1){
            return arr;
        }
        int[] left= mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge1(left,right);
    }

    public static int[] merge1(int[] l,int[] r) {
        int[] m = new int[l.length + r.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                m[k] = l[i];
                k++;
                i++;
            } else {
                m[k] = r[j];
                k++;
                j++;
            }
        }
        while (i < l.length) {
            m[k] = l[i];
            k++;
            i++;
        }
        while (j < r.length) {
            m[k] = r[j];
            k++;
            j++;
        }

        return m;
    }

}
