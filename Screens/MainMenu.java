package pvs.screens;

import pvs.objects.MainFrame;
import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;
import pvs.objects.Button;
import pvs.objects.Text;
import pvs.University;
import pvs.essentials.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import java.io.File;


public class MainMenu extends Background{
  private BufferedImage background;
  private Container container;
  private MainFrame frame;

  public MainMenu(Container container, MainFrame frame){
    super("Assets/UI/MainMenu.jpg");
    this.container = container;
    this.frame = frame;
    this.init_menu();
  }

  private void init_menu(){
    //Buttons
    Button playGame = new Button(750, 50, "Assets/UI/Buttons/play.png");
    this.renderObject(playGame);
    playGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Gameplay game = new Gameplay(container, frame);
        container.removeAll();
        container.add(game, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });

    Button credits = new Button(750, 150, "Assets/UI/Buttons/credits.png");
    this.renderObject(credits);

    this.repaint();
  }

  @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.background, 0, 0, null);
	}
}
