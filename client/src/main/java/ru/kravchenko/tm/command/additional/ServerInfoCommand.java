package ru.kravchenko.tm.command.additional;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.ServerEndpoint;

/**
 * @author Roman Kravchenko
 */

public class ServerInfoCommand extends AbstractCommand {

    @Override
    public String getName() { return "server-info"; }

    @Override
    public void getDescription() {
        System.out.println("server-info: Server info command");
    }

    @Override
    public void execute() {
        System.out.println("***Server info command***");
        @NotNull final ServerEndpoint serverEndpoint = serviceLocator.getServerEndpoint();

        System.out.println("HOST: " + serverEndpoint.getInfoHost());
        System.out.println("PORT: " + serverEndpoint.getInfoPort());
        System.out.println("OK");
    }

}
