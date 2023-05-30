package project;

import java.util.Scanner;
import project.Passenger;
public class Main {

    public static void bookingticket(String name,Integer age,String berth){
        Passenger p = new Passenger(name,age,berth);
        Ticketbooking tb= new Ticketbooking();

        if (berth.equals("L") && tb.positionlowerberth.size() > 0) {

            p.alloted=berth;
            p.number=tb.positionlowerberth.get(0); //1
            tb.positionlowerberth.remove(0);
            tb.availablelowerberth--;
            tb.passengers.put(p.passengerid,p);
            tb.bookedtickets.add(p.passengerid);
            System.out.println("Preferred Berth Available" );
            System.out.println("Lower Berth Given" );
            System.out.println("----------------Booked Successfully");


        } else if (berth.equals("M" ) && tb.positionmiddleberth.size() > 0) {

            p.alloted = berth;
            p.number = tb.positionmiddleberth.get(0);
            tb.passengers.put(p.passengerid, p);
            tb.bookedtickets.add(p.passengerid);


            tb.positionmiddleberth.remove(0);
            tb.availablemiddleberth--;
            System.out.println("Preferred Berth Available" );
            System.out.println("Middle Berth Given" );
            System.out.println("----------------Booked Successfully" );

        } else if (berth.equals("U") && tb.positionupperberth.size() > 0) {

            p.alloted = berth;
            p.number = tb.positionupperberth.get(0);
            tb.positionupperberth.remove(0);
            tb.availableupperberth--;
            tb.passengers.put(p.passengerid, p);
            tb.bookedtickets.add(p.passengerid);
            System.out.println("Preferred Berth Available" );
            System.out.println("Upper Berth Given" );
            System.out.println("----------------Booked Successfully" );

        } else if (tb.positionlowerberth.size() > 0) {

            p.alloted="L";
            p.number=tb.positionlowerberth.get(0); //1
            tb.positionlowerberth.remove(0);
            tb.availablelowerberth--;
            tb.passengers.put(p.passengerid,p);
            tb.bookedtickets.add(p.passengerid);
            System.out.println("Sorry preferred berth not available moved to next priority berth" );
            System.out.println("Lower Berth Given" );
            System.out.println("----------------Booked Successfully" );

        } else if ( tb.positionmiddleberth.size() > 0) {

            p.alloted = "M";
            p.number = tb.positionmiddleberth.get(0);
            tb.passengers.put(p.passengerid, p);
            tb.bookedtickets.add(p.passengerid);
            tb.positionmiddleberth.remove(0);
            tb.availablemiddleberth--;
            System.out.println("Sorry preferred berth not available moved to next priority berth" );
            System.out.println("Middle Berth Given" );
            System.out.println("----------------Booked Successfully" );

        } else if  (tb.positionupperberth.size() > 0) {

            p.alloted = "U";
            p.number = tb.positionupperberth.get(0);
            tb.positionupperberth.remove(0);
            tb.availableupperberth--;
            tb.passengers.put(p.passengerid, p);
            tb.bookedtickets.add(p.passengerid);
            System.out.println("Sorry preferred berth not available moved to next priority berth ");
            System.out.println("Upper birth Given" );
            System.out.println("----------------Booked Successfully" );

        } else if (tb.positionrac.size() > 0)  {

            p.alloted = "RAC";
            p.number = tb.positionrac.get(0);
            tb.passengers.put(p.passengerid, p);
            tb.raclist.add(p.passengerid);
            tb.positionrac.remove(0);
            tb.availableRAC--;
            System.out.println("Sorry preferred berth is not available moved to RAC" );
            System.out.println("RAC Given" );
            System.out.println("----------------Booked Successfully" );

        }
        else if (tb.positionwaitinglist.size() > 0) {
            p.alloted = "WL";
            p.number = tb.positionwaitinglist.get(0);
            tb.passengers.put(p.passengerid, p);
            tb.wllist.add(p.passengerid);
            tb.positionwaitinglist.remove(0);
            tb.availablewaitinglist--;
            System.out.println("Waiting list Given" );
            System.out.println("----------------Booked Successfully" );
        }
        else  {
            System.out.println("Sorry!!! no Tickets available" );
        }
    }
    public static void cancelticket(Integer p_id){

        Ticketbooking tb = new Ticketbooking();
        Passenger p = tb.passengers.get(p_id);
        tb.bookedtickets.remove(p_id);

        System.out.println("Ticket cancellation is successfull");
        // removing part is done!!!


        if (p.alloted.equals("L")) {
            tb.positionlowerberth.add(p.number);
            tb.availablelowerberth++;
            tb.passengers.remove(p_id);
        }
        else if (p.alloted.equals("M")) {
            tb.positionmiddleberth.add(p.number);
            tb.availablemiddleberth++;
            tb.passengers.remove(p_id);
        }
        else if (p.alloted.equals("U")) {
            tb.positionupperberth.add(p.number);
            tb.availableupperberth++;
            tb.passengers.remove(p_id);
        }
        if (tb.raclist.size() > 0) {
            Integer save;
            save = tb.raclist.poll();
            Passenger replace = tb.passengers.get(save);
            tb.positionrac.add(replace.number);
            tb.availableRAC++;

            if (p.alloted.equals("L")) {
                replace.alloted = "L";
                replace.number = tb.positionlowerberth.get(tb.positionlowerberth.size() - 1); //1
                replace.name=p.name;
                replace.age=p.age;
                replace.berthpreference=p.berthpreference;
                tb.positionlowerberth.remove(0);
                tb.availablelowerberth--;
                tb.passengers.put(p.passengerid, p);
                tb.bookedtickets.add(p.passengerid);
                System.out.println("RAC moved to lower berth");
                tb.passengers.remove(p_id);

            } else if (p.alloted.equals("M")) {

                replace.alloted = "M";
                replace.number = tb.positionmiddleberth.get(tb.positionmiddleberth.size() - 1);
                replace.name=p.name;
                replace.age=p.age;
                replace.berthpreference=p.berthpreference;
                tb.passengers.put(p.passengerid, p);
                tb.bookedtickets.add(p.passengerid);
                tb.positionmiddleberth.remove(0);
                tb.availablemiddleberth--;
                System.out.println("RAC moved to Middle berth");
                tb.passengers.remove(p_id);

            } else if (p.alloted.equals("U")) {

                replace.alloted = "U";
                replace.number = tb.positionupperberth.get(tb.positionupperberth.size() - 1);
                replace.name=p.name;
                replace.age=p.age;
                replace.berthpreference=p.berthpreference;
                tb.passengers.put(p.passengerid, p);
                tb.bookedtickets.add(p.passengerid);
                tb.positionmiddleberth.remove(0);
                tb.availablemiddleberth--;
                System.out.println("RAC moved to Upper berth");
                tb.passengers.remove(p_id);
            }
        }
    }
    public static void main(String[] args) {
        Boolean loop = true;
        while(loop){
            Integer choice;
            Scanner x =new Scanner(System.in);
            System.out.println("1. Book Ticket \n2. Cancel Ticket\n3. Available Tickets\n4. Booked Tickets\n5. Exit");
            System.out.println("Enter the operation: ");
            choice=x.nextInt();

            switch (choice){
                case 1:
                    Scanner scn = new Scanner(System.in);
                    String name,berth;
                    Integer age;
                    System.out.println("Enter Passenger name: ");
                    name= scn.next();
                    System.out.println("Enter Passenger age: ");
                    age= scn.nextInt();
                    System.out.println("Enter Passenger Berth preference(L,M or U): ");
                    berth= scn.next().toUpperCase();
                    bookingticket(name,age,berth);
                    break;

                case 2:
                    System.out.println("Enter the ticket no to be cancelled:");
                    Integer k = x.nextInt();
                    cancelticket(k);
                    break;


                case 3:
                    Ticketbooking tb = new Ticketbooking();
                    tb.display();
                    break;

                case 4:
                    Ticketbooking y = new Ticketbooking();
                    y.printall();
                    break;


                case 5:
                    loop=false;
                    break;

                default:
                    break;

            }


            }
        }
    }

