package com.mohit.extendsThread;

class Runner extends Thread{
    public Runner(int id) {
		
		this.id = id;
	}
	private int  id;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++)
		{
			try {
				Thread.sleep(100);
				System.out.println("Thread"+id+" "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ExtendsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner runner1=new  Runner(1);
		runner1.start();
		Runner runner2=new  Runner(2);
		runner2.start();

	}

}
