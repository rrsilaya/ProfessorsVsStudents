package pvs.objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import pvs.screens.Gameplay;
import pvs.screens.Background;
import pvs.objects.Button;

public class MainFrame extends JFrame {
	private JPanel main;
	private CardLayout cardLayout;
	private Font customFont;

	private Background mainMenu;
	private Background credits;
	private Background pauseMenu;
	private Background userMenu;
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
		this.renderUserMenu();

		this.main.add(this.mainMenu, "menu");
		this.main.add(this.game, "game");
		this.main.add(this.credits, "credits");
		this.main.add(this.pauseMenu, "pause");
		this.main.add(this.userMenu, "user");

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void renderPauseMenu() {
		this.pauseMenu = new Background("Assets/UI/Gameplay/PauseMenu.png");

		Button resume = new Button(370, 300, "Assets/UI/Gameplay/BackToGame.png");
		Button exitPauseMenu = new Button(370, 375, "Assets/UI/Gameplay/ExitToMenu.png");

		this.pauseMenu.renderObject(resume);
		this.pauseMenu.renderObject(exitPauseMenu);

		// Listeners
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("resume");
				cardLayout.show(main, "game");
				game.resume();
			}
		});

		exitPauseMenu.addActionListener(new ActionListener() {
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

		Button playGame = new Button(415, 320, "Assets/UI/Buttons/play.png");
		Button creditsBtn = new Button(483, 440, "Assets/UI/Buttons/credits.png");
		Button exitCredits = new Button(440, 500, "Assets/UI/Gameplay/ExitToMenu.png");
			this.credits.renderObject(exitCredits);
		Button playerButton = new Button(619, 43, "Assets/UI/Buttons/player.png");
			JLabel playerName = new JLabel("PLAYER NAME");
			//this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/indiestarbb_bld.ttf"));
			//this.customFont= this.customFont.deriveFont(Font.PLAIN, 45f);
			playerName.setBounds(632, 55, 317, 80);
			playerName.setFont(this.customFont);
		Button newPlayerButton = new Button(619, 158, "Assets/UI/Buttons/newplayer.png");
		
		this.mainMenu.renderObject(playGame);
		this.mainMenu.renderObject(creditsBtn);
		this.mainMenu.renderObject(playerButton);
		mainMenu.add(playerName);
		this.mainMenu.renderObject(newPlayerButton);


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

		newPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "user");
			}
		});
	}

	private void renderUserMenu() {
		this.userMenu = new Background("Assets/UI/Gameplay/PauseMenu.png");

		JTextField playerText = new JTextField();
				playerText.setFont(new Font("Tahoma", Font.PLAIN, 34));
				playerText.setHorizontalAlignment(SwingConstants.CENTER);
				playerText.setBounds(367, 195, 266, 66);
				playerText.setColumns(1);
		Button enterText = new Button(367, 298, "Assets/UI/Gameplay/EnterText.png");
		Button exitUserMenu = new Button(367, 365, "Assets/UI/Gameplay/ExitToMenu.png");

		userMenu.add(playerText);
		this.userMenu.renderObject(enterText);
		this.userMenu.renderObject(exitUserMenu);

		exitUserMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main, "menu");
				game.resume();
				game.end();
			}
		});
	}
	public void openPause() {
		this.cardLayout.show(main, "pause");
	}
}
