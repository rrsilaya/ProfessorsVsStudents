package pvs.objects;

import pvs.University;

public class Money {
	private final static int AMOUNT = 50;

	public void pick(University u) {
		u.addFund(Money.AMOUNT);
	}
}