package pvs.screens;

import pvs.objects.ObjectRendered;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Gameplay extends Background {
	private Background background;

	public Gameplay() {
		super("Assets/UI/Gameplay/Background.jpg");

		// Addition of Stash
		// this.add(new ObjectRendered(20, 0, "Assets/UI/Gameplay/Stash.png"));
		ObjectRendered stash = new ObjectRendered(20, 0, "Assets/UI/Gameplay/Stash.png");
		this.add(stash, BorderLayout.CENTER);
	}
}