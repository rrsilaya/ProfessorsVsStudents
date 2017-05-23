package pvs.screens;

import pvs.objects.MainFrame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDialog extends JDialog {
	private static final String DIALOG_MENU_BG = "Assets/UI/MainMenu.jpg";
	private static final String HEADER = ".jpg";
	private static final String INSTRUCTIONS = ".png";
	private static final String MAIN_MENU = ".png";
	private static final String BACK_TO_GAME = ".png";
	
	private MainFrame mainFrame;
	private Container container;
	private Container dialogContainer;

	public MenuDialog(MainFrame mainFrame, Container container) {
		this.setAlwaysOnTop(true);
		this.setType(Type.POPUP);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(450, 200, 500, 400);
	
		this.mainFrame = mainFrame;
		this.container = container;
		this.dialogContainer = this.getContentPane();
		this.dialogContainer.setLayout(null);

		this.background();
		this.header();
		this.instructionsButton();
		this.mainMenuButton();
		this.backToGameButton();
	}

	private void background() {
		JLabel background = new JLabel("Main");
		background.setIcon(null);
		background.setBounds(0, 0, 484, 361);
		this.dialogContainer.add(background);
	}

	private void header() {
		JLabel header = new JLabel("Header");
		header.setBounds(10, 11, 464, 75);
		this.dialogContainer.add(header);
	}

	private void instructionsButton() {	
		JButton instructions = new JButton("Instructions");
		instructions.setBounds(117, 97, 250, 75);
		this.dialogContainer.add(instructions);

		instructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
	}

	private void mainMenuButton() {
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setBounds(117, 187, 250, 75);
		this.dialogContainer.add(mainMenu);
		
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SAVE GAME
				container.removeAll();
				MainMenu mainMenu = new MainMenu(mainFrame, container);
				container.add(mainMenu, BorderLayout.CENTER);

				mainFrame.pack();
		        mainFrame.setLocationRelativeTo(null);
		        mainFrame.setVisible(true);
			}
		});
		this.repaint();
	}	

	private void backToGameButton() {
		JButton backToGame = new JButton("Return to Game");
		backToGame.setBounds(10, 273, 464, 75);
		this.dialogContainer.add(backToGame);

		backToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
