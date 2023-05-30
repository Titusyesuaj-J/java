package recursion;

//String x="racecar";
       // int size= x.length()-1;
       // palindrome(x,size);
public class palindrome {
    static String n="";
    public static void palindrome1(String x,Integer size){
        if (x.equals(n) && size==-1){
            System.out.println("true");
            return;
        } else if (x!=n && size==-1) {
            System.out.println("false");
            return;
        }

        n=n+x.charAt(size);

        palindrome1(x,size-1);
    }
    public static void palindrome2(String x,int s,int e){

        if(x.charAt(s)!=x.charAt(e)){
            System.out.println("not a palindrome");
            return;
        } else if (x.charAt(s)==x.charAt(e-1) || (x.charAt(s)==x.charAt(e-2))){
            System.out.println("palindrome");
            return;
        }
        palindrome2(x,s+1,e-1);

}}
