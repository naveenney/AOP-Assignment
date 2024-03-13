package rprojectassignment1;

import java.util.Scanner;

public class AllOffByOne {
	
	public static boolean allOfByOne(int[] a,int[] b,int ind)
	{
		if(a.length==0||b.length==0||a.length!=b.length)	
			return false;
		
		a[ind]+=1;
		
		if(a[ind]!=b[ind])
			return false;
		
		if(a[ind]==b[ind]&&ind==a.length-1)
			return true;
	    
		return allOfByOne(a,b,ind+1);
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int index=0;
		
		System.out.print("enter the a size:");
		int aSize=sc.nextInt();
		
		
		int[] a=new int[aSize];
		
		for(int i=0;i<aSize;i++)
		{
			System.out.print("enter the value:");
			a[i]=sc.nextInt();
		}
        
		System.out.print("enter the b size:");
		int bSize=sc.nextInt();
		
		int[] b=new int[bSize];
	
		for(int i=0;i<bSize;i++)
		{
			System.out.print("enter the value");
			b[i]=sc.nextInt();
		}
		
		System.out.println(allOfByOne(a,b,index));
	}

}
