package pvs.essentials;

public final class Graduating extends Professor {
	private final static int HIT_POINTS = 175;
	private final static int DMG_POINTS = 25;
	private final static int ATK_SPEED = 15;
	private final static String TYPE = "Graduating";
	private final static String GRAPHICS = ".png";

	public Graduating() {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS);
	}
}