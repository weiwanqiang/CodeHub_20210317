package com.huawei.OD;

/**
 * 
 * @author weiwanqiang
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

       请你将两个数相加，并以相同形式返回一个表示和的链表。

	你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/add-two-numbers。
 */

public class TwoNumbersAdd {
	public static ListNode TwoNumbersSum(ListNode l1,ListNode l2) {
		//考虑l1和l2为空的情况
		if(l1==null && l2==null) {
			return null;
		}
		int addone = 0; //初始进位为0
		ListNode res = new ListNode(); //创建保存结果的链表
		ListNode head = res; //用于结果链表的指针移动到每个节点；
		while(l1 != null || l2 != null || addone !=0) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int sum = val1 + val2 + addone;
			head.next = new ListNode(sum % 10);//每个节点的值为sum的模
			addone = sum / 10;
			head = head.next;
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		return res.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		System.out.println(ListNode.print(TwoNumbersSum(l1,l2)));
	}

}

/**
 * 
 * @author weiwanqiang
 * 创建链表，定义值、后继
 *
 */
class ListNode{
	int val;
	ListNode next;
	public ListNode() {}
	public ListNode(int val) {
		this.val = val;
	}
	
	//创建打印方法用于测试
	public static String print(ListNode ln) {
		StringBuilder sb = new StringBuilder();
		while(ln != null) {
			sb.append(ln.val);
			ln = ln.next;	//记得加上指针后移，不然会死循环
		}
		return (sb.toString());
	}
}
