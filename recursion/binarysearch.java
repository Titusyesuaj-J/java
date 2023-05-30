package recursion;

 // int x[] = new int[7];
    //      x[0]=4;
     ///     x[1]=8;
     //     x[2]=12;
     //     x[3]=24;
      //    x[4]=42;
       //   x[5]=50;
     //     x[6]=52;
     //     int start=0;
     //     int end=(x.length)-1;


public class binarysearch {
    public static int binarysearch(int start,int end,int a[]){
        int mid;
        mid=(start+end)/2;

        if (a[mid]==12){
            System.out.println(12+"  is Found!!");
            return mid;
        }
        else if (start>end) {
            System.out.println("required element is not found");
            return -1;
        }
        else if (a[mid]>12) {
            end=mid-1;
            return binarysearch(start,end,a);
        }
        else{
            start=start+1;
            return binarysearch(start,end,a);
        }

    }
}

