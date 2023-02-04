package com.rok.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00020_ValidParentheses {


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]["));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[': {
                    queue.addLast(c);
                } break;
                case ')': {
                    if (queue.peekLast() == null || queue.peekLast() != '(') { return false; }
                    queue.removeLast();
                }
                break;
                case '}': {
                    if (queue.peekLast() == null || queue.peekLast() != '{') { return false; }
                    queue.removeLast();
                }
                break;
                case ']': {
                    if (queue.peekLast() == null || queue.peekLast() != '[') { return false; }
                    queue.removeLast();
                }
                break;
            }

        }
        return queue.isEmpty();
    }
}
