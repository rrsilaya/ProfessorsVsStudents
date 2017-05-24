package pvs.essentials;
import pvs.University;

public final class Sabaw extends Student {
	private final static int HIT_POINTS = 160;
	private final static int DMG_POINTS = 15;
	private final static int ATK_SPEED = 15;
	private final static String TYPE = "Sabaw";
	private final static String GRAPHICS = ".png";
	private final static int MOVEMENT_SPEED = 25;

	public Sabaw() {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS,
			  MOVEMENT_SPEED);
	}
}