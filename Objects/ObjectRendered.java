package pvs.objects;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ObjectRendered extends JPanel {
	private int x, y;
	protected BufferedImage img;

	public ObjectRendered(int x, int y, String path) {
		this.x = x;
		this.y = y;

		this.setLayout(null);
		this.setOpaque(false);

		try {
			this.img = ImageIO.read(new File(path));
		} catch(Exception e) {}
		
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		System.out.println("Printed");
		g2d.drawImage(this.img, this.x, this.y, null);
	}
}