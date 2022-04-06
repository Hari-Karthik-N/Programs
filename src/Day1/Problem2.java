package Day1;
//2. Integer to Roman
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
//        Input: num = 58
//        Output: "LVIII"
//        Explanation: L = 50, V = 5, III = 3.

import java.util.Scanner;

public class Problem2 {

    static String convertToRoman(int integer) {
        int[] integerValue = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String ans = "";
        for (int i = 0; i < integerValue.length; i++) {
            while (integer >= integerValue[i]) {
                integer -= integerValue[i];
                ans += roman[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        System.out.println("converted to roman: " + convertToRoman(userInput));
    }
}
