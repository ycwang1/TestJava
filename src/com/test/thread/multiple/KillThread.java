package com.test.thread.multiple;

import com.test.thread.entity.Hero;

/**
 * 使用多线程，就可以做到盖伦在攻击提莫的同时，赏金猎人也在攻击盲僧 
	设计一个类KillThread 继承Thread，并且重写run方法 
	启动线程办法： 实例化一个KillThread对象，并且调用其start方法 
	就可以观察到 赏金猎人攻击盲僧的同时，盖伦也在攻击提莫
 * @author wangyanchao
 *
 */
public class KillThread extends Thread {
	private Hero h1;
	private Hero h2;
	public KillThread(Hero h1, Hero h2) {
		this.h1 = h1;
		this.h2 = h2;
	}
	public void run() {
		while(!h2.isDead()){
			h1.attack(h2);
		}
	}
}
