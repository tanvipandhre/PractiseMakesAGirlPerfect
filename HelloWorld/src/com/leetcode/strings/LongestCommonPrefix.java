package com.leetcode.strings;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] strs = {"flying","flyi","flight"};
		String common="";
		if(strs.length == 0) {
			common = "";
			
		}else {
			common = strs[0];
			for(int i=1;i<strs.length;i++) {
				while(strs[i].indexOf(common) != 0) {
					common = common.substring(0, common.length()-1);
				}
			}
		}
		
		System.out.println(common);
	}

}
