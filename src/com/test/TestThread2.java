package com.test;
/**
 * 创建线程通过继承thread类
 * @author wangyanchao
 *
 */
public class TestThread2 extends Thread {
	private Thread t;
	private String threadName;
	public TestThread2(String threadName) {
		super();
		this.threadName = threadName;
	    System.out.println("Creating " +  threadName );
	}
	public void run(){
		System.out.println("running +"+threadName);
		try{
			for(int i=0;i<5;i++){
				System.out.println("running+"+threadName+i);
				Thread.sleep(50);
			}
		}catch(InterruptedException e){
			System.out.println(threadName+"异常："+e);
		}
		System.out.println(threadName+" existing");
	}
	public void start(){
		System.out.println(threadName+" start");
		if(t==null){
			t = new Thread(this, threadName);
			t.start();
		}
		
	}
	
}
