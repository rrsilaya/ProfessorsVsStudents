package pvs.essentials;
import pvs.University;

public final class Freshie extends Student {
	private final static int HIT_POINTS = 150;
	private final static int DMG_POINTS = 10;
	private final static int ATK_SPEED = 10;
	private final static String TYPE = "Freshie";
	private final static String GRAPHICS = ".png";
	private final static int MOVEMENT_SPEED = 20;

	public Freshie(University university) {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS,
			  MOVEMENT_SPEED,
			  university);
	}
}