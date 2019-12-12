import java.sql.Time;

public class Client {
	public static void main(String[] args) {
		CommandManager manager = new CommandManager();
		Television TV = new Television();
		Command TurnOn = new TurnOnCommand(TV);
		Command TurnOff = new TurnOffCommand(TV);
		
		manager.setCommand(TurnOn);
		manager.pressButton();
		
		manager.setCommand(TurnOff);
		manager.pressButton();
		
		manager.addScheduledCommand(new Time("17:00:00"), TurnOn);
	}
}
