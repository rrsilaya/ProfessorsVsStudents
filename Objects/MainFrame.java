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
	private JPanel main;
	private CardLayout cardLayout;

	private Background mainMenu;
	private Background credits;
	private Background pauseMenu;
	private Gameplay game;

	public MainFrame() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Professors vs. Students");
		this.setResizable(false);

		Container container = this.getContentPane();

		this.main = new JPanel();
		container.add(this.main, BorderLayout.CENTER);

		this.main.setLayout(new CardLayout());
		this.cardLayout = (CardLayout) this.main.getLayout();

		this.game = new Gameplay(this);
		this.renderMainMenu();
		this.renderPauseMenu();

		this.main.add(this.mainMenu, "menu");
		this.main.add(this.game, "game");
		this.main.add(this.credits, "credits");
		this.main.add(this.pauseMenu, "pause");

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void renderPauseMenu() {
		this.pauseMenu = new Background("Assets/UI/Gameplay/PauseMenu.png");

		Button resume = new Button(370, 300, "Assets/UI/Gameplay/BackToGame.png");
		Button exit = new Button(370, 375, "Assets/UI/Gameplay/ExitToMenu.png");

		this.pauseMenu.renderObject(resume);
		this.pauseMenu.renderObject(exit);

		// Listeners
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("resume");
				cardLayout.show(main, "game");
				game.resume();
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "menu");
				game.resume();
				game.end();
			}
		});
	}

	private void renderMainMenu() {
		this.mainMenu = new Background("Assets/UI/MainMenu.jpg");
		this.credits = new Background("Assets/UI/Credits.jpg");

		Button playGame = new Button(580, 70, "Assets/UI/Buttons/play.png");
		Button creditsBtn = new Button(580, 200, "Assets/UI/Buttons/credits.png");
		Button exitCredits = new Button(440, 500, "Assets/UI/Gameplay/ExitToMenu.png");

		this.mainMenu.renderObject(playGame);
		this.mainMenu.renderObject(creditsBtn);
		this.credits.renderObject(exitCredits);

		// Render Listeners
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "game");
				game.startGame();
			}
		});

		creditsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "credits");
			}
		});

		exitCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "menu");
			}
		});
	}

	public void openPause() {
		this.cardLayout.show(main, "pause");
	}
}
