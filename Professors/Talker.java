package pvs.essentials;
import pvs.University;

public final class Talker extends Professor {
	private final static int HIT_POINTS = 120;
	private final static int DMG_POINTS = 20;
	private final static int ATK_SPEED = 30;
	private final static String TYPE = "Talker";
	private final static int SALARY = 100;
	private final static int COOLDOWN = 20;
	private final static String GRAPHICS = ".png";

	public Talker(University university) {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS,
			  SALARY,
			  COOLDOWN,
			  university);
	}
}