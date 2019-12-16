
public class NextChannelCommand implements Command {

    Television TV;

    public NextChannelCommand(Television TV) {
        this.TV = TV;
    }

    public void execute() {

        System.out.println("Channel changed");
    }

    public boolean getIsSchedulable() {
        return isSchedulable;
    }
}
