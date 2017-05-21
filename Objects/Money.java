package pvs.objects;

import pvs.University;
import pvs.essentials;

public class Money {
	private University univ;

	private final static int AMOUNT = 50;

	public Money(University univ){
		this.univ = univ;
	}

	public void pick(University u) {
		u.addFund(Money.AMOUNT);
	}

	public void addProfessor(Professor prof){
		if(prof.canHired(Money.AMOUNT)){
			this.decMoney(prof.getSalary());
			this.univ.decFund(prof.getSalary());
		}
	}

	private void decMoney(int money){
		Money.AMOUNT -= money;
	}
}
