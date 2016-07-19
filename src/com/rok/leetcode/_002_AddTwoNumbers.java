package com.rok.leetcode;


public class _002_AddTwoNumbers {

    public static void main(String[] args) throws InterruptedException {
        int[] firstNum = {2,5,6,9,1,5,7,8,4};
        int[] secondNum = {6,5,9,4,6,8,2,9};

        ListNode node1 = convert(firstNum);
        ListNode node2 = convert(secondNum);

        System.out.println(node1);
        System.out.println(node2);
        long start = System.nanoTime();
        System.out.println(addTwoNumbers(node1, node2));
        System.out.println(System.nanoTime() - start + " ns");

/*
        start = System.nanoTime();
        System.out.println(addTwoNumbers2(node1, node2));
        System.out.println(System.nanoTime() - start + " ns");
*/

        start = System.nanoTime();
        System.out.println(addTwoNumbers3(node1, node2));
        System.out.println(System.nanoTime() - start + " ns");

    }

    private static ListNode convert(int[] numbers) {
        ListNode result = new ListNode(numbers[0]);
        ListNode firstNode = result;
        for (int i = 1; i < numbers.length; i++) {
            result.next =  new ListNode(numbers[i]);
            result = result.next;
        }
        return firstNode;
    }

    private static long convertToLong(ListNode node) {
        int multiplier = 1;
        long result=0;
        while (node != null){
            result += node.val*multiplier;
            multiplier *= 10;
            node = node.next;
        }
        return result;
    }

    public static ListNode addTwoNumbers(ListNode currentNode1, ListNode currentNode2) {
        ListNode resultNode = null;
        ListNode previousResultNode = null;
        ListNode result = null;
        boolean transfer = false;
        int counter = 0;
        while (currentNode1 != null || currentNode2 != null) {
            counter++;
            int val1 = currentNode1 == null ? 0 : currentNode1.val;
            int val2 = currentNode2 == null ? 0 : currentNode2.val;

            int sum = val1 + val2 + (transfer ? 1 : 0);
            transfer = sum >= 10;
            int mod = transfer ? (sum - 10) : sum;

            resultNode = new ListNode(mod);
            if (previousResultNode != null) {previousResultNode.next = resultNode;}
            previousResultNode = resultNode;
            if (counter == 1) {result = resultNode;}

            currentNode1 = currentNode1 == null ? null : currentNode1.next;
            currentNode2 = currentNode2 == null ? null : currentNode2.next;
        }

        if (transfer) {
            resultNode.next = new ListNode(1);
        } return result;
    }

    public static ListNode addTwoNumbers2(ListNode currentNode1, ListNode currentNode2) {
        ListNode largerNode = currentNode1;
        ListNode lesserNode = currentNode2;

        boolean transfer = false;

        boolean firstGreater = true;
        while (largerNode != null || lesserNode != null) {
            if (largerNode == null){
                firstGreater = false;
            }

            largerNode = largerNode == null ? null : largerNode.next;
            lesserNode = lesserNode == null ? null : lesserNode.next;
        }

        if (firstGreater) {
            largerNode = currentNode1;
            lesserNode = currentNode2;
        }
        else {
            largerNode = currentNode2;
            lesserNode = currentNode1;
        }

        while (largerNode != null) {
            int val1 = largerNode.val;
            int val2 = lesserNode == null ? 0 : lesserNode.val;

            int sum = val1 + val2;
            transfer = sum >= 10;

            largerNode.val = transfer ? (sum - 10) : sum;
            if (largerNode.next != null && transfer) {largerNode.next.val++;}
            else if (largerNode.next == null) break;


            largerNode = largerNode.next;
            lesserNode = lesserNode == null ? null : lesserNode.next;
        }

        if (transfer) {
            largerNode.next = new ListNode(1);
        }
        return (firstGreater ? currentNode1 : currentNode2);
    }

    public static ListNode addTwoNumbers3(ListNode currentNode1, ListNode currentNode2) {
        long number1 = convertToLong(currentNode1);
        long number2 = convertToLong(currentNode2);

        long sum = number1 + number2;

        String temp = Long.toString(sum);
        int[] nums = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            nums[i] = temp.charAt(i) - '0';
        }
        return convert(nums);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            ListNode copy = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (copy != null) {
                stringBuilder.append(copy.val);
                copy = copy.next;
            }
            return stringBuilder.toString();
        }
    }
}
