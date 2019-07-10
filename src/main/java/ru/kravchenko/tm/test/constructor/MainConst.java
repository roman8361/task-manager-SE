package ru.kravchenko.tm.test.constructor;

import ru.kravchenko.tm.test.constructor.service.ProjectServiceConst;
import ru.kravchenko.tm.test.constructor.service.TaskServiceConst;

/**
 * @author Roman Kravchenko
 */

public class MainConst {

    public static void main(String[] args) {

        ProjectServiceConst projectServiceConst = new ProjectServiceConst();
        TaskServiceConst taskServiceConst = new TaskServiceConst(projectServiceConst);

        projectServiceConst.mergeProject();
        projectServiceConst.showAllProject();

        taskServiceConst.mergeTask();
        taskServiceConst.showAllTask();




    }

}
