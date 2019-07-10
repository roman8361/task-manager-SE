package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.TaskRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class TaskTest {

    private Lorem lorem = new LoremIpsum();

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private UserRepository userRepository;

    @Test
    public void addAnyTask() {
        for (int i = 0; i < 3; i++) addOneTask();
    }

    private void addOneTask() {
        taskRepository.persist(date());
    }

    private Task date() {
        final Task task = new Task();
        task.setDateBegin(new Date());
        task.setDateEnd(new Date());
        task.setDescription(lorem.getWords(4));
        task.setName(lorem.getWords(1));
        task.setUser(userRepository.findBy("6fee953d-0c0f-4968-9a10-043292780fd0"));
        task.setProject(projectRepository.findBy("091a54e4-1799-45ba-99b3-e9fde856ab4a"));
        return task;
    }

    @Test
    public void clear() {
        taskRepository.removeAll();
    }

    @Test
    public void clear2() {
        List<String> ids = taskRepository.findAllId();
        for (String s: ids) taskRepository.removeById(s);
    }


    @Test
    public void findAll() {
        System.out.println(taskRepository.findAll());
    }

    @Test
    public void findTaskById() {
        System.out.println(taskRepository.findBy("97047aa5-481b-4224-bc3e-0c58e80ddfdf").getName());
    }

    @Test
    public void removeById() {
        taskRepository.removeById("97047aa5-481b-4224-bc3e-0c58e80ddfdf");
    }

    @Test
    public void findAllTaskId() {
        System.out.println(taskRepository.findAllId());
    }

    @Test
    public void findAllTaskByUserId() {
        final User user = userRepository.findBy("e3c39bb6-59e9-443a-b1db-ae39a3a7c6a3");
        System.out.println(taskRepository.findByUser(user));
    }

    @Test
    public void removeAllProjectByUserId() {
        final String userId = "e3c39bb6-59e9-443a-b1db-ae39a3a7c6a3";
        final User user = userRepository.findBy(userId);
        final List<Task> tasks = taskRepository.findByUser(user);
        for (Task t: tasks) taskRepository.removeById(t.getId());
    }

    @Test
    public void taskTestCRUD() {
        final List<Task> taskList = taskRepository.findAll();
        final Task task = new Task();
        task.setName(lorem.getFirstName());
        task.setDateBegin(new Date());
        task.setDateEnd(new Date());
        task.setDescription(lorem.getWords(4));
        task.setProject(projectRepository.findBy("7534c50c-8e1e-4110-a085-8c1f420a6dad"));
        task.setUser(userRepository.findBy("e3c39bb6-59e9-443a-b1db-ae39a3a7c6a3"));
        taskRepository.persist(task);

        final Task projectInsert = taskRepository.findBy(task.getId());
        Assert.assertNotNull(projectInsert);
        taskRepository.removeById(projectInsert.getId());
        Assert.assertNull(taskRepository.findBy(task.getId()));
    }

}
