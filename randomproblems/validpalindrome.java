package randomproblems;

public class validpalindrome {
    public static void main(String[] args) {
        String k="lll";
        //x.append(k);

    }
    public static boolean isPalindrome(String s) {
        String t=s.toLowerCase();
        String pal="";
        for(int i=0;i<t.length();i++){
            int k=t.charAt(i);
            if((s.charAt(i)>='a' && k<=122)||(k>=48 && k<=57)){
                pal=pal+t.charAt(i);
            }
        }
        int i=0;
        int j=pal.length()-1;
        while(i<=j){
            if(pal.charAt(i)!=pal.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
