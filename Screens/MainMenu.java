package pvs.screens;


import pvs.objects.Button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends Background {
	private static final String MAIN_MENU_BG = "Assets/UI/MainMenu.jpg";
	private static final String PLAY = "Assets/UI/Buttons/play.png";
	private static final String LOAD = "Assets/UI/Buttons/credits.png";
	private static final String CREDITS = "Assets/UI/Buttons/credits.png";
	
	public MainMenu() {
		super(MAIN_MENU_BG);
		playButton();
		loadButton();
		creditsButton();
	}
	
	private void playButton() {
		Button playGame = new Button(384, 250, PLAY);
		add(playGame);

		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void loadButton() {
		Button loadGame = new Button(384, 362, LOAD);
		add(loadGame);

		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void creditsButton() {
		Button creditsGame = new Button(384, 474, CREDITS);
		add(creditsGame);

		creditsGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
