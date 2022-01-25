package com.leetcode.strings;

public class RunLengthEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaaabbc";
		String out = "";
		int count =0;
		Character x = s.charAt(0);
		out += s.charAt(0);
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)!=x) {
				x=s.charAt(i);
				out+=count;
				out+=s.charAt(i);
				count=1;
				continue;
				
			}
			//out+=s.charAt(i);
			count++;
			
			//
			//System.out.print(out);
		}
		
		System.out.println(out+count);
	}

}
