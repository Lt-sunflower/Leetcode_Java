package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q242ValidAnagram implements Problem{

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     **/

    private String s;
    private String t;

    public Q242ValidAnagram() {
        this.s = "anagram";
        this.t = "nagaram";
    }

    public Q242ValidAnagram(String s, String t) {
        this.s = s;
        this.t = t;
    }

    public boolean solve(){

//        if (s.length() != t.length()) return false;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int i=0; i<s.length(); i++){
//            Character c = s.charAt(i);
//            if (map.containsKey(c)){
//                map.put(c, map.get(c)+1);
//            } else {
//                map.put(c,1);
//            }
//        }
//
//        for (int i=0; i<s.length(); i++) {
//            Character c = t.charAt(i);
//            if (map.containsKey(c) && map.get(c)>0){
//                map.put(c, map.get(c)-1);
//            } else {
//                return false;
//            }
//
//        }
//        return true;

        if (s.length() != t.length()) return false;
        char[] as1 = s.toCharArray();
        char[] as2 = t.toCharArray();
        Arrays.sort(as1);
        Arrays.sort(as2);

        for (int i=0; i<s.length(); i++) {
            if (as1[i] != as2[i]) return false;
        }

        return true;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + s + ", " + t);
        System.out.println("Answer: " + solve());
    }
}
