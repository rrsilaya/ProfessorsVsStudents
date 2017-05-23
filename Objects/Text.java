package pvs.objects;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.lang.String;
import java.lang.Integer;

public class Text extends JLabel {
	private int x;
	private int y;

	public Text(int x, int y, String content) {
		super(content, SwingConstants.CENTER);
		this.setSize(85, 25);

		this.x = x;
		this.y = y;

		this.setLocation(this.x, this.y);
		this.setFont(this.getFont().deriveFont(22f));
		this.setForeground(Color.WHITE);
	}

	public Text(int x, int y, int content) {
		super(new Integer(content).toString(), SwingConstants.CENTER);
		this.setSize(85, 25);

		this.x = x;
		this.y = y;

		this.setLocation(this.x, this.y);
		this.setFont(this.getFont().deriveFont(22f));
	}
}
