package runnable_tasks;

public class OddPrinterTask implements Runnable{
	private int begin;
	private int end;
	public OddPrinterTask(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		System.out.println("Ctor invoked by"+Thread.currentThread().getName());
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"started exec");
		try {
			for(int i=begin;i<=end;i++)
				if(i%2!=0)
					System.out.println("Odd no"+i+"printed by"+Thread.currentThread().getName());
			Thread.sleep(130);
		}catch(Exception e)
		{
			System.out.println(Thread.currentThread().getName()+"Got exc "+e);
		}
		System.out.println(Thread.currentThread().getName()+"exec over");
	}
}
