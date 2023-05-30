package Dsa;

public class Linkedlist {

    Node Head;

    public void add(int x){
        Node node = new Node();
        node.data=x;
        node.next=null;

        if (Head==null){
            Head=node;
        }
        else{
            Node n = Head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }

    }
    public void display(){
        Node n = Head;
        while(n.next!=null){
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }

    public void addatstart(int x){
        Node node = new Node();
        node.data=x;
        node.next=null;

        if (Head==null){
            Head=node;
        }

        else{
            Node n = Head;
            node.next=n;
            Head=node;
        }

    }
    public void addat(int index ,int value){
        Node node = new Node();
        node.data=value;
        node.next=null;
        Node n = Head;
        Node current=null;

        if (index==0){
            node.next=n;
            Head = node;
        }
        else{
        for(int i=0;i<index;i++){
            current = n;
            n=n.next;
        }
        current.next=node;
        node.next=n;
    }
    }

    public void delete(int index) {
        Node n = Head;
        Node prev = null;

        if (index == 0) {
            Head=n.next;

        } else {

            for (int i = 0; i < index; i++) {
                prev = n;
                n = n.next;
            }
            prev.next = n.next;
        }
    }
}
