package com.mohit.synchronized_keyword;

public class SynchronizedKeywordDemo {
	private int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedKeywordDemo obj1=new SynchronizedKeywordDemo();
		obj1.doWork();
		
	}

	public void doWork() {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable()
				{

					@Override
					public void run() {
						// TODO Auto-generated method stub
						for (int i=0;i<1000;i++)
						{
							count++;
						}
					}
					
					
				});
		
		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<1000;i++)
				{
					count++;
				}
			}
			
			
		});
		//run multiple times and see count has diff values
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
