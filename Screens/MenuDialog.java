package pvs.screens;

import javax.swing.JDialog;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDialog extends JDialog {
	private static final String DIALOG_MENU_BG = "Assets/UI/MainMenu.jpg";
	private static final String HEADER = ".jpg";
	private static final String INSTRUCTIONS = ".png";
	private static final String MAIN_MENU = ".png";
	private static final String BACK_TO_GAME = ".png";
	
	private Container container; 

	public MenuDialog() {
		this.setAlwaysOnTop(true);
		this.setType(Type.POPUP);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 500, 400);
	

		this.container = this.getContentPane();
		this.container.setLayout(null);
		background();
		header();
		instructionsButton();
		mainMenuButton();
		backToGameButton();
	}

	private void background() {
		JLabel background = new JLabel("Main");
		background.setIcon(null);
		background.setBounds(0, 0, 484, 361);
		this.container.add(background);
	}

	private void header() {
		JLabel header = new JLabel("Header");
		header.setBounds(10, 11, 464, 75);
		this.container.add(header);
	}

	private void instructionsButton() {	
		JButton instructions = new JButton("Instructions");
		instructions.setBounds(117, 97, 250, 75);
		instructions.setActionCommand("OK");
		this.container.add(instructions);

		instructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
	}

	private void mainMenuButton() {
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setBounds(117, 187, 250, 75);
		mainMenu.setActionCommand("OK");
		this.container.add(mainMenu);
		
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}	

	private void backToGameButton() {
		JButton backToGame = new JButton("Return to Game");
		backToGame.setBounds(10, 273, 464, 75);
		backToGame.setActionCommand("OK");
		this.container.add(backToGame);
		//getRootPane().setDefaultButton(backToGame);

		backToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
