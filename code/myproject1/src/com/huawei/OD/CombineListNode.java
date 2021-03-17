package com.huawei.OD;

import java.util.ArrayList;

public class CombineListNode {

	public static void main(String[] args) {
		ListNode l1 = null;
		ListNode l2 = new ListNode(0);
		ListNode res = mergeTwoLists(l1,l2);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	//先将两个链表接起来，转换成数组进行快速排序，排序完成后在创建链表赋值返回。
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}
		if(l1 == null && l2 !=null) return l2;
		if(l1 != null && l2 ==null) return l1;
		int len1 = l1.toString().length();
		int len2 = l2.toString().length();
		ListNode res = new ListNode();
		ListNode p = res;
		ListNode p1 = l1;
		if((len1 == 0 && len2 == 0) || (len1 != 0 && len2 == 0)) {
			return l1;
		}
		if(len1 == 0 && len2 != 0) {
			return l2;
		}

		while(p1 != null ) {
			if (p1.next == null) {
				p1.next = l2;
				break;
			}else {
				p1 = p1.next;
			}
		}
		ArrayList<Integer> arr  = new ArrayList<Integer>();
		while(l1 != null) {
			arr.add(l1.val);
			l1 = l1.next;
		}
		ArrayList<Integer> values = quickSort(arr);
		ListNode res1 = new ListNode();
		ListNode p2 = res1;
		for(int i=0;i<values.size();i++) {
			p2.next = new ListNode(values.get(i));
			p2 = p2.next;
		}
		return res1.next;
    }
	static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
		int arrlen = arr.size();
		if(arrlen <= 1) {
			return arr;
		}
		else{
			int baseitem = arr.get(0);
			ArrayList<Integer> lesslist = new ArrayList<Integer>();
			ArrayList<Integer> greaterlist = new ArrayList<Integer>();
			ArrayList<Integer> finallist = new ArrayList<Integer>();
			for(int i=1;i<arrlen;i++) {
				if (arr.get(i) <= baseitem) {
					lesslist.add(arr.get(i));
				}
				else {
					greaterlist.add(arr.get(i));
				}
			}
			finallist.addAll(quickSort(lesslist));
			finallist.add(baseitem);
			finallist.addAll(quickSort(greaterlist));
			return finallist;
		}			
	}

}
