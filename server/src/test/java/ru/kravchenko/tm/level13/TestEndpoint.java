package ru.kravchenko.tm.level13;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.endpoint.TaskEndpoint;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.service.LocatorServiceBean;

/**
 * @author Roman Kravchenko
 */


public class TestEndpoint {

    @NotNull
    private IServiceLocator serviceLocator = new LocatorServiceBean();

    public TestEndpoint() throws Exception {
    }

    @Test
    public void testEndPointProject() throws AccessForbiddenException {
        Session session = serviceLocator.getSessionService().findById("8ad2f6ee-0a37-43c9-9251-83b085a4930c");
        TaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);

        taskEndpoint.createTask(session,
                "48d0ae38-942c-4356-8b39-e489e5e4280c",
                "qqqq",
                "ddddd");

    }


}
