package com.leetcode.addTwoNumbers2;

public class Solution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = root;
        int carry = (l1.val + l2.val) / 10;
        while(true) {
            if(l1.next == null) {
                while(l2.next != null) {
                    if(carry == 0) {
                        ListNode node = new ListNode(l2.next.val);
                        temp.next = node;
                        temp = temp.next;
                        l2 = l2.next;
                    } else {
                        ListNode node = new ListNode((l2.next.val + carry) % 10);
                        temp.next = node;
                        carry = (l2.next.val + carry) / 10;
                        temp = temp.next;
                        l2 = l2.next;
                    }
                }
                if(carry > 0) {
                    ListNode node = new ListNode(carry);
                    temp.next = node;
                }
                break;
            }
            if(l2.next == null) {
                while(l1.next != null) {
                    if(carry == 0) {
                        ListNode node = new ListNode(l1.next.val);
                        temp.next = node;
                        temp = temp.next;
                        l1 = l1.next;
                    } else {
                        ListNode node = new ListNode((l1.next.val + carry) % 10);
                        temp.next = node;
                        carry = (l1.next.val + carry) / 10;
                        temp = temp.next;
                        l1 = l1.next;
                    }
                }
                if(carry > 0) {
                    ListNode node = new ListNode(carry);
                    temp.next = node;
                }
                break;
            }
            ListNode node = new ListNode((l1.next.val + l2.next.val + carry) % 10);
            temp.next = node;
            temp = temp.next;
            carry = (l1.next.val + l2.next.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;

        }
        return root;
    }
}