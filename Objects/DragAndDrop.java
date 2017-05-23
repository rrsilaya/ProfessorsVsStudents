package pvs.objects;

import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;
import pvs.objects.Button;
import pvs.objects.Text;
import pvs.objects.MainFrame;
import pvs.screens.Gameplay;
import pvs.University;
import pvs.essentials.*;

import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import java.io.File;

public class DragAndDrop implements MouseListener, MouseMotionListener{
  private ObjectRendered object;
  private Gameplay gameplay;

  private boolean mouseDragged;
  private int mouseX, mouseY, value;

  private final static int DISTANCE = 84;

  public DragAndDrop(ObjectRendered object, Gameplay gameplay, int value){
    this.object = object;
    this.gameplay = gameplay;
    this.value = value;
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    this.mouseX = e.getX() + (DISTANCE * value);
    this.mouseY = e.getY() - DISTANCE;
    this.mouseDragged = true;
    gameplay.mouseDragging(object, mouseDragged, mouseX, mouseY, value);
    e.consume();
  }

  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {
    this.mouseX = e.getX() + (DISTANCE * value);
    this.mouseY = e.getY() - DISTANCE;
    this.mouseDragged = false;
    gameplay.mouseDragging(object, mouseDragged, mouseX, mouseY, value);
    e.consume();
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
