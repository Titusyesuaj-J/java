package Dsa;

public class Queue {
   int q[]= new int[5];
   int end,start,size;

   public void enq(int x){

       if (isfull()){
           System.out.println("Queue is full");
       }
       else{
            q[end] = x;
            end = (end + 1) % 5;
            size = size + 1;
       }
   }
   public boolean isfull(){
       return size==5;
   }

   public boolean isempty(){
       return size==0;
   }
   public void deq() {

       if (isempty()){
           System.out.println("Queue is empty");
       }
       else {
           int first = q[start];
           start = (start + 1) % 5;
           size=size-1;
       }

   }
   public void display() {
        for(int i=0;i<size;i++){
            System.out.println(q[(start+i)%5]);
        }
   }
}
