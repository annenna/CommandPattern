import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class CommandManager {
//    private Command command;
    private Map<String, Command> buttonsMap = new HashMap<String, Command>();

    public CommandManager(Television TV) {
        this.buttonsMap.put("1", new TurnOnCommand(TV));
        this.buttonsMap.put("2", new TurnOffCommand(TV));
        this.buttonsMap.put("3", new NextChannelCommand(TV));
    }

    public void setCommand(String userInput) throws IOException {
        Command command = this.buttonsMap.get(userInput);
        if (command != null) {
            System.out.println("Found command " + command.getClass().getName());

            if (command.getIsSchedulable()) {
                System.out.println("Do you want to execute now? (Y/n)");
                System.out.println("Press enter if now");
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                String decision = reader.readLine();
                System.out.println(decision);
                if (decision.isEmpty()) {  // kui input on tõhi siis teosta käsk kohe
                    command.execute();
                } else {
                    System.out.println("Enter time in seconds when to execute");

                    BufferedReader delayReader =
                            new BufferedReader(new InputStreamReader(System.in));  // kuulab, mida kasutaja konsooli kirjutab
                    String delayInSeconds = delayReader.readLine();  //loeb kasutaja vastuse muutujassse
                    System.out.println(delayInSeconds);  //prindib kasutaja vastuse
                    long tenSec = System.currentTimeMillis();
                    tenSec += Integer.parseInt(delayInSeconds) * 1000; // kasutaja sisestatud viiteaeg sek > millisekund
                    this.addScheduledCommand(new Time(tenSec), command);  // teosta käsk viitajaga
                }
            } else {
                command.execute();
            }
        } else {
            System.out.println("Command not found!");
        }
    }


    public void addScheduledCommand(Time timeToExecute, Command command) {
        TimerTask wrappedTask = new TimerTask() {
            public void run() {
                System.out.println(command.getClass().getName() + " is executed");
                command.execute();
                try {
                    Thread.sleep(1000L * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer("CommandTimer");

        timer.schedule(wrappedTask, timeToExecute);
        System.out.println("Waiting. The " + command.getClass().getName() + " is scheduled on " + timeToExecute.toString());
    }

    public String getAvailableCommandsString() {
        // Menu
        StringBuilder mapAsString = new StringBuilder("Available commands:\n");
        for (String key : this.buttonsMap.keySet()) {
            mapAsString.append(key + " - " + this.buttonsMap.get(key).getClass().getName() + "\n");
        }
        return mapAsString.toString();
    }
}
