package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;

public class Music implements Runnable{
	 public Thread thread;
	 public boolean yes = true;

	public void run() {
		play();
	}
	
	public void play() {
		  try {
		   File file = new File("saiki.wav");
		   Clip clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
		   clip.start();
		   Thread.sleep(clip.getMicrosecondLength());
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		 }

	 
	 public void start() {
		 if(thread == null) {
			 thread = new Thread(this, "piechart");
			 thread.start();
		 }
	 }

}

