import javax.swing.*;
import java.awt.*;

public class BrickBreaker {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Breakout");
		window.pack();
		window.setSize(600, 600);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawBrickBreaker game = new drawBrickBreaker();
		window.addKeyListener(game);
		Timer t = new Timer(30, game);
		window.add(game);
		t.start();
	}
}