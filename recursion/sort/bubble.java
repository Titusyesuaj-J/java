package recursion.sort;

public class bubble {
    public static void main(String[] args) {
        int[] arr = {24,23,45,11,20,1};
        int len=arr.length;
        int[] res=bubble2(arr,len);
        for(int i=0;i<res.length;i++){
            System.out.println(arr[i]);
        }
    }


  //  int row=0;
 //   int col=0;
   // int k[]=bubble(arr,len,row,col);
    //    for(int i=0;i<len;i++){
    //    System.out.println(k[i]);
    //}


    public static int[] bubble(int[] arr,int len,int row,int col){
        int store;
        if(row==len-1){
            return arr;
        }
        if(row+col==len-1){
            return bubble(arr,len,row+1,0);
        }
        else{
            if (arr[col]>arr[col+1]){
                store=arr[col];
                arr[col]=arr[col+1];
                arr[col+1]=store;
            }
            return bubble(arr,len,row,col+1);
        }
    }

    public static int[] bubble2(int[] arr,int size){
        int store;
        for(int i=size-2;i>=0;i--){
            for (int j=0;j<=i;j++){
                if (arr[j]>arr[j+1]){
                    store=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=store;
                }
            }
        }
        return arr;
    }
}

