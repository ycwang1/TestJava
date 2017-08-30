package com.test.thread;

import com.test.thread.entity.Hero;
import com.test.thread.multiple.Battle;
import com.test.thread.multiple.KillThread;

public class TestThread {
	

	public static void main(String[] args) {
		
		//单线程
		//singleThread(); 
		
		//多线程 
		//继承Thread
//		multipleThread();
		
		//实现runnable
//		multipleThreadByRunnable();
		
		//匿名内部类
//		multipleThreadByAnonaymous();
		
		//主线程
//		mainThread();
		
		//进程优先级
//		priorityThread();
		
		//线程临时暂停
//		stopThread();
		
		//守护线程
//		saveThread();
		
		//线程同步问题
//		testThread1();
		
		//解决线程同步问题
		testThread2();
	}
	/*
	 * 测试单线程
	 * 首先要理解进程(Processor)和线程(Thread)的区别 
	进程：启动一个LOL.exe就叫一个进程。 接着又启动一个DOTA.exe，这叫两个进程。 
	线程：线程是在进程内部同时做的事情，比如在LOL里，有很多事情要同时做，比如"盖伦” 击杀“提莫”，同时“赏金猎人”又在击杀“盲僧”，这就是由多线程来实现的。 
	
	
	此处代码演示的是不使用多线程的情况： 
	只有在盖伦杀掉提莫后，赏金猎人才开始杀盲僧
	 */
	public static void singleThread(){
		// TODO Auto-generated method stub
				Hero gareen = new Hero();
				gareen.name="盖伦";
				gareen.hp=610;
				gareen.damage=50;
				
				Hero timo = new Hero();
				timo.name="提莫";
				timo.hp=300;
				timo.damage=30;
				
				Hero sj = new Hero();
				sj.name="赏金";
				sj.hp=410;
				sj.damage=55;
				
				Hero leesin = new Hero();
				leesin.name="盲僧";
				leesin.hp=500;
				leesin.damage=53;
				
				//盖伦攻击提莫
				while(!timo.isDead()){
					gareen.attack(timo);
				}
				
				//盲僧攻击赏金
				while (!sj.isDead()) {
					leesin.attack(sj);
				}
	}
	/**
	 * 	启动线程办法： 实例化一个KillThread对象，并且调用其start方法 
	就可以观察到 赏金猎人攻击盲僧的同时，盖伦也在攻击提莫
	 */
	private static void multipleThread(){
		Hero gareen = new Hero();
		gareen.name="盖伦";
		gareen.hp=610;
		gareen.damage=50;
		
		Hero timo = new Hero();
		timo.name="提莫";
		timo.hp=300;
		timo.damage=30;
		
		Hero sj = new Hero();
		sj.name="赏金";
		sj.hp=410;
		sj.damage=55;
		
		Hero leesin = new Hero();
		leesin.name="盲僧";
		leesin.hp=500;
		leesin.damage=53;
		KillThread killThread1 = new KillThread(gareen, timo);
		killThread1.start();
		KillThread killThread2 = new KillThread(sj, leesin);
		killThread2.start();
	}
	/**创建多线程
	 * 创建类Battle，实现Runnable接口
		启动的时候，首先创建一个Battle对象，然后再根据该battle对象创建一个线程对象，并启动
		 
		Battle battle1 = new Battle(gareen,teemo);
		new Thread(battle1).start();
		 
		
		battle1 对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
		必须，借助一个线程对象的start()方法，才会启动一个新的线程。
		所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run()方法了。
	 */
	private static void multipleThreadByRunnable(){
		Hero gareen = new Hero();
		gareen.name="盖伦";
		gareen.hp=610;
		gareen.damage=50;
		
		Hero timo = new Hero();
		timo.name="提莫";
		timo.hp=300;
		timo.damage=30;
		
		Hero sj = new Hero();
		sj.name="赏金";
		sj.hp=410;
		sj.damage=55;
		
		Hero leesin = new Hero();
		leesin.name="盲僧";
		leesin.hp=500;
		leesin.damage=53;
		
		Battle battle1=new Battle(gareen, timo);
		new Thread(battle1).start();
		
		Battle battle2=new Battle(sj, leesin);
		new Thread(battle2).start();
	}
	//使用匿名类进行实现多线程
	private static void multipleThreadByAnonaymous(){
		Hero gareen = new Hero();
		gareen.name="盖伦";
		gareen.hp=610;
		gareen.damage=50;
		
		Hero timo = new Hero();
		timo.name="提莫";
		timo.hp=300;
		timo.damage=30;
		
		Hero sj = new Hero();
		sj.name="赏金";
		sj.hp=410;
		sj.damage=55;
		
		Hero leesin = new Hero();
		leesin.name="盲僧";
		leesin.hp=500;
		leesin.damage=53;
		
		Thread t1 = new Thread(){
			public void run(){
				while(!timo.isDead()){
					gareen.attack(timo);
				}
			}
		};
		t1.start();
		
		Thread t2 = new Thread(){
			public void run(){
				while(!sj.isDead()){
					leesin.attack(sj);
				}
			}
		};
		t2.start();
	}
	
	/**
	 * 所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
		在44行执行t.join，即表明在主线程中加入该线程。
		主线程会等待该线程结束完毕， 才会往下运行。
	 */
	private static void mainThread(){
		Hero gareen = new Hero();
		gareen.name="盖伦";
		gareen.hp=610;
		gareen.damage=50;
		
		Hero timo = new Hero();
		timo.name="提莫";
		timo.hp=300;
		timo.damage=30;
		
		Hero sj = new Hero();
		sj.name="赏金";
		sj.hp=410;
		sj.damage=55;
		
		Hero leesin = new Hero();
		leesin.name="盲僧";
		leesin.hp=500;
		leesin.damage=53;
		
		Thread t1 = new Thread(){
			public void run(){
				while(!timo.isDead()){
					gareen.attack(timo);
				}
			}
		};
		t1.start();
		//代码执行到这里，一直是main线程在运行
		try {
			//t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(){
			public void run(){
				while(!sj.isDead()){
					leesin.attack(sj);
				}
			}
		};
		//会观察到盖伦把提莫杀掉后，才运行t2线程
		t2.start();
	}
	/**
	 * 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源 
		为了演示该效果，要把暂停时间去掉，多条线程各自会尽力去占有CPU资源 
		同时把英雄的血量增加100倍，攻击减低到1，才有足够的时间观察到优先级的演示 
		如图可见，线程1的优先级是MAX_PRIORITY，所以它争取到了更多的CPU资源执行代码
	 */
	private static void priorityThread(){
		final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 100;
  
        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 100;
          
        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 100;
          
        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 100;
          
        Thread t1= new Thread(){
            public void run(){
 
                while(!teemo.isDead()){
                    gareen.attack(teemo);
                }               
            }
        };
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attack(leesin);
                }               
            }
        };
         
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
	}
	
	//线程临时暂停
	private static void stopThread(){
		final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 100;
  
        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 100;
          
        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 100;
          
        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 100;
        
        Thread t1 = new Thread(){
        	public void run(){
        		while(!teemo.isDead()){
        			gareen.attack(teemo);
        		}
        	}
        };
        Thread t2 = new Thread(){
        	public void run(){
        		while(!leesin.isDead()){
        			t1.yield();//t1暂停
        			bh.attack(leesin);
        		}
        	}
        };
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
	} 
	/**
	 * 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。

		就好像一个公司有销售部，生产部这些和业务挂钩的部门。
		除此之外，还有后勤，行政等这些支持部门。
		
		如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。
		
		守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。
		
		守护线程通常会被用来做日志，性能统计等工作。
	 */
	private static void saveThread(){
		Thread t1 = new Thread(){
			public void run(){
				int seconds = 0;
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.printf("已经玩了LOL %d 秒%n", seconds++);
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
	}
	/**
	 * 线程同步问题原因
	 * 1. 假设增加线程先进入，得到的hp是10000 
		2. 进行增加运算 
		3. 正在做增加运算的时候，还没有来得及修改hp的值，减少线程来了 
		4. 减少线程得到的hp的值也是10000 
		5. 减少线程进行减少运算 
		6. 增加线程运算结束，得到值10001，并把这个值赋予hp 
		7. 减少线程也运算结束，得到值9999，并把这个值赋予hp 
		hp，最后的值就是9999 
		虽然经历了两个线程各自增减了一次，本来期望还是原值10000，但是却得到了一个9999 
		这个时候的值9999是一个错误的值，在业务上又叫做脏数据
		

	 */
	private static void testThread1(){
		final Hero garren = new Hero();
		garren.name="盖伦";
		garren.hp = 10000;
		garren.damage=50;
		System.out.printf("盖伦的初始血量为%.0f%n",garren.hp);
		
		//多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题
		//假设盖伦有1000的血，并且在基地里，同时又被多个英雄攻击
		//java表示就是多个线程在减少盖伦的hp
		//同时又有多个线程回复盖伦的hp;
		//n个线程增加盖伦的hp
		int n=10000;
		Thread[]addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];
		for(int i = 0;i<n;i++){
			Thread t = new Thread(){
				public void run(){
					garren.recover();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i]=t;
		}
		//n个线程减少盖伦的血量
		for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	garren.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
		//等待所有增加线程结束
		for(Thread t:addThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//等待所有减少进程结束
		for(Thread t:reduceThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//代码执行到这里，所有增加和减少线程都结束了
        
        //增加和减少线程的数量是一样的，每次都增加，减少1.
        //那么所有线程都结束后，盖伦的hp应该还是初始值
           
        //但是事实上观察到的是：
                   
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,garren.hp);
	}

	//解决同步问题
	/**
	 * 既然任意对象都可以用来作为同步对象，而所有的线程访问的都是同一个hero对象，索性就使用gareen来作为同步对象 
		进一步的，对于Hero的hurt方法，加上： 
		synchronized (this) { 
		} 
		表示当期对象为同步对象，即也是gareen为同步对象
		或者
		在recover前，直接加上synchronized ，其所对应的同步对象，就是this
		和hurt方法达到的效果是一样
		外部线程访问gareen的方法，就不需要额外使用synchronized 了
	 */
	private static void testThread2(){
		final Object someobject =new Object();
		final Hero garren = new Hero();
		garren.name="盖伦";
		garren.hp = 10000;
		garren.damage=50;
		System.out.printf("盖伦的初始血量为%.0f%n",garren.hp);
		
		//所有需要修改hp的地方，有要建立在占有someObject的基础上。 
//		而对象 someObject在同一时间，只能被一个线程占有。 间接地，导致同一时间，hp只能被一个线程修改。
		int n=10000;
		Thread[]addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];
		for(int i = 0;i<n;i++){
			Thread t = new Thread(){
				public void run(){
					synchronized (someobject){
						garren.recover();
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i]=t;
		}
		//n个线程减少盖伦的血量
		for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	synchronized (someobject){
                		garren.hurt();
                	}
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
		//等待所有增加线程结束
		for(Thread t:addThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//等待所有减少进程结束
		for(Thread t:reduceThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
                   
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,garren.hp);
	}
}
