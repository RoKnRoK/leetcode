package com.rok.leetcode;


import java.util.*;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00022_GenerateParentheses {


    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    /** official solution **/
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
    public static List<String> generateParenthesisIntuitive(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }

        List<String> previous = generateParenthesis(n - 1);
        Set<String> result = new HashSet<>(previous.size() * 3);
        for (String pair : previous) {
            result.add("(" + pair + ")");
            result.add("()" + pair);
            result.add(pair + "()");
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                tmp.append("()");
                int index = pair.indexOf(tmp.toString());
                while(index >= 0) {
                    result.add(pair.substring(0, index) + "(" + tmp + ")" + pair.substring(index+tmp.length()));
                    index = pair.indexOf(tmp.toString(), index+1);
                }
            }
        }
        return new ArrayList<>(result);
    }
}