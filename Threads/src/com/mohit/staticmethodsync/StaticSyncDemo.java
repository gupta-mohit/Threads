package com.mohit.staticmethodsync;



class Table{  

	synchronized static void printTableStaticSync(int n){  
		 
			System.out.println(n +" inside printTableStaticSync");  
			try{ System.out.println(n+"waiting inside printTableStaticSync for 4000");
				Thread.sleep(10000);  
				 System.out.println(n+"waiting over inside printTableStaticSync for 4000");
			}catch(Exception e){}  
		 
	}  
	
	synchronized  void printTableSync(int n){  
		System.out.println(n +" inside printTableSync"); 
			try{  System.out.println(n+"waiting inside printTableSync for 4000");
				Thread.sleep(10000);  
				System.out.println(n+"waiting over inside printTableSync for 4000");
			}catch(Exception e){}  
		  
	}  
	
	public void block(int n)
	{
		synchronized(this)
		{
			for(int i=1;i<=10;i++){  
				System.out.println(n*i);  
				try{  
					Thread.sleep(400);  
				}catch(Exception e){}  
			}  
			
		}
	}
}  





public class StaticSyncDemo {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table tab1=new Table();
		Table tab2=new Table();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				tab1.printTableSync(1);
				tab1.printTableStaticSync(1);
				
				
			}});
		
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				tab2.printTableSync(2);
				tab2.printTableStaticSync(2);
				
				/////uncomment this and see if same object is shared then what happens
				//tab1.printTableSync(2);
				//tab1.printTableStaticSync(2);
				
				
			}});
		t1.start();
		t2.start();

	}


	
	
}
