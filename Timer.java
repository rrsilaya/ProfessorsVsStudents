package pvs.objects;

public class Timer implements Runnable {
	private int time;
	private final int interval;
	private final int purpose;
	private boolean isActive;

	public final static int COUNTDOWN = 1;
	public final static int TIMER = 2;

	public Timer() {
		this.purpose = Timer.TIMER;
		this.interval = 1;
		this.isActive = true;
	}

	public Timer(int time) {
		this.purpose = Timer.COUNTDOWN;
		this.interval = 1;
		this.isActive = true;
		this.time = time;
	}

	public Timer(int time, int interval, int purpose) {
		this.interval = interval;
		this.time = time / this.interval;
		this.purpose = purpose;
		this.isActive = true;
	}

	// Threading
	@Override
	public void run() {
		switch(this.purpose) {
			case COUNTDOWN:
				while(this.time != 0) {
					this.time -= this.interval;

					try {
						Thread.sleep(1000);
					} catch(Exception e) {}

					System.out.printf("[ Timer: 0:%02d ]\n", this.time);
				}

				this.isActive = false;
				break;
			case TIMER:
				while(this.isActive) {
					this.time += this.interval;

					try {
						Thread.sleep(1000);
					} catch(Exception e) {}

					System.out.printf("[ Timer: 0:%02d ]\n", this.time);
				}

				break;
		}
	}

	// Setters
	public void stop() {
		this.isActive = false;
	}

	// Getters
	public int getTime() {
		return this.time;
	}

	public int getPurpose() {
		return this.purpose;
	}
}