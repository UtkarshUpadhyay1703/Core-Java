package examples;

public class Fibonacci {
//public static void nthNumber(int number) {
//	int num1=0;
//	int num2=0;
//	int sum=0;
//	if(number==0) {
//		sum+=0;
//	}
//	if(number==1) {
//		sum+=1;
//	}
//	while(number>1) {
//		
//	}
//}
	
	static int fibo(int num){
	      int first = 0, second = 1, temp;
	      if (num == 0)
	      return first;
	      if (num == 1)
	      return second;
	      for (int i = 2; i <= num; i++){
	         temp = first + second;
	         first = second;
	         second = temp;
	      }  
	      return second;
	   }
	
	static int fiboByForLoop(int num) {
		if(num<=1) {
			return num;
		}
		int cur=1,pre=0;
		for(int i=0;i<num-1;i++) {
			int temp=pre+cur;
			pre=cur;
			cur=temp;
		}
		return cur;
	}
	public static void main(String args[]){
	      int num = 7;
	      System.out.print("The 7th fibonacci number is : ");
	      System.out.println(fibo(num));
	      System.out.println(fiboByForLoop(num));
	      String str=new String("asdf");
	      for(int i=0;i<str.length();i++) {
	      System.out.println(str.charAt(i));
	      }
	   }
}
