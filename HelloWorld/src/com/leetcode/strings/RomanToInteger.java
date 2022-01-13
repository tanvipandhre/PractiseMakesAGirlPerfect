package com.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Map<Character, Integer> map = new HashMap<Character, Integer>(); 
		 map.put('I', 1);
		 map.put('V', 5); 
		 map.put('X', 10); 
		 map.put('L', 50); 
		 map.put('C', 100);
		 map.put('D', 500); 
		 map.put('M', 1000);
		 
		System.out.println("Enter roman numeral");
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int prev = 0;
		String s = sc.next();
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			int val = map.get(c);
			if(prev!=0 && prev>val) {
				sum-=val;
			}else {
				sum+=val;
			}
			prev=val;
			
		}
		System.out.println(sum);
	}

}
