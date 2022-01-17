package com.leetcode.strings;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String s = "i.love.you"; String out=""; String[] arr = s.split("."); for(int
		 * i=arr.length;i>0;i--) { out=arr[i]+"."; System.out.println(out); }
		 * System.out.println(out);
		 */
		String s = "i.like.this.program.very.much";
        String[] arr = s.split("[.]+");
        String out="";
        for(int i=arr.length-1;i>0;i--) {
        	out += arr[i]+".";
        	
        }
        out += arr[0];
        System.out.println(out);
            

	}

}
