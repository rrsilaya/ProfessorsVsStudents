package pvs.objects;

import pvs.objects.ObjectRendered;
import pvs.objects.Button;
import pvs.objects.Text;
import pvs.screens.Gameplay;
import pvs.University;
import pvs.essentials.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import java.io.File;

public class DragAndDrop implements MouseListener, MouseMotionListener{
  private ObjectRendered object;
  private Gameplay gameplay;
  private University university;

  private boolean canBuy;
  private int mouseX, mouseY, value;

  private final static int DISTANCE = 84;

  public DragAndDrop(ObjectRendered object, University university, Gameplay gameplay, int value){
    this.object = object;
    this.gameplay = gameplay;
    this.university = university;
    this.value = value;
    this.canBuy = true;
  }

  public void canBuy(){
    switch(this.value){
      case 1:
        if(this.university.getFund() < new Tita().getSalary())
          this.canBuy = false;
        else
          this.canBuy = true;
        break;
      case 2:
        if(this.university.getFund() < new Talker().getSalary())
          this.canBuy = false;
        else
          this.canBuy = true;
        break;
      case 3:
        if(this.university.getFund() < new WaterThrower().getSalary())
          this.canBuy = false;
        else
          this.canBuy = true;
        break;
      case 4:
        if(this.university.getFund() < new CoffeeMaker().getSalary())
          this.canBuy = false;
        else
          this.canBuy = true;
        break;
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    this.canBuy();

    if(canBuy){
      this.mouseX = e.getX() + (DISTANCE * value);
      this.mouseY = e.getY() - DISTANCE;
      gameplay.mouseDragging(object, mouseX, mouseY);
      e.consume();
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {
    this.canBuy();

    if(canBuy){
      this.mouseX = e.getX() + (DISTANCE * value);
      this.mouseY = e.getY() - DISTANCE;
      gameplay.mouseDropping(object, mouseX, mouseY, value);
      e.consume();
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
