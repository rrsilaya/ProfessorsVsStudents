package pvs.objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import pvs.screens.Gameplay;
import pvs.screens.Background;
import pvs.objects.Button;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Professors vs. Students");
		this.setResizable(false);

		Container container = this.getContentPane();
		JPanel main = new JPanel();
		container.add(main, BorderLayout.CENTER);
		main.setLayout(new CardLayout());
		
		Background mainMenu = new Background("Assets/UI/MainMenu.jpg");
		Button playGame = new Button(750, 50, "Assets/UI/Buttons/play.png");
		mainMenu.renderObject(playGame);
		Button credits = new Button(750, 150, "Assets/UI/Buttons/credits.png");
		mainMenu.renderObject(credits);

		Gameplay game = new Gameplay(this);

		main.add(mainMenu, "menu");
		main.add(game, "game");

		CardLayout cardLayout = (CardLayout) main.getLayout();

		// Render Listeners
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "game");
				game.startGame();
			}
		});

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
