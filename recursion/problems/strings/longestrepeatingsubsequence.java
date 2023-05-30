package recursion.problems.strings;

public class longestrepeatingsubsequence {
    public static void main(String[] args) {
        String a="aabebecdd";
        String b=a.substring(0);
        int ap=0;
        int bp=0;
        System.out.println(res(a,b,ap,bp));
    }
    public static int res(String a,String b,int ap,int bp){
        if(ap>=a.length() || (bp>=b.length())){
            return 0;
        }

        if(ap!=bp && a.charAt(ap)==b.charAt(bp)){
            return 1+res(a,b,ap+1,bp+1);
        }
        else{
            return Math.max(res(a,b,ap,bp+1),res(a,b,ap+1,bp));

        }

    }
}
