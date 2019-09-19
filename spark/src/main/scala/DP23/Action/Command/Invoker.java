package DP23.Action.Command;
/**
 * Created by litianye on 2019-07-11
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-11
 **/

public class Invoker {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void cancelCommand() {
        command.cancel();
    }
}
