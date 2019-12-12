
public class TurnOffCommand implements Command{
	
	Television TV;
	
	public TurnOffCommand(Television TV) {
		this.TV = TV;
	}
	
	public void Execute() {
		TV.TurnOff();
	}
}
