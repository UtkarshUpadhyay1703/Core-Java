package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOStream {

	public static void main(String[] args) {
		System.out.println("Enter file location");
		try(Scanner sc=new Scanner(System.in);
//				BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\utkar\\Desktop\\Pending work.txt"
//));)//for reading directly we use \\ but in normal we use \ and without "";
		BufferedReader br=new BufferedReader(new FileReader(sc.nextLine()));
				PrintWriter pw=new PrintWriter(new FileWriter(sc.nextLine(),true));)
				{
			System.out.println("contents,,,,,,,,,,,,,,,,,,,,,,,,");
			String str=null;
//			while((str=br.readLine()) != null) System.out.println(str);
//			System.out.println("Data over");
			while((str=br.readLine())!=null) pw.println(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
