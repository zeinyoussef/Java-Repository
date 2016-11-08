//
// drawBreakout
// Created by Zein Youssef on 2016-08-03.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class drawBrickBreaker extends JComponent implements ActionListener, KeyListener{
	
	Color Black = new Color(0,0,0);
	Color White = new Color(255,255,255);
		
	//Ball Stats
	int ballx = 300, bally = 200;
	int ballspeedx = 3, ballspeedy = 3;		
	
	//Paddle Stats
	int paddlex = 275, paddley = 500;
	int paddlespeedx = 5, direction = 0;
	
	//Bricks
	boolean[][] bricks = new boolean[][]{
		{ true, true, true, true, true, true, true, true, true, true, true, true },
		{ true, true, true, true, true, true, true, true, true, true, true, true },
		{ true, true, true, true, true, true, true, true, true, true, true, true },
		{ true, true, true, true, true, true, true, true, true, true, true, true }
	};
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//Draws the background
		g2.setColor(Black);
		g2.fillRect(0, 0, 600, 600);
		
		//Draws the paddle
		g2.setColor(White);
		g2.fillRect(paddlex,paddley, 50, 10);
		
		//Draws the ball
		g2.fillOval(ballx, bally, 10, 10);
		
		//Draws the bricks
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 12; j++)
			{
				if (bricks[i][j] == true && (ballx >= j*50 && ballx <= j*50 + 50 && bally > (i*15) + 50 && bally < (i*15) + 65))
					{
						ballspeedy *= -1;
						bricks[i][j] = false;
					}
				if (bricks[i][j] == true)
					g2.fillRect(j * 50, (i*15) + 50, 50,15);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//ball movement
		if (ballx >= 590)
			ballspeedx = -4;
		else if (ballx <= 0)
			ballspeedx = 4;
		else if (bally >= 565)
			ballspeedy = -4;
		else if (bally <= 0)	
			ballspeedy = 4;
			
		//ball and paddle collision
		else if (ballx >= paddlex && ballx < (paddlex + 15) && bally >= (paddley - 5))
		{
			ballspeedx = -4;
			ballspeedy = -4;
		}
		else if (ballx >= paddlex + 15 && ballx < paddlex + 35 && bally >= paddley - 5)
		{
			ballspeedy = -4;
		}
		else if (ballx >= paddlex + 35 && ballx < paddlex + 50 && bally >= paddley - 5)
		{
			ballspeedx = 4;
			ballspeedy = -4;
		}
		
		
		ballx += ballspeedx;
		bally += ballspeedy;
		
		//paddle movement
		if (direction == 1)
			paddlex -= paddlespeedx;
		else if (direction == 2)
			paddlex += paddlespeedx;
			
		repaint();
	}
	
	@Override 
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			direction = 1;
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			direction = 2;
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
			direction = 0;
	}
	@Override
	public void keyTyped(KeyEvent arg0)
	{
		
	}

}