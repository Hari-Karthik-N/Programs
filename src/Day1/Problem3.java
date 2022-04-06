package Day1;
//3. Roman to Integer
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//
//        Example:
//        Input: s = "LVIII"
//        Output: 58
//        Explanation: L = 50, V= 5, III = 3

import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
    static int convertToInteger(String roman) {
        HashMap<String, Integer> romanInteger = new HashMap<>();
        int ans = 0;
        romanInteger.put("I", 1);
        romanInteger.put("V", 5);
        romanInteger.put("X", 10);
        romanInteger.put("L", 50);
        romanInteger.put("C", 100);
        romanInteger.put("D", 500);
        romanInteger.put("M", 1000);
        for(int i = 0; i < roman.length(); i++) {
            if(i == roman.length() - 1) {
                String first = Character.toString(roman.charAt(i));
                ans += romanInteger.get(first);
                continue;
            }
            String first = Character.toString(roman.charAt(i));
            String next = Character.toString(roman.charAt(i + 1));
            if(romanInteger.get(first) < romanInteger.get(next)) {
                ans += romanInteger.get(next) - romanInteger.get(first);
                i++;
            } else {
                ans += romanInteger.get(first);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        System.out.println("converted to integer: " + convertToInteger(userInput));
    }
}
