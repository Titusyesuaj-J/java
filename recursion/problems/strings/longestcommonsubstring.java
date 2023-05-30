package recursion.problems.strings;

public class longestcommonsubstring {
    public static void main(String[] args) {
        String a="adac";
        String b="adadac";
        System.out.println(lcs(a,b,0,0,0));
    }
    public static int lcs(String a,String b,int ap,int bp,int count){
        if((ap==a.length())||(bp==b.length())){
            return count;
        }
        if(a.charAt(ap)==b.charAt(bp)){
            count= lcs(a,b,ap+1,bp+1,count+1);
        }
        count=Math.max(count,Math.max(lcs(a,b,ap+1,bp,0),lcs(a,b,ap,bp+1,0)));
        return count;
    }
}
