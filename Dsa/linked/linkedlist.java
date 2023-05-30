package Dsa.linked;

public class linkedlist {
    public node head;
    public node tail;
    public int size;
    public linkedlist(){
        this.size=0;
    }
    public static class node {
        int value;
        node next;
        public node(int x){
            this.value=x;
            this.next=null;
        }
    }
    public void addatend(int x){
        node newnode=new node(x);
        if (head==null){
            head=newnode;
        }
        else{
            node n=head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=newnode;
        }
        size++;
    }
    public void addat(int index,int x){
        node newnode=new node(x);
        node n=head;
        if(index==0){
            addatfirst(x);
        }
        else {
            while (n.next != null) {
                if (index - 1 == 0) {
                    newnode.next = n.next;
                    n.next = newnode;
                    size++;
                    break;
                }
                n=n.next;
                index--;
            }
        }
    }
    public void addatfirst(int x){
        node newnode=new node(x);
        newnode.next=head;
        head=newnode;
        size++;
    }
    public void transverse(){
        node n=head;
        if (n==null){
            System.out.println("the ll is empty");
        }
        else{
            while(n!=null){
                System.out.print(n.value+"---->");
                n=n.next;
            }
        }
    }
}
