import javax.swing.*;
import java.awt.*;

public class Tron{

	public static void main(String[] args) {
		JFrame window = new JFrame("Tron");
		window.pack();
		window.setSize(640, 640);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawTron game = new drawTron();
		window.addKeyListener(game);
		Timer t = new Timer(50, game);
		window.add(game);
		t.start();
		
	}
}