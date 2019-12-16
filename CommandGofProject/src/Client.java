import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;

public class Client {
    public static void main(String[] args) throws IOException {
        CommandManager manager = new CommandManager();

//        manager.setCommand(TurnOn);
//        manager.pressButton();
//
//        manager.setCommand(TurnOff);
//        manager.pressButton();
        System.out.println("Avalable commands: \n" +
                "1 - TurnOn \n" +
                "2 - TurnOff \n" +
                "3 - NextChannel \n");
        while (true) {

            System.out.println("Listening command number:");


            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));  // kuulab, mida kasutaja konsooli kirjutab
            String userCommand = reader.readLine();  //loeb kasutaja vastuse muutujassse
            System.out.println(userCommand);  //prindib kasutaja vastuse
            manager.setCommand(userCommand);

        }
    }
}
