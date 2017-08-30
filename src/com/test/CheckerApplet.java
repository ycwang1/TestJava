package com.test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class CheckerApplet extends Applet {
	int squareSize=50;
	public void init(){
	   String squareSizeParam = getParameter ("squareSize");
	   parseSquareSize (squareSizeParam);
	   String colorParam = getParameter ("color");
	   Color fg = parseColor (colorParam);
	   setBackground (Color.black);
	   setForeground (fg);
	};
	private void parseSquareSize(String params){
		if (params == null) return;
		   try {
		      squareSize = Integer.parseInt (params);
		   }
		   catch (Exception e) {
		     // ±£¡Ùƒ¨»œ÷µ
		   }
	}
	private Color parseColor(String params){
		return Color.white;
		
	}
	public void paint(Graphics g){}
}
