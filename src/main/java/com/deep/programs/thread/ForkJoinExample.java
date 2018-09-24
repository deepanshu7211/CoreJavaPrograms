package com.deep.programs.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {

	private int[] arr;
	private int start, end;

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ForkJoinExample forkJoinExample = new ForkJoinExample(a, 0, a.length);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		int result = forkJoinPool.invoke(forkJoinExample);
		System.out.println(result);
	}

	public ForkJoinExample(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if (end - start < 3) {
			return computeDirectly();
		} else {
			int mid = start + (end - start) / 2;
			ForkJoinExample left = new ForkJoinExample(arr, start, mid);
			ForkJoinExample right = new ForkJoinExample(arr, mid + 1, end);
			invokeAll(left, right);
			return Math.max(left.join(), right.join());
		}
	}

	private Integer computeDirectly() {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;

		for (int i = start; i < end; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
