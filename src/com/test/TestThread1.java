package com.test;

/**
 * @author wangyanchao
 *
 */
public class TestThread1 implements Runnable {
	private Thread t;
	private String threadName;
	TestThread1(String threadName) {
		this.threadName = threadName;
	      System.out.println("Creating " +  threadName );
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running:"+threadName);
		try{
			for(int i=0;i<5;i++){
				System.out.println("runing:"+threadName+" "+i);
				Thread.sleep(50);
			}
		}catch(InterruptedException e){
			System.out.println("InterruptedException"+threadName);
		}
		System.out.println(threadName+" exiting");
	}
	public void start(){
		System.out.println(threadName+" starting");
		if(t==null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
}
