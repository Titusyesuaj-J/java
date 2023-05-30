package recursion.problems;

public class string {
    //{  String str = "bcaadfak";
    // System.out.println(string(str));}

   // String str = "bcaadfak";
 //   String res="";
     //   System.out.println(string(str,res));

    public static String string(String str){

        if(str.isEmpty()) {
            return "";
        }
        char res=str.charAt(0);

        if(str.charAt(0)=='a'){
            return string(str.substring(1));
        }
        else{
            return res+string(str.substring(1));
        }
    }
    public static String string(String str,String res){

        if(str.isEmpty()){
            return res;
        }
        if(str.charAt(0)=='a'){
            return string(str.substring(1),res);
        }

        //****************************(String matching)
        if(str.startsWith("apple")){
            return string(str.substring(5),res);
        }
        //***************************

        //****************************(skip only [app] not [apple])
        //for example xyzappfg u can skip but xyzapplefh u should not skip
        if(str.startsWith("app") && !(str.startsWith("apple"))){
            return string(str.substring(5),res);
        }
        //***************************
        else{
            res=res+str.charAt(0);
            return string(str.substring(1),res);
        }
    }
}
