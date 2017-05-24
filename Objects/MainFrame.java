package pvs.objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;

import java.io.File;
import java.io.IOException;

import pvs.screens.Gameplay;
import pvs.screens.Background;

import pvs.objects.Button;

public class MainFrame extends JFrame {
	private JPanel main;
	private Font customFont;
	public MainFrame() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Professors vs. Students");
		this.setResizable(false);

		Container container = this.getContentPane();


		this.main = new JPanel(new CardLayout());
		container.add(this.main, BorderLayout.CENTER);
		
		
		/*--MAIN MENU--*/
		Background mainMenu = new Background("Assets/UI/MainMenu.jpg");
		Button playGame = new Button(495, 376, "Assets/UI/Buttons/play.png");
		mainMenu.renderObject(playGame);
		Button credits = new Button(495, 484, "Assets/UI/Buttons/credits.png");
		mainMenu.renderObject(credits);

		Button playerButton = new Button(619, 43, "Assets/UI/Buttons/player.png");
		mainMenu.renderObject(playerButton);
		//this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/indiestarbb_bld.ttf"));
		//this.customFont= this.customFont.deriveFont(Font.PLAIN, 45f);
		JLabel playerName = new JLabel("PLAYER NAME");
		playerName.setBounds(632, 55, 317, 80);
		playerName.setFont(this.customFont);
		mainMenu.add(playerName);

		Button newPlayerButton = new Button(619, 158, "Assets/UI/Buttons/newplayer.png");
		mainMenu.renderObject(newPlayerButton);
	
		
		
		/*--CREDITS--*/
		Background creditsPage = new Background("");


		/*--GAME PLAY--*/
		Gameplay game = new Gameplay(this, container);


		this.main.add(mainMenu, "MAIN MENU");
		this.main.add(creditsPage, "CREDITS");
		this.main.add(game, "GAME AREA");

		

		// Render Listeners
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)main.getLayout();
				cardLayout.show(main, "GAME AREA");
				game.startGame();
			}
		});
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)main.getLayout();
				cardLayout.show(main, "CREDITS PAGE");
			}
		});

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JPanel getMain(){
		return this.main;
	}
}
