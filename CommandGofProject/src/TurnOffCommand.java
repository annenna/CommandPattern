
public class TurnOffCommand implements Command{
	
	Television TV;
	public boolean isSchedulable = true;
	
	public TurnOffCommand(Television TV) {

		this.TV = TV;
	}
	
	public void execute() {

		TV.TurnOff();
	}

	public boolean getIsSchedulable() {
		return isSchedulable;
	}
}
