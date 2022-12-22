package tester_Assignment;

import java.util.Scanner;

import com.cdac.geometry.Point2D;

public class TestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter how many points You want to plot");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Point2D[] arr = new Point2D[size];
		System.out.println("Enter coordinates");
		for (int i = 0; i < arr.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point2D obj = new Point2D(x, y);
			arr[i] = obj;
		}
		for (Point2D p : arr) {
			System.out.println(p.show());
		}
		System.out.println("Enter 2 indices");
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a < arr.length && b < arr.length) {
			if (!arr[a].isequal(arr[b])) {
				System.out.println(arr[a].calculateDistance(arr[b]));
			}
		}
		sc.close();
	}
}