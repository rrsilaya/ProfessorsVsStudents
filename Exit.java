import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Exit implements ActionListener{
  private JButton button;
  private JPanel panel;

  public Exit(JButton button, JPanel panel){
    this.button = button;
    this.panel = panel;
  }

  public void actionPerformed(ActionEvent e){
    System.exit(0);
  }
}
