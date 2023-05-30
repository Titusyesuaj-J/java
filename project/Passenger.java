package project;

public class Passenger {

    static Integer id=1;
    String name,berthpreference,alloted;
    Integer age,passengerid,number;



    public Passenger(String name,Integer age,String berthpreference){
        this.name=name;
        this.age=age;
        this.berthpreference=berthpreference;
        this.passengerid=id++;
        number=-1;
        alloted="";

    }

}
