package rprojectassignment1;

import java.util.*;

public class OneOfMyFavourite {
	
	public static void oneOfMyFavourite(int x)
	{
		while(x!=1)
		{
		 if(x%2==0)
		 {	 
		   x=x/2;
		   System.out.print(x+" ");
		 }
		 
		 else
		 {
			x=3*x+1;
		    System.out.print(x+" ");
		 }
		} 
	
	}
		
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("enter the value:");
		int x=sc.nextInt();
		
		oneOfMyFavourite(x);
		
	}
		
	}


