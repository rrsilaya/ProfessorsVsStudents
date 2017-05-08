package pvs.objects;
import pvs.University;

public class Timer implements Runnable {
	private int time;
	private final int interval;
	private final int purpose;
	private boolean isActive;
	private University university;

	public final static int COUNTDOWN = 1;
	public final static int TIMER = 2;

	public Timer(University university) {
		this.purpose = Timer.TIMER;
		this.interval = 1;
		this.isActive = true;
		this.university = university;
	}

	public Timer(int time, University university) {
		this.purpose = Timer.COUNTDOWN;
		this.interval = 1;
		this.isActive = true;
		this.time = time;
		this.university = university;
	}

	public Timer(int time, int interval, int purpose, University university) {
		this.interval = interval;
		this.time = time / this.interval;
		this.purpose = purpose;
		this.isActive = true;
		this.university = university;
	}

	// Threading
	@Override
	public void run() {
		try {
			Thread.sleep(7500);
		} catch(Exception e) {}

		switch(this.purpose) {
			case COUNTDOWN:
				while(this.time != 0) {
					this.university.log();
					this.time -= this.interval;

					try {
						Thread.sleep(1000);
					} catch(Exception e) {}

					// System.out.printf("[ Timer: 0:%02d ]\n", this.time);
				}

				this.isActive = false;
				break;
			case TIMER:
				while(this.isActive) {
					this.university.log();
					this.time += this.interval;

					try {
						Thread.sleep(1000);
					} catch(Exception e) {}

					// System.out.printf("[ Timer: 0:%02d ]\n", this.time);
				}

				break;
		}
	}

	// Setters
	public void stop() {
		this.isActive = false;
	}

	// Getters
	public boolean isActive() {
		return this.isActive;
	}

	public int getTime() {
		return this.time;
	}

	public int getPurpose() {
		return this.purpose;
	}
}