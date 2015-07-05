package com.mohit.thread_using_anonymous;

public class ThreadUsingAnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<10;i++)
				{
					try {
						Thread.sleep(100);
						System.out.println("Thread"+" "+i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}})
			
		;
		t1.start();

	}

}
