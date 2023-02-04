package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00019_RemoveNthNodeFromEndOfList {


    public static void main(String[] args) {
        /*System.out.println(removeNthFromEnd(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4, new ListNode(5))
                                )
                        )
                )
                ,5
        ));*/
        System.out.println(removeNthFromEnd(
                new ListNode(1,
                        new ListNode(2, null)
                )
                ,2
        ));
        /*System.out.println(removeNthFromEnd(
                new ListNode(1, null),1
        ));*/
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastNode = null;
        ListNode currentNode = head;
        int length = 1;
        int i = Integer.MIN_VALUE;
        while (i < length - n) {
            if (i >= 0) {
                i++;
            }
            if (currentNode.next != null) {
                currentNode = currentNode.next;
                if (i < 0) length++;
            }
            else {
                currentNode.next = head;
                lastNode = currentNode;
                i = 0;
            }
        }
        lastNode.next = null;
        if (currentNode == lastNode) {
            return head.next;
        }

        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
