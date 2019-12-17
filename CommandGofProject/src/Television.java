
public class Television {
	private boolean on;
	
	public void TurnOn() {

		on = true;
		System.out.println("TV is on!");
	}
	public void TurnOff() {

		on = false;
		System.out.println("TV is off!");
	}

	public void ChangeChannel() {

		on = true;
		System.out.println("Channel changed");
	}
}
