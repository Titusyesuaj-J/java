package flight;

import java.util.Scanner;

public class flights {

    static Integer available_flight1_tickets=50;
    static Integer flight1_ticket_price=5000;
    public void flight1(){
        System.out.println("flight ID 1 --Remaining Tickets "+available_flight1_tickets+" --Current ticket Price "+flight1_ticket_price);
        System.out.println("Enter number of Tickets:");
        Scanner scn = new Scanner(System.in);
        Integer ticket,totalprice;
        ticket = scn.nextInt();
        totalprice=ticket*flight1_ticket_price;
        available_flight1_tickets = available_flight1_tickets - ticket;
        flight1_ticket_price = flight1_ticket_price + (ticket * 200);
        System.out.println("Booked Successfully!!!");
        System.out.println("flight ID 1 --Remaining Tickets "+available_flight1_tickets+" --Current ticket Price "+flight1_ticket_price);
        System.out.println("flight ID 1->");
        System.out.println("Passenger ID 1 -- Number of Tickets Booked "+ticket+" -- Total cost "+totalprice);
    }
}
