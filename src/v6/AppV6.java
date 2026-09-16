package v6;

import java.util.Arrays;
import java.util.List;

public class AppV6 {
    public static void main(String[] args) {
        IOConsole console = new IOConsole();
        List<Saving> savers = Arrays.asList(
                new IOFile(),
                new IOMemory(),
                new IOSQLite());

        MultiFlowControl controller = new MultiFlowControl(console, savers);
        controller.control();
    }
}
