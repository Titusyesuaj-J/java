package randomproblems;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        else{
            int res=1;
            int i=0;
            int j=0;
            HashMap<Character,Integer> hs=new HashMap<>();
            while(j<s.length()){

                if(hs.containsKey(s.charAt(j))){
                    i=Math.max(hs.get(s.charAt(j))+1,i);
                }
                res=Math.max(res,j-i+1);
                hs.put(s.charAt(j),j);
                j=j+1;
            }
            return res;
        }
    }
}
