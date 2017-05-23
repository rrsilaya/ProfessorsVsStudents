package pvs.screens;

import pvs.objects.MainFrame;
import pvs.objects.Button;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends Background {
	private static final String MAIN_MENU_BG = "Assets/UI/MainMenu.jpg";
	private static final String PLAY = "Assets/UI/Buttons/play.png";
	private static final String LOAD = "Assets/UI/Buttons/credits.png";
	private static final String CREDITS = "Assets/UI/Buttons/credits.png";
	
	private MainFrame mainFrame;
	private Container container;
	
	public MainMenu(MainFrame mainFrame, Container container) {
		super(MAIN_MENU_BG);
		this.container = container;
		this.mainFrame = mainFrame;
		this.playButton();
		this.loadButton();
		this.creditsButton();
	}
	
	private void playButton() {
		Button playGame = new Button(384, 250, PLAY);
		add(playGame);
		this.renderObject(playGame);
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gameplay game = new Gameplay(mainFrame,container);
				container.removeAll();
				container.add(game, BorderLayout.CENTER);

		        mainFrame.pack();
		        mainFrame.setLocationRelativeTo(null);
		        mainFrame.setVisible(true);
			}
		});
		this.repaint();
	}

	private void loadButton() {
		Button loadGame = new Button(384, 362, LOAD);
		this.renderObject(loadGame);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void creditsButton() {
		Button creditsGame = new Button(384, 474, CREDITS);
		add(creditsGame);
		this.renderObject(creditsGame);
		creditsGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
