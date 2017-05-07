package pvs.essentials;

public final class Freshie extends Professor {
	private final static int HIT_POINTS = 150;
	private final static int DMG_POINTS = 10;
	private final static int ATK_SPEED = 10;
	private final static String TYPE = "Freshie";
	private final static String GRAPHICS = ".png";

	public Freshie() {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS);
	}
}