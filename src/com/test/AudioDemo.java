package com.test;

import java.applet.Applet;
import java.applet.AppletContext;
/**
 *≤•∑≈“Ù∆µ 
 * @author wangyanchao
 *
 */
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
public class AudioDemo extends Applet {
	private AudioClip ac;
	private AppletContext appletContext;
	public void init(){
		appletContext = this.getAppletContext();
		String audioUrl = this.getParameter("audio");
		if(audioUrl==null){
			audioUrl = "default.au";
		}
		try {
			URL url = new URL(this.getDocumentBase(), audioUrl);
			ac = appletContext.getAudioClip(url);
		} catch (MalformedURLException e) {
	         e.printStackTrace();
	         appletContext.showStatus("Could not load audio file!");
		}
	}
	   public void start()
	   {
	      if(ac != null)
	      {
	    	  ac.loop();
	      }
	   }
	   public void stop()
	   {
	      if(ac != null)
	      {
	    	  ac.stop();
	      }
	   }
}
