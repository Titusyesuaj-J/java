package Dsa;

public class Stack {
    int stack[] = new int[5];
    int back,store=-1;

    public void push(int i) {

        stack[back] = i;
        back=back+1;

    }

    public void pop(){

        back=back-1;
        return;
    }

    public boolean isempty(){
        return back==0;
    }
    public void size(){
        System.out.println(back);
    }

    public void peek(){
        int x = stack[back-1];
        System.out.println(x);
    }

    public void print(){
        System.out.println("queue: ");
        for(int i=0;i<back;i++){
            System.out.print(stack[i]+" ");
        }
    }





}
