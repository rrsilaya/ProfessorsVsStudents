package pvs.objects;

import pvs.University;
import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class Timer extends JPanel implements Runnable {
	private int time;
	private final int total;
	private final int interval;
	private boolean isActive;
	private University university;
	private BufferedImage timeProgress;
	private BufferedImage bar;
	private BufferedImage bg;

	public Timer(int time, University university) {
		this.interval = 1;
		this.isActive = true;
		this.time = time;
		this.total = time;
		this.university = university;

		try {
			this.bg = ImageIO.read(new File("Assets/UI/Gameplay/Loader.png"));
			this.timeProgress = ImageIO.read(new File("Assets/UI/Gameplay/TimeID.png"));
			this.bar = ImageIO.read(new File("Assets/UI/Gameplay/Bar.png"));
		} catch (Exception e) {}

		this.setOpaque(false);
		this.setSize(1000, 600);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.bg, 735, 565, null);
		g2d.drawImage(this.timeProgress, ((int) Math.ceil(((float)this.time / this.total) * 185) + 735), 568, null);
	}

	// Threading
	@Override
	public void run() {
		try {
			Thread.sleep(7500);
		} catch(Exception e) {}

		while(this.time != 0 && this.university.isActive()) {
			this.university.log();
			this.time -= this.interval;

			this.repaint();

			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}

		this.isActive = false;
	}

	// Setters
	public void stop() {
		this.isActive = false;
	}

	// Getters
	public boolean isActive() {
		return this.isActive;
	}

	public int getTime() {
		return this.time;
	}

	public boolean isHellWeek() {
		return this.time < 25 ? true : false;
	}
}