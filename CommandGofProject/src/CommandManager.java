import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class CommandManager {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}

	public void addScheduledCommand(Time timeToExecute, Command command) {
		TimerTask wrappedTask = new TimerTask() {
			public void run() {
                System.out.println("Command executed");
                command.execute();
				try {
					Thread.sleep(1000L * 2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer("CommandTimer");

		timer.schedule(wrappedTask, timeToExecute);
		System.out.println("Waiting...");


	}
}
