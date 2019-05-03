/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.basics;

/**
 * @author deepanshu.saxena
 */
public class FindMiddleIndex {
    public static void main(String[] args) {
        int[] num = {2, 4, 4, 5, 4, 1};       
        
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                    + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        findEquilibirum();
    }

    private static int findMiddleIndex(int[] num) throws Exception {
        int start = 0;
        int end = num.length - 1;
        int suml = 0, sumr = 0;
        while (true) {
            if (suml > sumr) {
                sumr = sumr + num[end--];
            } else {
                suml = suml + num[start++];
            }
            if (start > end) {
                if (suml == sumr) {
                    break;
                } else {
                    throw new Exception("Please pass proper array to match the requirement");
                }

            }
        }
        return end;
    }
    
    // Find an element in array such that sum of left array is equal to sum of right array
    // https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/ 
    // For Brute Force : https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
    
    private static void findEquilibirum() {
//    	int arr[] = { 1, 4, 2, 5};
    	int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
    	
    	int leftsum=0, rightsum=0;
    	//Calculate the right sum from second element
    	for(int i=1;i<arr.length;i++)
    		rightsum+=arr[i];
    	
    	// Minus from right sum and add to left sum
    	for(int i=0,j=1;j<arr.length;i++,j++) {
    		rightsum-=arr[j];
    		leftsum+=arr[i];
    		
    		if(leftsum==rightsum) {
    			System.out.println(" find equilibirum element "+ arr[i+1] + " index "+ (i+1));
    			break;
    		}
    			
    	}
    	
    }
}

