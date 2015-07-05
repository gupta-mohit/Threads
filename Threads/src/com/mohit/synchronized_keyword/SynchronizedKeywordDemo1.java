package com.mohit.synchronized_keyword;

public class SynchronizedKeywordDemo1 {
	private   int count=0;
    public synchronized  void increment()
    {
    	count++;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedKeywordDemo1 obj1=new SynchronizedKeywordDemo1();
		obj1.doWork();
		
	}

	public void doWork() {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable()
				{
			        @Override
					public void run() {
						for (int i=0;i<1000;i++)
						{   try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							increment();
						}
					}
              });
		
		Thread t2 = new Thread(new Runnable()
		      {
			     @Override
		         public void run() {
				  	for (int i=0;i<1000;i++)
				{       try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  		increment();
				}
			}
			
			
		});
		long start=System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("count is" +count);
	}

}
