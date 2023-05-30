package Dsa;

public class Main {


    public static void main(String[] args) {
        dLinkedlist x = new dLinkedlist();
        x.add(44);
        x.add(88);
        x.add(99);
        x.add(1000);
        x.addat(0,1989);
        x.print();
        System.out.println(x.Head.data);
    }

}

