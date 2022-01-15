package com.leetcode.strings;

import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		String s = "(){}}{";
		int len = s.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<len;i++) {
			if(!stack.isEmpty()) {
				if(s.charAt(i)==')' && stack.peek()=='(') {
					stack.pop();
					continue;
				}else if(s.charAt(i)=='}' && stack.peek()=='{') {
					stack.pop();
					continue;
				}else if(s.charAt(i)==']' && stack.peek()=='[') {
					stack.pop();
					continue;
				}
			}
			stack.push(s.charAt(i));
		}
		System.out.println(stack.isEmpty());
	}

}
