import java.sql.Time;

public class CommandManager {
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
		command.Execute();
	}
	public void addScheduledCommand(Time timeToExecute, Command command) {
		
	}
}
