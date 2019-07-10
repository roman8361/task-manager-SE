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
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class ProjectServiceBean implements IProjectService {

    @NotNull
    private final IServiceLocator serviceLocator;

    public ProjectServiceBean(@NotNull final IServiceLocator serviceLocator) throws UserNotFoundException {
        this.serviceLocator = serviceLocator;
        initProject();
    }

    private void initProject() throws UserNotFoundException {
        @NotNull final Project project = new Project("testProject");
        project.setDescription("setDescription");
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        String userId = serviceLocator.getUserRepository().findByLogin("admin").getId();
        project.setUserId(userId);
        serviceLocator.getProjectRepository().addProject(project);

        @NotNull final Project projectAdmin = new Project("testProjectAdmin");
        projectAdmin.setDescription("setDescriptionAdmin");
        projectAdmin.setDateBegin(new Date());
        projectAdmin.setDateEnd(new Date());
        projectAdmin.setUserId(userId);
        serviceLocator.getProjectRepository().addProject(projectAdmin);

        @NotNull final Project project2 = new Project("testProject2");
        project2.setDescription("test Project 2");
        project2.setDateBegin(new Date(1));
        project2.setDateEnd(new Date(1));
        project2.setDisplayName(StatusProjectTask.PROCESS);
        serviceLocator.getProjectRepository().addProject(project2);
    }

    @Override
    public void createProject(@NotNull final Session session,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) throws AccessForbiddenException, UserNotFoundException {
        serviceLocator.getSessionService().validate(session);
        @NotNull final Project project = new Project(nameProject);
        project.setDescription(descriptionProject);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setUserId(session.getUserId());
        serviceLocator.getProjectRepository().addProject(project);
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
        @NotNull final String dateBegin = serviceLocator.getTerminalService().nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        @NotNull final String dateEnd = serviceLocator.getTerminalService().nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!serviceLocator.getProjectRepository().existProject(projectId)) return;
        if (!serviceLocator.getProjectRepository().existProject(projectId)) return;
        final @NotNull Project project = new Project(newProjectName);
        project.setDescription(newDescription);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        serviceLocator.getProjectRepository().addProject(project);
        System.out.println("Project id: " + projectId + "  update");
    }

    @Override
    public void updateStatusProject(@Nullable final String projectId, @NotNull final StatusProjectTask projectStatus) {
        if (projectId == null || projectId.isEmpty()) return;
        @NotNull final Project project = serviceLocator.getProjectRepository().findOne(projectId);
        project.setDisplayName(projectStatus);
        serviceLocator.getProjectRepository().addProject(project);
        System.out.println("Project status update");
    }

    @Override
    public void showAllProjectByAdd(@NotNull final String projectId) {
//        LinkedList<Project> linkedList = (LinkedList<Project>) projectRepository.findAllUserId();
        LinkedList<Project> linkedList = (LinkedList<Project>) serviceLocator.getProjectRepository().findAllUserId(projectId);
        System.out.println(linkedList);
    }

    @Override
    public void searchInName(@NotNull final String text, @NotNull final String userId) {
        Collection<Project> list = serviceLocator.getProjectRepository().findAllUserId(userId);
        for (final Project project : list) {
            if (project.getName().contains(text)) {
                System.out.println(project);
            } else {
                System.out.println("Text not found.");
            }
        }
    }

    @Override
    public void searchInDescription(@NotNull final String text, @NotNull final String userId) {
        Collection<Project> list = serviceLocator.getProjectRepository().findAllUserId(userId);
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
        final Map mapSave = serviceLocator.getProjectRepository().getRepository();
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
        serviceLocator.getProjectRepository().setRepository(map);
        System.out.println("Date is load to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateJAXBtoXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(serviceLocator.getProjectRepository(), new File("d:/ser/tm/jaxbmaptoxml.xml"));
        System.out.println("Date save to file jaxbmaptoxml.xml (D:/ser/tm)");
    }

    @Override
    @SneakyThrows
    public void loadDateJAXBtoMapFromXML() {
        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final ProjectRepositoryBean bean = (ProjectRepositoryBean) jaxbUnmarshaller.unmarshal(new File("d:/ser/tm/jaxbmaptoxml.xml"));
        serviceLocator.getProjectRepository().setRepository(bean.getProjectRepository());
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
        marshaller.marshal(serviceLocator.getProjectRepository(), file);
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
        serviceLocator.getProjectRepository().setRepository(bean.getProjectRepository());
        System.out.println("Date from file jaxbtojsonmap.json load to repository");
    }

    @Override
    @SneakyThrows // TO DO
    public void saveDateOMtoXML() {
        final Map map = (Map) serviceLocator.getProjectRepository();
        final XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:/ser/tm/maptoxml.xml"), map);
        System.out.println("Date save to file maptoxml.xml (D:/ser/tm/maptoxml.xml)");
    }

    @Override
    @SneakyThrows // TO DO
    public void loadDateOMtoXML() {
        final XmlMapper xmlMapper = new XmlMapper();
        final File file = new File("D:/ser/tm/maptoxml.xml");
        final ProjectRepositoryBean bean = xmlMapper.readValue(file, ProjectRepositoryBean.class);
//        projectRepository.setProjectRepository(bean.getProjectRepository());
        System.out.println("Date add to repository");
    }

    @Override
    @SneakyThrows
    public void saveDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:/ser//tm/maptojson.json"), serviceLocator.getProjectRepository());
        System.out.println("Date save to file maptojsontask.json (D:/ser/tm/maptojson.json)");
    }

    @Override
    @SneakyThrows
    public void loadDateOMtoJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ProjectRepositoryBean result = objectMapper.readValue(new File("D:/ser/tm/maptojson.json"), ProjectRepositoryBean.class);
        serviceLocator.getProjectRepository().setRepository(result.getRepository());
        System.out.println("Date from file maptojsontask.json load to repository");
    }

}
