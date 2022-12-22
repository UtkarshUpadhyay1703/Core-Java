package inner_class;

public class A {
	private int i;
	private static int j;
	static {
		j = 100;
	}

	public A(int i) {
		super();
		this.i = i;
	}

	// can u add static method in the outer class ? YES
	public static void outerStaticShow() {
		//if we have to print outer static show if we have to print i and j which are non static ands static respectively
		//so we can directly print j but for i we have to use class name.i
		
		//if we have to print inner static and non static variables k and l respectively for k  we have to use
		// class name.k and for l we have to take instance of inner class (for this we have to use like this
		//Parent_class_name.Child_class_name Reference_variable = new Parent_class_name(). new Child_class_name();
		//Reference_variable.innerNonStaticShow();
		System.out.println("outer's static method j=" + j);
		System.out.println("inner's static constant "+B.k);
		
		
		//can u access l : 
//	B b2=new B(34);javac err since : this method is NOT asso with outer class instance
		//create outer class inatnce n then u can create inner class instance
		A.B innerRef=new A(55).new B(67);
		System.out.println("outer's static method j=" + innerRef.l);
		innerRef.innerNonStaticShow();
	}

	// can u add a non- static method in the outer class ? YES
	public void outerNonStaticShow() {
		System.out.println("outer'nonstatic method i=" + i + " j=" + j);
		//can outer class DIRECTLY access inner cls members ? NO
//	System.out.println("inner clss' members "+B.k+" "+l);
		//create inner class instance first n then can access
		System.out.println("inner's l "+B.k);
		B b1=new B(11);
		System.out.println("inner's l "+b1.l);

	}
	//inner class 
	class B
	{
		//can u add static data members ? no , unless it's final
		private static final int k=200;
//		static {
//			k=12345;
//		}
		//can u add non static data members ? yes
		private int l;
		public B(int l) {
			super();
			this.l = l;
		}
		//can u add a static method ? no
//		public static void innerStaticShow() {
//			//System.out.println("outer's static method j=" + j);
//		}
		//can u add a non static method ? yes
		//can it access DIRECTLY(i.e w/o creating outer class instance) , private members of the outer class ?YES
		public void innerNonStaticShow()
		{
			System.out.println("inner's non static method "+i+" "+j+" "+k+" "+l);
		}
		
	}

}
