
public class TurnOnCommand implements Command {
	
	Television TV;
	
	public TurnOnCommand(Television TV) {
		this.TV = TV;
	}
	
	public void Execute() {
		TV.TurnOn();
	}
}
