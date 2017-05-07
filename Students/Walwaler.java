package pvs.essentials;

public final class Walwaler extends Professor {
	private final static int HIT_POINTS = 160;
	private final static int DMG_POINTS = 15;
	private final static int ATK_SPEED = 15;
	private final static String TYPE = "Walwaler";
	private final static String GRAPHICS = ".png";

	public Walwaler() {
		super(HIT_POINTS,
			  DMG_POINTS,
			  ATK_SPEED,
			  TYPE,
			  GRAPHICS);
	}
}