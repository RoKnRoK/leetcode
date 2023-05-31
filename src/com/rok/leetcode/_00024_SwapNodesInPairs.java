package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00024_SwapNodesInPairs {


    public static void main(String[] args) {
        System.out.println(swapPairs(null));
        System.out.println(swapPairs(new ListNode(1, null)));
        System.out.println(swapPairs(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4, null)
                                )
                        )
                )
        ));
        System.out.println(swapPairs(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)
                                        )
                                )
                        )
                )
        ));
        System.out.println(swapPairs(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6, null)
                                                )
                                        )
                                )
                        )
                )
        ));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode resultHead = head.next;

        ListNode nodeToRearrange = head;
        ListNode nodeToHold = nodeToRearrange.next;
        ListNode last;

        while (true) {
            nodeToRearrange.next = nodeToHold.next;
            nodeToHold.next = nodeToRearrange;
            last = nodeToRearrange;


            nodeToRearrange = nodeToRearrange.next;
            if (nodeToRearrange == null) { return resultHead; }
            nodeToHold = nodeToRearrange.next;
            if (nodeToHold == null) {return resultHead; }
            last.next = nodeToHold;
        }

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

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder str = new StringBuilder("" + node.val);
            while (node.next != null) {
                node = node.next;
                str.append(" -> ").append(node.val);
            }
            return str.toString();
        }
    }
}
