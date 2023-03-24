package examples;


public class Example1 {

	public int reverse(int x) {
		int a =(int) Math.pow(2, 31)-1;
		int b = (int) Math.pow(-2, 31);
		System.out.println(b+" ----- "+a);
		if(x<b || x>=a) {
			return 0;
		}
        int rev=0,inp=x;
        boolean flag=false;
        if(x<0){
            inp=x*(-1);
            flag=true;
        }
        while(inp>0){
        rev=rev*10+(inp%10);
        inp=inp/10;
        }
        if(flag){
            rev=rev*-1;
        }
        return rev;
    }
	
	  public static void main(String[] args) {
		  Example1 e1=new Example1();
		  
		  System.out.println(e1.reverse(1534236469));

      }
   

}