package com.deep.programs.patterns;

import java.util.Scanner;

public class Number_Pattern {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int number = scanner.nextInt();
//    	int max= number*number;

    	boolean flag = true;
    	int arr[][] = new int[number][number];
    	int count =1;
    	
    	for(int i=0;i<number;i++)
    	{
    		if(flag)
    		{
    			for(int j=0;j<number;j++)
    			{
    				arr[i][j]= count++;
    			}
    			flag=false;
    		}
    		else if (!flag) {
				for(int j=number-1;j>=0;j--)
				{
					arr[i][j]=count++;
				}
				flag=true;
			}
    	}
    	
    	//Print output
    	
    	for(int i=number-1;i>=0;i--)
    	{
    		for(int j=0;j<number;j++)
    		{
    			System.out.print(arr[i][j] + " ");
    		}
    		System.out.println("\n");
    	}
    	
    	
    }
}
