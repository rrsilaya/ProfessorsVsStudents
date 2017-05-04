package pvs.objects;

public class Money {
	private final static int AMOUNT = 50;

	public void pick(University u) {
		u.addFund(Money.AMOUNT);
	}
}