package com.mohit.staticmethodsync;

class Incrementer {
	String objectid;
	public Incrementer(String objectid) {
		this.objectid = objectid;
	}

	static int count=0;
	
	public void increment(int id){
		count++;
		System.out.println("incremented, value of count ="+count+" by thread "+id+" for object id "+objectid);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  synchronized  void incrementSynch(int id){
		count++;
		System.out.println("incremented inside synchmethod, value of count ="+count+" by thread "+id+" for object id "+objectid);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  static synchronized  void incrementStaticSynch(int id){
		count++;
		System.out.println("incremented inside static synch, value of count ="+count+" by thread "+id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

class Runner extends Thread{
	int id;
	
	public Runner(int id) {
		this.id = id;
	}

	Incrementer obj = new Incrementer("obj1");
	public void run(){
	
	
	
	
	
	obj.incrementSynch(id);
	obj.incrementStaticSynch(id);
	
	obj.increment(id);
	
	

	
	
	}
}

public class AnotherStaticSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner runner1=new Runner(1);
		Runner runner2=new Runner(2);
		
		runner1.start();
		runner2.start();

	}

}
