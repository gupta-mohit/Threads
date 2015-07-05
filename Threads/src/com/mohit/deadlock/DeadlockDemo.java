package com.mohit.deadlock;

class Account  {
	int balance;
	int accountNo;
	
	Account(int i , int acnum)
	{
		this.balance=i;
		this.accountNo=acnum;
	}
	
	void  deposit(int a)
	{
		balance=balance+a;
		
	}
	
	void  withdraw(int a)
	{
		balance=balance-a;
		
	}
	
	static void transfer(Account from, Account to, int amount){
		synchronized(from) {
			System.out.println(" Holding lock on account"+from.accountNo);
			 try { Thread.sleep(1000); }
	            catch (InterruptedException e) {}
			from.withdraw(amount);
		    synchronized(to) {
		    	System.out.println(" Holding lock on acc2"+to.accountNo);
		        // code
		    	try { Thread.sleep(2000); }
	            catch (InterruptedException e) {}
		        to.deposit(amount);
		        System.out.println("Transferred money from "+from.accountNo+" to "+to.accountNo);
		    }
		}
 
    }
	
}



public class DeadlockDemo {
	   public static Account acc1 = new Account(10000,200);
	   public static Account acc2 = new Account(10000,201);
	   
	   public static void main(String args[]) {
	   
	      ThreadDemo1 T1 = new ThreadDemo1();
	      ThreadDemo2 T2 = new ThreadDemo2();
	      T1.start();
	      T2.start();
	   }
	   
	   private static class ThreadDemo1 extends Thread {
	      public void run() {
	    	  for (int i=0;i <10 ;i++)
	    	  Account.transfer(acc2, acc1, 100);
	      }
	   }
	   private static class ThreadDemo2 extends Thread {
	      public void run() {
	    	     for (int i=0;i <10 ;i++)
	        	 Account.transfer(acc1, acc2, 100);
	        
	      }
	   } 
	}

/*
 * avoiding deadlock
 * 
 *  each method acquired the two locks in the same order, two or more threads executing 
 *  these methods could not deadlock, regardless of timing or other external factors,
 *   because no thread could acquire the second lock without already holding the first.
 *    If you can guarantee that locks will always be acquired in a consistent order,
 *     then your program will not deadlock.
 * 
 *  public void transferMoney(Account fromAccount, 
                            Account toAccount, 
                            DollarAmount amountToTransfer) { 
    Account firstLock, secondLock;
    if (fromAccount.accountNumber() == toAccount.accountNumber())
      throw new Exception("Cannot transfer from account to itself");
    else if (fromAccount.accountNumber() < toAccount.accountNumber()) {
      firstLock = fromAccount;
      secondLock = toAccount;
    }
    else {
      firstLock = toAccount;
      secondLock = fromAccount;
    }
    synchronized (firstLock) {
      synchronized (secondLock) { 
        if (fromAccount.hasSufficientBalance(amountToTransfer) { 
          fromAccount.debit(amountToTransfer); 
          toAccount.credit(amountToTransfer);
        }
      }
    }
  }
 * 
 * 
 */
