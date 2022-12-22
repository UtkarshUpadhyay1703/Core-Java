package runnable_tasks;

public class EvenPrinterTask implements Runnable{
	private int begin;
	private int end;
	public EvenPrinterTask(int begin, int end) {
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
				if(i%2==0)
					System.out.println("Even no"+i+"printed by"+Thread.currentThread().getName());
			Thread.sleep(100);
		}catch(Exception e)
		{
			System.out.println(Thread.currentThread().getName()+"Got exc "+e);
		}
		System.out.println(Thread.currentThread().getName()+"exec over");
	}
}
