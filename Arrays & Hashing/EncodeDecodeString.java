import java.io.*;
import java.util.*;

public class EncodeDecodeString {
    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        // write your code here
        String res = "";
        for (String s : strs) {
            res += s.length() + "$" + s;
        }
        return res;
    }

    /*
     * @param str: A string
     * 
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '$') {
                j++;
            }
            int len = Integer.valueOf(str.substring(i, j));
            System.out.print("len :" + len + "\n");
            res.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("li&nt", "c$ode", "love", "you"));
        String res = encode(strings);
        System.out.println(res);
        List<String> resList = decode(res);
        for (String s : resList) {
            System.out.println(s);
        }
    }
}

// Example 1
// Input: ["lint","code","love","you"]
// Output: ["lint","code","love","you"]
// Explanation:
// One possible encode method is: "lint:;code:;love:;you"

// Example 2
// Input: ["we", "say", ":", "yes"]
// Output: ["we", "say", ":", "yes"]
// Explanation:
// One possible encode method is: "we:;say:;:::;yes"