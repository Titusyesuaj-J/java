package recursion.sort;

//int s,e;
     //   int a[]={11,23,45,12,32,90,80,60};
     //   s=0;
      //  e=7;
      //  quick(a,s,e);
       // System.out.println(Arrays.toString(a));
public class quick {
    public static int partition(int[] a,int s,int e){
        int pivot=a[e];
        int p_index=s;
        int c;
        for(int i=s;i<e;i++){
            if(a[i]<pivot){
                c=a[p_index];
                a[p_index]=a[i];
                a[i]=c;
                p_index=p_index+1;
            }
        }
        c=a[p_index];
        a[p_index]=a[e];
        a[e]=c;
        return p_index;
    }
    public static void quick(int[] a,int s,int e) {

        if(s>=e){
            return;
        }

        int pivot = partition(a, s, e);
        quick(a, 0, pivot - 1);
        quick(a, pivot + 1, e);

    }
}
