package project;

import java.util.*;

public class Ticketbooking {

    public static Integer availablelowerberth=1;
    public static Integer availablemiddleberth=1;
    public static Integer availableupperberth=1;
    public static Integer availableRAC=1;
    public static Integer availablewaitinglist=1;


    public static List<Integer> bookedtickets = new ArrayList() ;

    public static Queue<Integer> raclist=new LinkedList();

    public static Queue<Integer> wllist=new LinkedList();

    public static List<Integer> positionlowerberth = new ArrayList<>(Arrays.asList(1));
    public static List<Integer> positionupperberth = new ArrayList<>(Arrays.asList(1));
    public static List<Integer> positionmiddleberth = new ArrayList<>(Arrays.asList(1));
    public static List<Integer> positionrac = new ArrayList<>(Arrays.asList(1));
    public static List<Integer> positionwaitinglist = new ArrayList<>(Arrays.asList(1));

    public static Map<Integer,Passenger> passengers = new HashMap();

    public void display(){
        System.out.println("availablelowerberth: "+availablelowerberth);
        System.out.println("availablemiddleberth: "+availablemiddleberth);
        System.out.println("availableupperberth: "+availableupperberth);
        System.out.println("availableRAC: "+availableRAC);
        System.out.println("availableWaitinglist: "+availablewaitinglist);
    }

    public void printall(){
            for(Passenger p: passengers.values()){
                System.out.println("Passenger Id: "+p.passengerid);
                System.out.println("Name: "+p.name);
                System.out.println("Age "+p.age);
                System.out.println("Status: "+p.number+p.alloted);
                System.out.println("-------------------------");
            }
    }
}

