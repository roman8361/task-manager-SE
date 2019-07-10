package ru.kravchenko.tm.level13;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.service.TaskService;

import java.io.IOException;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public class TaskTest {

    private final TaskService taskDAO = new TaskService();

    private final Lorem lorem = new LoremIpsum();

    public TaskTest() throws IOException {
    }

    @Test
    public void addTask() {
        for (int i = 0; i < 10; i++) addOneTask();
    }

    private void addOneTask() {
        final Task task = new Task();
        task.setDateBegin(new Date());
        task.setDateEnd(new Date());
        task.setDescription(lorem.getWords(3));
        task.setName(lorem.getWords(1));
//        task.setProjectId("14dea650-7578-4477-ba90-87ae1bc69419");
//        task.setUserId("00f2e515-4319-4f71-951a-60621fa49d4c");
        taskDAO.insert(task);
        taskDAO.commit();
    }

    @Test
    public void ids() {
        for (String s : taskDAO.ids()) System.out.println(s);
    }

    @Test
    public void findOne() {
        System.out.println(taskDAO.findById("3abbe4ab-b660-438f-b4fd-ffd29729cc93").getDescription());
    }

    @Test
    public void findAllTaskByUserId() {
        for (Task t : taskDAO.findAllTaskByUserId("00f2e515-4319-4f71-951a-60621fa49d4c")) {
            System.out.println(t.getName());
        }
    }

    @Test
    public void removeById() {
        taskDAO.removeById("6320f59f-2cde-4450-a255-3ce188d3e665");
        taskDAO.commit();
    }

    @Test
    public void removeAllTaskByUserId() {
        taskDAO.removeAllTaskByUserId("00f2e515-4319-4f71-951a-60621fa49d4c");
        taskDAO.commit();
    }

    @Test
    public void clear() {
        taskDAO.clear();
        taskDAO.commit();
    }


}
