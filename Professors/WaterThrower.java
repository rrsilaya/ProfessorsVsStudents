package pvs.essentials;
import pvs.University;

public final class WaterThrower extends Professor {
	private final static int HIT_POINTS = 75;
	private final static int DMG_POINTS = 25;
	private final static int ATK_SPEED = 25;
	private final static String TYPE = "Water Thrower";
	private final static int SALARY = 150;
	private final static int COOLDOWN = 20;
	private final static String GRAPHICS = ".png";

	public WaterThrower(University university) {
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