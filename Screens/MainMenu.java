package pvs.screens;

import pvs.objects.MainFrame;
import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;
import pvs.objects.Button;
import pvs.objects.Text;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import java.io.File;


public class MainMenu extends Background{
  private Container container;
  private MainFrame frame;

  public MainMenu(Container container, MainFrame frame){
    super("Assets/UI/MainMenu.jpg");
    this.container = container;
    this.frame = frame;
    this.init_menu();
  }

  private void init_menu(){
    Button playGame = new Button(750, 50, "Assets/UI/Buttons/play.png");
    this.renderObject(playGame);
    playGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // container.removeAll();
        // // Gameplay game = new Gameplay(this.frame);
        // container.add(game, BorderLayout.CENTER);

        // frame.pack();
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
      }
    });

    Button credits = new Button(750, 150, "Assets/UI/Buttons/credits.png");
    this.renderObject(credits);

    this.repaint();
  }
}
