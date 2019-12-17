
public class NextChannelCommand implements Command {

    Television TV;

    public NextChannelCommand(Television TV) {

        this.TV = TV;
    }

    public void execute() {

        TV.ChangeChannel();
    }

    public boolean getIsSchedulable() {
        return isSchedulable;
    }
}
