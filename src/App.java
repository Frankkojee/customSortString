import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    private static int[] orderMap = new int[26];
//the solution required a non-static method, using a static method was just for aesthetics
    public static String customSortString(String order, String s) {
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        Comparator<Character> customComparator = (c1, c2) -> Integer.compare(orderMap[c1 - 'a'], orderMap[c2 - 'a']);

        List<Character> sCharsList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            sCharsList.add(c);
        }

        Collections.sort(sCharsList, customComparator);

        // Convert the sorted list back to a string and return the result
        StringBuilder result = new StringBuilder();
        for (char c : sCharsList) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Problem Of the day when I joined leetcode for the first time");

        String order1 = "cba";
        String s1 = "abcd";
        System.out.println(customSortString(order1, s1));  // Output: "cbad"

        String order2 = "bcafg";
        String s2 = "abcd";
        System.out.println(customSortString(order2, s2));  // Output: "bcad"
    }
}
