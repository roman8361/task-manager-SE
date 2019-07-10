package ru.kravchenko.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class ProjectServiceBean implements IProjectService {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private ProjectRepositoryBean projectRepository;

    @NotNull
    private final UserRepositoryBean userRepositoryBean;

    public ProjectServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        terminalService = serviceLocator.getTerminalService();
        userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        projectRepository = (ProjectRepositoryBean) serviceLocator.getProjectRepository();
        initProject();
    }

    private void initProject() {
        @NotNull  final Project project = new Project("testProject");
        project.setDescription("setDescription");
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        projectRepository.addProject(project.getId(), project);

        @NotNull final Project project2 = new Project("testProject2");
        project2.setDescription("test Project 2");
        project2.setDateBegin(new Date(1));
        project2.setDateEnd(new Date(1));
        project2.setDisplayName(StatusProjectTask.PROCESS);
        projectRepository.addProject(project2.getId(), project2);
    }

    @Override
    public void createProject(@NotNull final String nameProject, @NotNull final String descriptionProject) {
        @NotNull final Project project = new Project(nameProject);
        project.setDescription(descriptionProject);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectRepository.addProject(project.getId(), project);
        System.out.println("Project add to repository");
    }

    @Override
    public void exit() {
        System.out.println("Come back later...");
        System.exit(0);
    }

    @Override
    @SneakyThrows
    public Date addDateBeginProject() {
        System.out.println("Please enter date begin project: (dd.MM.yyyy)");
        @NotNull final String dateBegin = terminalService.nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        @NotNull final String dateEnd = terminalService.nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectRepository.existKeys(projectId)) return;
        final @NotNull Project project = new Project(newProjectName);
        project.setDescription(newDescription);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectRepository.addProject(projectId, project);
        System.out.println("Project id: " + projectId + "  update");
    }

    @Override
    public void updateStatusProject(@Nullable final String projectId, @NotNull final StatusProjectTask projectStatus) {
        if (projectId == null || projectId.isEmpty()) return;
        @NotNull final Project project = projectRepository.findOne(projectId);
        project.setDisplayName(projectStatus);
        projectRepository.addProject(projectId, project);
        System.out.println("Project status update");
    }

    @Override
    public void showAllProjectByAdd() {
        LinkedList<Project> linkedList = (LinkedList<Project>) projectRepository.findAll();
        System.out.println(linkedList);
    }

    @Override
    public void searchInName(@NotNull final String text) {
        Collection<Project> list = projectRepository.findAll();
        for (final Project project : list) {
            if (project.getName().contains(text)) {
                System.out.println(project);
            } else {
                System.out.println("Text not found.");
            }
        }
    }

    @Override
    public void searchInDescription(@NotNull final String text) {
        Collection<Project> list = projectRepository.findAll();
        for (final Project project : list) {
            if (project.getDescription().contains(text)) {
                System.out.println(project);
            } else {
                System.out.println("Text not found.");
            }
        }
    }

    @Override
    @SneakyThrows
    public void saveDateSerializ() {
        final LinkedHashMap mapSave = (LinkedHashMap) projectRepository.getProjectRepository();
        final FileOutputStream fileOutputStream = new FileOutputStream("D:/ser/tm/data.tmp");
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(mapSave);
        objectOutputStream.close();
        objectOutputStream.close();
        System.out.println("Date save to file date.tmp (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateSerializ() {
        final FileInputStream fileInputStream = new FileInputStream(new File("D:/ser/tm/data.tmp"));
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Map map = (Map) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        projectRepository.setProjectRepository(map);
        System.out.println("Date is load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateJAXBtoXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(projectRepository, new File("d:/ser/tm/jaxbmaptoxml.xml"));
        System.out.println("Date save to file jaxbmaptoxml.xml (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateJAXBtoMapFromXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final ProjectRepositoryBean bean = (ProjectRepositoryBean) jaxbUnmarshaller.unmarshal(new File("d:/ser/tm/jaxbmaptoxml.xml"));
        projectRepository.setProjectRepository(bean.getProjectRepository());
        System.out.println("Date from file jaxbmaptoxml.xml load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateJAXBtoJson() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final File file = new File("D:/ser/tm/jaxbtojsonmap.json");
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(projectRepository, file);
        System.out.println("Date save to file jaxbtojsonmap.json (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateJAXBtoMapFromJson() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
        final ProjectRepositoryBean bean = (ProjectRepositoryBean) jaxbUnmarshaller.unmarshal(new File("D:/ser/tm/jaxbtojsonmap.json"));
        projectRepository.setProjectRepository(bean.getProjectRepository());
        System.out.println("Date from file jaxbtojsonmap.json load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateOMtoXML() {
        final Map map = projectRepository.getProjectRepository();
        final XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:/ser/tm/maptoxml.xml"),map);
        System.out.println("Date save to file maptoxml.xml (D:/ser/tm/maptoxml.xml)");
    }

    @Override
    @SneakyThrows // TO DO
    public void loadDateOMtoXML() {
        final XmlMapper xmlMapper = new XmlMapper();
        final File file = new File("D:/ser/tm/maptoxml.xml");
        final ProjectRepositoryBean bean = xmlMapper.readValue(file, ProjectRepositoryBean.class);
        projectRepository.setProjectRepository(bean.getProjectRepository());
        System.out.println("Date add to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:/ser//tm/maptojson.json"), projectRepository);
        System.out.println("Date save to file maptojsontask.json (D:/ser/tm/maptojson.json)");
    }

    @Override
    @SneakyThrows
    public void loadDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ProjectRepositoryBean result = objectMapper.readValue(new File("D:/ser/tm/maptojson.json"), ProjectRepositoryBean.class );
        projectRepository.setProjectRepository(result.getProjectRepository());
        System.out.println("Date from file maptojsontask.json load to repository");
    }

    @Override
    public void showAllCommand() {
        System.out.println("help: Show all command.");
        System.out.println("user-registry: Registry new user.");
        System.out.println("user-authorization: Login user.");
        System.out.println("user-logout: Logout user.");
        System.out.println("user-change-profile: Change profile user.");
        System.out.println("user-change-password: Change user password.");
        System.out.println("user-all-show: Show all users in Base Date.");
        System.out.println("user-all-show-online: Show all user on line.");
        System.out.println("project-add-user: Add project to user id.");
        System.out.println("project-clear: Remove all projects.");
        System.out.println("project-create: Create new project.");
        System.out.println("project-dump: Save project date form repository in disk");
        System.out.println("project-list: Show all project.");
        System.out.println("project-load: Load project form disk to repository");
        System.out.println("project-update: Update project by id.");
        System.out.println("project-update-status: Update project status by id.");
        System.out.println("project-remove: Remove selected project by id.");
        System.out.println("project-search: Search project by name or description.");
        System.out.println("task-clear: Remove all tasks.");
        System.out.println("task-create: Create new task.");
        System.out.println("task-dump: Save task date form repository in disk");
        System.out.println("task-list: Show all tasks.");
        System.out.println("task-load: Load task form disk to repository");
        System.out.println("task-update: Update task by id.");
        System.out.println("task-update-status: Update project status by id.");
        System.out.println("exit: Exit");
    }

    @Override
    public void addProjectToUser(@Nullable final String userLogin, @Nullable final String projectId) {
        final @NotNull User user = userRepositoryBean.findByLogin(userLogin, userRepositoryBean.getUsersLoginBase());
        final @NotNull Map<String, User> usersBaseDateThisProject = new LinkedHashMap<>();
        user.setProject(projectRepository.findOne(projectId));
        usersBaseDateThisProject.put(user.getLogin(), user);
        userRepositoryBean.setUsersBaseDate(usersBaseDateThisProject);
        System.out.println("Project add to user: " + userLogin);
    }

}
