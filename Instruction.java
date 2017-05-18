import java.awt.CardLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Instruction implements ActionListener{
  private JButton button;
  private JPanel panel;

  public Instruction(JButton button, JPanel panel){
    this.button = button;
    this.panel = panel;
  }

  public void actionPerformed(ActionEvent e){
    CardLayout c = (CardLayout) panel.getLayout();
    c.show(panel, "Instruction");
  }
}
