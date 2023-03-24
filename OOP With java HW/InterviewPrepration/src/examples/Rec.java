package examples;

import java.util.Arrays;

public class Rec {

	public static void rec(int arr[], int num) {
//		if (num == 1) {
//			arr[num-1] = 0;
//			return;
//		}
		if (num == 2) {
			//since array starts from 0 index
			arr[num-1] = 1;
			return;
		}

		rec(arr, num - 1);
		arr[num-1] = arr[num - 2] + arr[num - 3];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		int arr[] = new int[num];
		rec(arr, num);

//		for (int i = 0; i < arr.length; i++)
//			System.out.println(arr[i]);
//		
		//System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
