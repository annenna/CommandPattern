import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        Television TV = new Television();

        CommandManager manager = new CommandManager(TV);
        System.out.println(manager.getAvailableCommandsString());
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
