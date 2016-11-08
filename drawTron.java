//
// drawTron
// Created by Zein Youssef on 2016-08-03.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class drawTron extends JComponent implements ActionListener, KeyListener{
	
	//Player positions
	int player1x = 40, player1y = 320;
	int player2x = 600, player2y = 320;
	String direction1 = "right", direction2 = "left";
	Color black = new Color(0,0,0);
	Color blue = new Color(0,0,255);
	Color red = new Color(255,0,0);
	ArrayList<Integer> p1x = new ArrayList<>();
	ArrayList<Integer> p1y = new ArrayList<>();
	ArrayList<Integer> p2x = new ArrayList<>();
	ArrayList<Integer> p2y = new ArrayList<>();
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//Draws the background
		g2.setColor(black);
		g2.fillRect(0,0,640,640);
		
		
		//Checks for collisions
		for (int i = 0; i < p1x.size(); i++)
		{
			if (player1x == p2x.get(i) && player1y == p2y.get(i)|| player1x >= 640 || player1x < 0
			|| player1y >= 640 || player1y < 0 || player1x == p1x.get(i) && player1y == p1y.get(i) )
				System.exit(1000);
		}
		for (int i = 0; i < p1x.size(); i++)
		{
			if (player2x == p1x.get(i) && player2y == p1y.get(i) || player2x >= 640 || player2x < 0
					|| player2y >= 640 || player2y < 0 || player2x == p2x.get(i) && player2y == p2y.get(i) )
				System.exit(1000);
		}
		
		
		p1x.add(player1x);
		p1y.add(player1y);
		p2x.add(player2x);
		p2y.add(player2y);
		
		//Draws the starting positions of player 1 and 2
		for (int i = 0; i < p1x.size(); i++)
		{
		g2.setColor(blue);
		g2.fillRect(p1x.get(i),p1y.get(i),5,5);
		}
		for (int i = 0; i < p2x.size(); i++)
		{
		g2.setColor(red);
		g2.fillRect(p2x.get(i),p2y.get(i),5,5);
		}
		
		//player 1 movement
		if (direction1 == "left")
			player1x -= 5;
		else if (direction1 == "right")
			player1x += 5;
		else if (direction1 == "up")
			player1y -= 5;
		else if (direction1 == "down")
			player1y += 5;
		
		//player 2 movement
		if (direction2 == "left")
			player2x -= 5;
		else if (direction2 == "right")
			player2x += 5;
		else if (direction2 == "up")
			player2y -= 5;
		else if (direction2 == "down")
			player2y += 5;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	
	@Override 
	public void keyPressed(KeyEvent e)
	{
		//player 1 controls
		if (e.getKeyCode() == KeyEvent.VK_A && direction1 != "right")
			direction1 = "left";
		else if (e.getKeyCode() == KeyEvent.VK_D && direction1 != "left")
			direction1 = "right";
		else if (e.getKeyCode() == KeyEvent.VK_W && direction1 != "down")
			direction1 = "up";
		else if (e.getKeyCode() == KeyEvent.VK_S && direction1 != "up")
			direction1 = "down";
			
		//player 2 controls
		if (e.getKeyCode() == KeyEvent.VK_LEFT && direction2 != "right")
			direction2 = "left";
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction2 != "left")
			direction2 = "right";
		else if (e.getKeyCode() == KeyEvent.VK_UP && direction2 != "down")
			direction2 = "up";
		else if (e.getKeyCode() == KeyEvent.VK_DOWN && direction2 != "up")
			direction2 = "down";
		
		repaint();	
	}
	
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0)
	{
		
	}

}