package char_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class SumOfNumbers {

	public static void main(String[] args) {
		System.out.println("Enter file name");
		try (Scanner sc = new Scanner(System.in); 
				Scanner sc2 = new Scanner(new File(sc.nextLine()))) {
			int sum = 0;
			while (sc2.hasNextInt())
				sum += sc2.nextInt();
			System.out.println("Sum " + sum);

		} //sc2.close(file closing) , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public static void main(String[] args) {
//		System.out.println("Enter file name");
//		try (Scanner sc = new Scanner(System.in);
//				//File f=new File(sc.nextLine());
//				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
//			int sum = 0;
//			String line;
//			
//			while (((line=br.readLine())!=null) ) {
//			 sum=sum+Integer.parseInt(line);
//			}
//			System.out.println(sum);
//			
//		} catch (Exception e) {
//			e.getMessage();
//		}
//	}

}
