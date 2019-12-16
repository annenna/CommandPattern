
public class NextChannel implements Command {

    Television TV;

    public NextChannel(Television TV) {
        this.TV = TV;
    }

    public void execute() {

        System.out.println("Channel changed");
    }

    public boolean getIsSchedulable() {
        return isSchedulable;
    }
}
