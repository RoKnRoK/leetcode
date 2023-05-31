package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00023_MergeKSortedLists {


    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{null, null}));
        System.out.println(mergeKLists(new ListNode[]{
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)
                        )
                ),
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(4, null)
                        )
                )}
        ));
        System.out.println(mergeKLists(new ListNode[]{
                new ListNode(1, null), null
        }));
        System.out.println(mergeKLists(new ListNode[]{
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)
                        )
                ),
                new ListNode(5, null)}
        ));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = null;
        for (ListNode nodeK : lists) {
            result = mergeTwoLists(nodeK, result);
        }
        return result;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode currentNode1 = list1;
        ListNode currentNode2 = list2;

        if (currentNode1 == null) {
            return currentNode2;
        }
        if (currentNode2 == null) {
            return currentNode1;
        }
        ListNode head;
        if (currentNode1.val <= currentNode2.val) {
            head = new ListNode(currentNode1.val);
            currentNode1 = currentNode1.next;
        } else {
            head = new ListNode(currentNode2.val);
            currentNode2 = currentNode2.next;
        }
        ListNode currentResult = head;

        while (true) {
            if (currentNode1 == null) {
                currentResult.next = currentNode2;
                break;
            }
            if (currentNode2 == null) {
                currentResult.next = currentNode1;
                break;
            }

            if (currentNode1.val <= currentNode2.val) {
                currentResult.next = new ListNode(currentNode1.val);
                currentNode1 = currentNode1.next;
            } else {
                currentResult.next = new ListNode(currentNode2.val);
                currentNode2 = currentNode2.next;
            }
            currentResult = currentResult.next;
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