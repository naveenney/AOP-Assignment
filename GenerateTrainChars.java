package rprojectassignment1;

import java.util.Scanner;

public class GenerateTrainChars {

	public static String generateTrainCharacters(String str)
	{
		int len=str.length()/2;
	
		if(len==1)
		{	  
			  char ch=str.charAt(len-1);
			  char ch1=str.charAt(len+1);
		      return ""+ch+ch+str.charAt(len)+ch1+ch1;
		}	
		String str1=str.substring(0,len);
	
		String s = "";
		
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<=len-i;j++)
				
		       s+=str1.charAt(i);
		}
		
		s+=str.charAt(len);
		
		String str2=str.substring(len+1);
		
		for(int i=0;i<str2.length();i++)
		{
			for(int j=0;j<str2.length()+i;j++)
				
			   s+=str2.charAt(i);
			
		}
		return s;
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.print("enter the String<Odd num of chars only:");
		String str=scan.next();
		
		System.out.println(generateTrainCharacters(str));
		
		
		
	}
		
	
	
}
