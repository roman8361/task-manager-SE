package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.entity.StatusProjectTask;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface IProjectService {

    void createProject(@NotNull final String projectName,
                       @NotNull final String projectDescription);

    void showAllCommand();

    void addProjectToUser(@NotNull final String userId,
                          @NotNull final String projectId);

    void exit();

    Date addDateBeginProject();

    Date addDateEndProject();

    void updateProject(@NotNull final String projectId,
                       @NotNull final String newProjectName,
                       @NotNull final String newDescription);

    void updateStatusProject(@NotNull final String projectId,
                             @NotNull final StatusProjectTask projectStatus);

    void showAllProjectByAdd();

    void searchInName(@NotNull final String text);

    void searchInDescription(@NotNull final String text);

    void saveDateSerializ();

    void loadDateSerializ();

    void saveDateJAXBtoXML();

    void loadDateJAXBtoMapFromXML();

    void saveDateJAXBtoJson();

    void loadDateJAXBtoMapFromJson();

    void saveDateOMtoXML();

    void loadDateOMtoXML(); //

    void saveDateOMtoJson();

    void loadDateOMtoJson();

}
