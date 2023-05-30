package randomproblems;

import java.util.*;

public class group_anagrams {
    public static void main(String[] args) {
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res=new HashMap<>();
            for(String x:strs){
                HashMap<Character,Integer> hm =new HashMap<>();
                for(int i=0;i<x.length();i++){
                    if(hm.containsKey(x.charAt(i))){
                        hm.put(x.charAt(i),hm.get(x.charAt(i))+1);
                    }
                    else{
                        hm.put(x.charAt(i),0);
                    }
                }
                ArrayList<Character> r=new ArrayList<>(hm.keySet());
                String t="";
                for(int i=0;i<r.size();i++){
                    t=t+r.get(i)+hm.get(r.get(i));
                }

                if(!res.containsKey(t)){
                    List<String> k=new ArrayList<>();
                    k.add(x);
                    res.put(t,k);
                }
                else{
                    res.get(t).add(x);
                }
            }
        List<List<String>> l=new ArrayList<>(res.values());
        return l;
    }
}
