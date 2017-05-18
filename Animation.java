import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Animation extends JFrame{
  //private Image image;

  private static final int xDimension = 1000;
  private static final int yDimension = 600;

  public Animation(String name){
    super(name);
    //this.loadImage(filename);
    this.init_menu();
  }

  /* private void loadImage(String filename){
		try{
			image = Toolkit.getDefaultToolkit().getImage(filename);
		} catch(Exception e){}
	} */

  private void init_menu(){
    this.setPreferredSize(new Dimension(xDimension,yDimension));
    this.setResizable(false);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    Container container = this.getContentPane();

    //Change view of window
    JPanel changePanel = new JPanel();
    changePanel.setLayout(new CardLayout());

    //Menu window
    JPanel menuPanel = new JPanel();
    menuPanel.setLayout(new BorderLayout());
    //Instruction window
    JPanel insPanel = new JPanel();
    insPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //Panels
    JPanel backgroundImage = new JPanel();
    backgroundImage.setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(3,1,20,30));
    buttonPanel.setPreferredSize(new Dimension(225,400));

    //Margins
    JPanel marginEast = new JPanel();
    marginEast.setPreferredSize(new Dimension(50,400));
    JPanel marginNorth = new JPanel();
    marginNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
    marginNorth.setPreferredSize(new Dimension(1000,100));
    JPanel marginWest = new JPanel();
    marginWest.setPreferredSize(new Dimension(50,400));
    JPanel marginSouth = new JPanel();
    marginSouth.setPreferredSize(new Dimension(1000,100));

    //Player Name Panel
    JLabel playerName = new JLabel("Player Name");
    JButton player = new JButton();
    player.setEnabled(false);
    player.setPreferredSize(new Dimension(100,25));
    JButton changePlayer = new JButton("Change Player");
    changePlayer.setPreferredSize(new Dimension(125,25));

    //Buttons
    JButton adventure = new JButton("Adventure");
    adventure.setPreferredSize(new Dimension(150, 50));
    adventure.setFont(adventure.getFont().deriveFont(18f));
    adventure.setOpaque(false);
    JButton instruction = new JButton("Instructions");
    instruction.setPreferredSize(new Dimension(150, 50));
    instruction.setFont(instruction.getFont().deriveFont(18f));
    instruction.setOpaque(false);
    JButton exitGame = new JButton("Exit");
    exitGame.setPreferredSize(new Dimension(150, 50));
    exitGame.setFont(exitGame.getFont().deriveFont(18f));
    exitGame.setOpaque(false);
    JButton returnMenu = new JButton("Main Menu");
    returnMenu.setPreferredSize(new Dimension(200, 50));
    returnMenu.setFont(returnMenu.getFont().deriveFont(18f));
    returnMenu.setOpaque(false);

    buttonPanel.add(adventure);
    buttonPanel.add(instruction);
    buttonPanel.add(exitGame);

    marginNorth.add(playerName);
    marginNorth.add(player);
    marginNorth.add(changePlayer);

    backgroundImage.add(buttonPanel, BorderLayout.EAST);

    menuPanel.add(marginNorth, BorderLayout.NORTH);
    menuPanel.add(marginSouth, BorderLayout.SOUTH);
    menuPanel.add(backgroundImage, BorderLayout.CENTER);
    menuPanel.add(marginEast, BorderLayout.EAST);
    menuPanel.add(marginWest, BorderLayout.WEST);

    insPanel.add(returnMenu);

    changePanel.add(menuPanel, "Menu");
    changePanel.add(insPanel, "Instruction");

    container.add(changePanel);

    instruction.addActionListener(new Instruction(instruction, changePanel));
    exitGame.addActionListener(new Exit(exitGame, changePanel));

    returnMenu.addActionListener(new ReturnMenu(returnMenu, changePanel));

    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
}
