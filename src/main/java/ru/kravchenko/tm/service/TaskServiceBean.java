package ru.kravchenko.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.TaskRepositoryBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class TaskServiceBean implements ITaskService {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService1;

    @NotNull
    private ITaskRepository taskRepositoryBean;

    @NotNull
    private IProjectRepository projectRepository;

    private TaskRepositoryBean taskRepository;

    public TaskServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService1 = serviceLocator.getTerminalService();
        this.projectRepository = serviceLocator.getProjectRepository();
        this.taskRepositoryBean = serviceLocator.getTaskRepository();
        this.taskRepository = (TaskRepositoryBean) serviceLocator.getTaskRepository();
        initTask();
    }

    private void initTask() {
        final Project project1 = new Project();
        final Project project2 = new Project();
        final Project project3 = new Project();
        mergeTask(project1.getId(), "TASK NAME1", "description1");
        mergeTask(project2.getId(), "TASK NAME2", "description2");
        mergeTask(project3.getId(), "TASK NAME3", "description3");
    }

    public void mergeTask(@Nullable final String projectId,
                          @Nullable final String taskName,
                          @Nullable final String taskDescription) {
        final @NotNull Project project = projectRepository.findOne(projectId);
        final @NotNull Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setProject(project);
        taskRepositoryBean.addTask(task.getId(),task);
    }

    @Override
    public String getIdFromUser() {
        System.out.println("Please enter id task: ");
        final @NotNull String idTask = terminalService1.nextLine();
        return idTask;
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        final @NotNull Task task = taskRepositoryBean.findOneId(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        taskRepositoryBean.addTask(task.getId(),task);
        System.out.println("Task is update to project");
    }

    @Override
    public void updateTaskStatus(@NotNull final String taskId, @NotNull final StatusProjectTask taskStatus) {
        if (taskId == null || taskId.isEmpty()) return;
        @NotNull final Task task = taskRepositoryBean.findOneId(taskId);
        task.setDisplayName(taskStatus);
        taskRepositoryBean.addTask(taskId, task);
        System.out.println("Task status update");
    }

    @Override
    @SneakyThrows
    public void saveDateSerializ() {
        final Map mapSave = taskRepository.getTaskRepository();
        final FileOutputStream fileOutputStream = new FileOutputStream("D:/ser/tm/task/data.tmp");
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(mapSave);
        objectOutputStream.close();
        objectOutputStream.close();
        System.out.println("Date save to file date.tmp (D:/ser/tm/task)");

    }

    @Override
    @SneakyThrows
    public void loadDateSerializ() {
        final FileInputStream fileInputStream = new FileInputStream(new File("D:/ser/tm/task/data.tmp"));
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Map map = (Map) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        taskRepository.setTaskRepository(map);
        System.out.println("Date is load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateJAXBtoXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(TaskRepositoryBean.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(taskRepository, new File("d:/ser/tm/task/jaxbmaptoxml.xml"));
        System.out.println("Date save to file jaxbmaptoxml.xml (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateJAXBtoMapFromXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(TaskRepositoryBean.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final TaskRepositoryBean bean = (TaskRepositoryBean) jaxbUnmarshaller.unmarshal(new File("d:/ser/tm/task/jaxbmaptoxml.xml"));
        taskRepository.setTaskRepository(bean.getTaskRepository());
        System.out.println("Date from file jaxbmaptoxml.xml load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateJAXBtoJson() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(TaskRepositoryBean.class);
        final File file = new File("D:/ser/tm/task/jaxbtojsonmap.json");
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(taskRepository, file);
        System.out.println("Date save to file jaxbtojsonmap.json (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateJAXBtoMapFromJson() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(TaskRepositoryBean.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
        final TaskRepositoryBean bean = (TaskRepositoryBean) jaxbUnmarshaller.unmarshal(new File("D:/ser/tm/task/jaxbtojsonmap.json"));
        taskRepository.setTaskRepository(bean.getTaskRepository());
        System.out.println("Date from file jaxbtojsonmap.json load to repository");
    }

    @Override
    public void saveDateOMtoXML() {

    }

    @Override
    public void loadDateOMtoXML() {

    }

    @Override
    @SneakyThrows
    public void saveDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:/ser/tm/maptojson.json"), taskRepository);
        System.out.println("Date save to file maptojsontask.json (D:/ser/tm/maptojson.json)");
    }

    @Override
    @SneakyThrows
    public void loadDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final TaskRepositoryBean result = objectMapper.readValue(new File("D:/ser/tm/maptojson.json"), TaskRepositoryBean.class );
        taskRepository.setTaskRepository(result.getTaskRepository());
        System.out.println("Date from file maptojsontask.json load to repository");
    }

}
