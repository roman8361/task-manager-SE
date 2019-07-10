package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.UserNotFoundException;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface IProjectService {

    void createProject(@NotNull final Session session,
                       @NotNull final String projectName,
                       @NotNull final String projectDescription) throws AccessForbiddenException, UserNotFoundException;

    void exit();

    Date addDateBeginProject();

    Date addDateEndProject();

    void updateProject(@NotNull final String projectId,
                       @NotNull final String newProjectName,
                       @NotNull final String newDescription) throws AccessForbiddenException;

    void updateStatusProject(@NotNull final String projectId,
                             @NotNull final StatusProjectTask projectStatus) throws AccessForbiddenException;

    void showAllProjectByAdd(@NotNull final String projectId);

    void searchInName(@NotNull final String text, @NotNull final String userId);

    void searchInDescription(@NotNull final String text, @NotNull final String userId);

    void saveDateSerializ();

    void loadDateSerializ();

    void saveDateJAXBtoXML();

    void loadDateJAXBtoMapFromXML();

    void saveDateJAXBtoJson();

    void loadDateJAXBtoMapFromJson();

    void saveDateOMtoXML();

    void loadDateOMtoXML();

    void saveDateOMtoJson();

    void loadDateOMtoJson();

}
