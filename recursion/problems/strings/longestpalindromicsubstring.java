package recursion.problems.strings;

public class longestpalindromicsubstring {
    public static void main(String[] args) {
        String s1="aaaabbaa";
        int s=0;
        int e=s1.length()-1;
        System.out.println(lps(s1,s,e));
    }
   public static int lps(String a,int s,int e) {
        if(s>e){
            return 0;
        }
        if (s==e){
            return 1;
        }
        if (a.charAt(s)==a.charAt(e)){
            int check=e-s-1;
            if (check==lps(a,s+1,e-1)){
                return 2+check;
            }
        }
        return(Math.max(lps(a,s+1,e),lps(a,s,e-1)));
   }
}

