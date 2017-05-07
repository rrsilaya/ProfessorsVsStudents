package pvs.essentials;
import pvs.University;

public final class Tita extends Professor {
	private final static int HIT_POINTS = 75;
	private final static int DMG_POINTS = 0;
	private final static int ATK_SPEED = 10;
	private final static String TYPE = "Tita";
	private final static int SALARY = 50;
	private final static int COOLDOWN = 20;
	private final static String GRAPHICS = ".png";

	public Tita(University university) {
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