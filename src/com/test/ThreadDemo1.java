package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo1 implements Callable<Integer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo1 t1 = new ThreadDemo1();
		FutureTask ft = new FutureTask<>(t1);
		for(int i =0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
			if (i==20) {
				new Thread(ft,"有返回的进程").start();;
			}
			try {
	            System.out.println("子线程的返回值："+ft.get());  

			} catch (InterruptedException  e) {
	            e.printStackTrace();  
			}catch (ExecutionException e)  
	        {  
	            e.printStackTrace();  
	        }  
		}
	}

	@Override
	public Integer call() throws Exception {
		int i=0;
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		return 1;
	}

}
