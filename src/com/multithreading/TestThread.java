package com.multithreading;

class ThreadDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   
	   ThreadDemo( String name){
	       threadName = name;
	       System.out.println("Creating " +  threadName );
	   }
	   public void run() {
	      System.out.println("Running " +  threadName );
	
	         for(int i = 100; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	         }
	     
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   

	}

	public class TestThread {
	   public static void main(String args[]) {
	   
	      ThreadDemo T1 = new ThreadDemo( "Thread-1");
	      T1.start();
	      
	      ThreadDemo T2 = new ThreadDemo( "Thread-2");
	      T2.start();
	   }   
	}
