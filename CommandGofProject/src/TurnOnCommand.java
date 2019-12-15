
public class TurnOnCommand implements Command {
	
	Television TV;
	
	public TurnOnCommand(Television TV)
	{
		this.TV = TV;
	}
	
	public void execute() {

		TV.TurnOn();
	}
}
