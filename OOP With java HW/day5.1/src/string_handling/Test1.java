package string_handling;

//immutability of the String objects
public class Test1 {

	public static void main(String[] args) {
		String s1=new String("hello");
		 String s2= s1.toUpperCase();
		System.out.println(s1);//lower cased
		System.out.println(s2);//upper cased
		/* String s8= */s1.concat("12345");
//		System.out.println(s8);
		System.out.println(s1);//hello
		s1=s1.replace('l','t');
		System.out.println(s1);
		System.out.println(s2);


	}
//	private static int a;
//	public int b;
//
//	
//	public Test1(int b) {
//		super();
//		this.b = b;
//	}
//
//	public void nonstat() {
//		System.out.println(a);
//			stat();
//	}
//
//	public static void stat() {
//			System.out.println(a);
//			Test1 t = new Test1(1);
//			t.nonstat();
//	}
}