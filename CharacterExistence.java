package rprojectassignment1;

import java.util.Scanner;

public class CharacterExistence {
   
	public static boolean charExistence(String str,char ch) 
	{	
		if(str.length()==0)
		    return false;
		
		else if(str.charAt(0)==ch)
                    return true;
		else
			return charExistence(str.substring(1),ch);
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.print("enter the string:");
		String str=scan.next();
		
		System.out.print("enter the character:");
		char ch=scan.next().charAt(0);
		
		if(charExistence(str,ch))
			System.out.println("character exits in the string");
		else
			System.out.println("character not exists in the string");
	}
		
	
	
}
