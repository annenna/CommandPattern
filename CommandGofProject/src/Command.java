
public interface Command {
	public boolean isSchedulable = false;
	public void execute();
	public boolean getIsSchedulable();
}
