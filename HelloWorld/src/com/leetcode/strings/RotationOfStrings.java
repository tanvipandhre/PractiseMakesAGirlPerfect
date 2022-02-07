package com.leetcode.strings;

public class RotationOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "amazon";
		String str2= "azonam";
		boolean flag = false;
		StringBuilder myString = new StringBuilder(str1);
		String first2chars = str1.substring(0, 2);
		myString.append(first2chars);
		myString.deleteCharAt(0);
		myString.deleteCharAt(0);
		
		//System.out.println(myString);
		
		String myString2 = "";
		int strLength = str1.length();
		String last2chars = str1.substring(strLength - 2, strLength);
		//System.out.println(last2chars);
		myString2 = last2chars+str1;
		//System.out.println(myString2);
		StringBuilder myString3 = new StringBuilder(myString2);
		myString3.deleteCharAt(strLength);
		myString3.deleteCharAt(strLength);
		
		//System.out.println(myString3);
		
		if(myString.toString().equalsIgnoreCase(str2) || myString3.toString().equalsIgnoreCase(str2)) {
			flag = true;
		}
		System.out.println(flag);
	}

}
/* amazon azonam
 * fsbcnuvqhffbsaqxwp wpfsbcnuvqhffbsaqx
 */
