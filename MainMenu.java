// UNFINISHED NOTE: MAKE BUTTONS IMAGES, SET SIZE AND POSITION
// MAKE RETURN FUNCTION AFTER ABOUT CARD LAYOUT
// IDEA: MAKE A METHOD THAT WILL BRING BACK THE USER TO MAIN MENU ONCE HE/SHE QUITS PLAYING
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;

public class MainMenu {
	public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setPreferredSize(new Dimension(1000, 600));
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container gameArea = frame.getContentPane();

	/*----------MAIN MENU----------*/
	JPanel mainMenu = new JPanel();
	gameArea.add(mainMenu, BorderLayout.CENTER);

	/*----------MAIN MENU BUTTONS----------*/
	JPanel menuButtons = new JPanel();
	
	menuButtons.setLayout(new GridLayout(4,1));
	JButton newButton = new JButton("New Game"); 
	JButton loadButton = new JButton("Load Game");
	JButton aboutButton = new JButton("About");
	JButton exitButton = new JButton("Exit");
	menuButtons.add(newButton);
	menuButtons.add(loadButton);
	menuButtons.add(aboutButton);
	menuButtons.add(exitButton);
	menuButtons.setLocation(150, 150);
	mainMenu.add(menuButtons);

	mainMenu.setLayout(new CardLayout());
		/*----------NEW GAME----------*/
		JPanel newGame = new JPanel();
		//NEW GAME
		/*----------LOAD GAME----------*/
		JPanel loadGame = new JPanel();
		//LOAD GAME
		/*----------ABOUT GAME----------*/
		JPanel aboutGame = new JPanel();
		//ABOUT GAME
		/*----------EXIT GAME----------*/
		JPanel exitGame = new JPanel();
	/*----------MAIN MENU LISTENERS----------*/
	mainMenu.add(newGame, "newGame");
	mainMenu.add(loadGame, "loadGame");
	mainMenu.add(aboutGame, "aboutGame");
	mainMenu.add(exitGame, "exitGame");

	newButton.addActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout currentPanel = (CardLayout)mainMenu.getLayout();
				currentPanel.show(mainMenu, "newGame");
			}
		}
	);

	loadButton.addActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout currentPanel = (CardLayout)mainMenu.getLayout();
				currentPanel.show(mainMenu, "loadGame");
			}
		}
	);

	aboutButton.addActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout currentPanel = (CardLayout)mainMenu.getLayout();
				currentPanel.show(mainMenu, "aboutGame");
			}
		}
	);

	exitButton.addActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout currentPanel = (CardLayout)mainMenu.getLayout();
				currentPanel.show(mainMenu, "exitGame");
			}
		}
	);

	frame.pack();
	frame.setVisible(true);
	}
}