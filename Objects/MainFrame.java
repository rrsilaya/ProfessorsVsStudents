package pvs.objects;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;

import pvs.screens.Gameplay;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Professors vs. Students");
		this.setResizable(false);

		Container container = this.getContentPane();
		
		// // Set Screens for Main Menu
		// Background menu = new Background("Assets/UI/MainMenu.jpg");
		// container.add(menu, BorderLayout.CENTER);

		Gameplay game = new Gameplay();
		Thread gameThread = new Thread(game);
		container.add(game, BorderLayout.CENTER);
		// gameThread.start();

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}