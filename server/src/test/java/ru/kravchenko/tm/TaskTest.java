package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.TaskRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.bootstrap.AppConfig;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TaskTest {

    private Lorem lorem = new LoremIpsum();

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

//    @Test
    public void addAnyTask() {
        for (int i = 0; i < 7; i++) addOneTask();
    }

    private void addOneTask() {
        taskRepository.save(date());
    }

    private Task date() {
        final Task task = new Task();
        task.setDateBegin(new Date());
        task.setDateEnd(new Date());
        task.setDescription(lorem.getWords(4));
        task.setName(lorem.getWords(1));
        task.setUser(userRepository.findById("5d9a7949-5bfd-4028-be60-a6b5a1583419").get());
        task.setProject(projectRepository.findById("22ef9558-e0d1-4911-b52f-73f2c627fc75").get());
        return task;
    }

//    @Test
    public void clear() {
        taskRepository.deleteAll();
    }

//    @Test
    public void findAll() {
        System.out.println(taskRepository.findAll());
    }

//    @Test
    public void findTaskById() {
        System.out.println(taskRepository.findById("119f3110-04c1-4120-9b54-f7fefc41a4f0").get().getName());
    }

//    @Test
    public void removeById() {
        taskRepository.removeById("119f3110-04c1-4120-9b54-f7fefc41a4f0");
    }

//    @Test
    public void findAllTaskId() {
        System.out.println(taskRepository.findAllId());
    }

//    @Test
    public void findAllTaskByUserId() {
        final User user = userRepository.findById("5d9a7949-5bfd-4028-be60-a6b5a1583419").get();
        System.out.println(taskRepository.findByUser(user));
    }

//    @Test
    public void removeAllProjectByUserId() {
        final String userId = "5d9a7949-5bfd-4028-be60-a6b5a1583419";
        final User user = userRepository.findById(userId).get();
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
        taskRepository.save(task);

        final Task projectInsert = taskRepository.findById(task.getId()).get();
        Assert.assertNotNull(projectInsert);
        taskRepository.removeById(projectInsert.getId());
        Assert.assertNotNull(taskRepository.findById(task.getId()));
    }

}
