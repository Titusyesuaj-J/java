package flight;

import java.util.Scanner;

public class Main {
    public static void bookingticket(){
        System.out.println("Enter Flight ID:");
        Scanner scn= new Scanner(System.in);
        flights f = new flights();
        Integer choice;
        choice=scn.nextInt();
        switch (choice){
            case 1:
                f.flight1();
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid Flight ID");
                break;

        }
    }
    public static void main(String[] args) {
        Boolean loop =true;
        while(loop){
            Scanner scn= new Scanner(System.in);
            System.out.println("1.Book \n2.Cancel \n3.Print");
            Integer choice;
            choice=scn.nextInt();

            while(true){
                switch (choice){
                    case 1:
                        bookingticket();
                        break;
                }
            }
        }
    }

}
