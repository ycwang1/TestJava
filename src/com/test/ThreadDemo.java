package com.test;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TestThread1 t =new TestThread1("hello1");
//		t.start();
//		TestThread1 t1 = new TestThread1("world2");
		//t1.start();
		
//		TestThread2 t = new TestThread2("hello");
//		t.start();
		
		Runnable hello=new DisplayMessage("hello");
		Thread t1 = new Thread(hello);
		t1.setDaemon(true);//修改进程为守护进程或用户进程
		t1.setName("Hello");//修改权限名称
	    System.out.println("Starting Hello thread...");
	    t1.start();
	    
	    Runnable bye = new DisplayMessage("Goodbye");
	    Thread t2 = new Thread(bye);
	    t2.setPriority(Thread.MIN_PRIORITY);//设置线程优先级 1
	    t2.setDaemon(true);
	    System.out.println("Starting goodbye thread...");
	    t2.start();
	      
	    System.out.println("Starting thread3...");
	    Thread t3 = new GuessANumber(27);
	    t3.start();
	    
	    try {
			t3.join();
		} catch (InterruptedException  e) {
	         System.out.println("Thread interrupted.");
		}

	     System.out.println("Starting thread4...");
	     Thread t4 = new GuessANumber(75);
	     t4.start();
	     System.out.println("main() is ending...");


	}

}
