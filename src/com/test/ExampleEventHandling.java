package com.test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class ExampleEventHandling extends Applet implements MouseListener  {
	StringBuffer strBuffer;
    void addItem(String word) {
        System.out.println(word);
        strBuffer.append(word);
        repaint();
    }
	public void init(){
		addMouseListener(this);
        strBuffer = new StringBuffer();
        addItem("initializing the apple ");
	}
	public void paint(Graphics g){
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.drawString(strBuffer.toString(), 10, 20);
        setBackground(Color.blue);
	}
    public void start() {
        addItem("starting the applet ");
    }
 
    public void stop() {
        addItem("stopping the applet ");
    }
 
    public void destroy() {
        addItem("unloading the applet");
    }
	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
        addItem("mouse clicked! ");
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
