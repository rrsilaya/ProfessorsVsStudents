package pvs.essentials;
import pvs.University;

public final class CoffeeMaker extends Professor {
	private final static int HIT_POINTS = 130;
	private final static int DMG_POINTS = 40;
	private final static int ATK_SPEED = 25;
	private final static String TYPE = "Coffee Maker";
	private final static int SALARY = 200;
	private final static int COOLDOWN = 35;
	private final static String GRAPHICS = ".png";

	public CoffeeMaker(University university) {
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