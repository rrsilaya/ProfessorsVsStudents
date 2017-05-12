import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Exit implements ActionListener{
  private int exitDialog;
  private JButton button;
  private JPanel panel;

  public Exit(JButton button, JPanel panel){
    this.button = button;
    this.panel = panel;
  }

  public void actionPerformed(ActionEvent e){
    exitDialog = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","Exit", JOptionPane.YES_NO_OPTION);
    if(exitDialog == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
  }
}
