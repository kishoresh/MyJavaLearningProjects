package com.Threading.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("Timer task started at " + new Date());
		completeTask();
		System.out.println("Timer task ends at " + new Date());
	}
	
	private void completeTask(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyTimerTask timerTask = new MyTimerTask();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		System.out.println("Timertask started.");
		
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("Thread cancelled.");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
