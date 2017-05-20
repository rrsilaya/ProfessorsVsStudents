package pvs.screens;

import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;
import pvs.objects.Button;

import java.util.ArrayList;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import java.io.File;

public class Gameplay extends Background {
	private BufferedImage background;

	public Gameplay() {
		super("Assets/UI/Gameplay/Background.jpg");
		this.repaint();
	}

	private void renderStash(Graphics2D g2d) {
		ObjectRendered stash = new ObjectRendered(30, 0, "Assets/UI/Gameplay/Stash.png"); // fix this pa
			ObjectRendered tita_card = new ObjectRendered(160, -12, "Assets/UI/Gameplay/Cards/Tita.png");
			ObjectRendered talker_card = new ObjectRendered(249, -12, "Assets/UI/Gameplay/Cards/Talker.png");
			ObjectRendered waterSplasher_card = new ObjectRendered(338, -12, "Assets/UI/Gameplay/Cards/WaterSplasher.png");
			ObjectRendered coffeeMaker_card = new ObjectRendered(427, -12, "Assets/UI/Gameplay/Cards/CoffeeMaker.png");
		
		// ObjectRendered menu_btn = new ObjectRendered(850,15, "Assets/UI/Gameplay/Menu.png");
		Button menu_btn = new Button(850, 15, "Assets/UI/Gameplay/Menu.png");

		this.renderObject(stash);
			this.renderObject(tita_card);
			this.renderObject(talker_card);
			this.renderObject(waterSplasher_card);
			this.renderObject(coffeeMaker_card);
		this.renderObject(menu_btn);

		// GameElement Overlay
		this.add(new Sprite(85, 400, "Assets/Professors/Talker.png"));
		this.add(new Sprite(85, 300, "Assets/Professors/Tita.png"));
		this.add(new Sprite(85, 200, "Assets/Professors/CoffeeMaker.png"));
		this.add(new Sprite(85, 100, "Assets/Professors/WaterSplasher.png"));
		this.add(new Sprite(85, 0, "Assets/Professors/Talker.png"));

		// Listener
		menu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Modal should show here.");
			}
		});
	}

	// private void renderKwatro(Graphics2D g2d) {
	// 	ArrayList<ObjectRendered> kwatro = new ArrayList<ObjectRendered>();
	// 	String path = "Assets/UI/Gameplay/Kwatro.png";

	// 	for(int i = 1; i <= 5; i++) {
	// 		kwatro.add(new ObjectRendered(10, 100 * i, path));
	// 		this.renderObject(g2d, kwatro.get(i - 1));
	// 	}
	// }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.background, 0, 0, null);
		this.renderStash(g2d);
		// this.renderKwatro(g2d);
	}
}