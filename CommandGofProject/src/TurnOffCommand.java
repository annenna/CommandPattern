
public class TurnOffCommand implements Command{
	
	Television TV;
	
	public TurnOffCommand(Television TV) {

		this.TV = TV;
	}
	
	public void execute() {

		TV.TurnOff();
	}
}
