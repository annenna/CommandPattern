import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;

public class Client {
    public static void main(String[] args) throws IOException {
        CommandManager manager = new CommandManager();
        Television TV = new Television();
        Command TurnOn = new TurnOnCommand(TV);
        Command TurnOff = new TurnOffCommand(TV);

        manager.setCommand(TurnOn);
        manager.pressButton();

        manager.setCommand(TurnOff);
        manager.pressButton();
        while (true) {
            long tenSec = System.currentTimeMillis();
            System.out.println("Avalable commands: \n" +
                    "1 - TurnOn \n" +
                    "2 - TurnOff \n");
            System.out.println("Listening command number:");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();
            System.out.println(userCommand);
            tenSec += 10000L;
            manager.addScheduledCommand(new Time(tenSec), TurnOn);

        }
    }
}
