package Dsa;
public class dLinkedlist {
    lnode Head;
    Integer count=0;
    public void add(int x) {
        lnode node = new lnode();
        node.data = x;
        node.next = null;
        node.prev = null;
        count = count + 1;
        if (Head == null) {
            Head = node;
        } else {
            lnode n = Head;

            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
            node.prev = n;
        }
    }
        public void addcircular(int x){
            lnode node = new lnode();
            node.data=x;
            node.next=null;
            node.prev=null;
            count=count+1;
            if (Head==null){
                Head=node;
            }
            else{
                lnode n = Head;

                while(n.next!=null){
                    n=n.next;
                }
                n.next=node;
                node.prev=n;
            }


    }

    public void addat(int index,int value){
        lnode node = new lnode();
        node.data=value;
        node.prev=null;
        node.next=null;
        lnode prev=null;
        count=count+1;
        lnode n = Head;

        if(index==0){
            n.prev=node;
            node.next=Head;
            Head=node;

        }
        else{

            for(int i=0;i<index;i++){
                prev=n;
                n=n.next;
            }
            prev.next=node;
            node.prev=prev;
            node.next=n;
            n.prev=node;
        }
    }

    public void print(){
        lnode n = Head;
        for(int i=0;i<count;i++){
            System.out.println(n.data);
            n=n.next;
        }
    }
}
