#include <enunciate-common.c>
#ifndef DEF_server_ns2_baseEntityDTO_H
#define DEF_server_ns2_baseEntityDTO_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_baseEntityDTO {

};

/**
 * Reads a BaseEntityDTO from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The BaseEntityDTO, or NULL in case of error.
 */
static struct server_ns2_baseEntityDTO *xmlTextReaderReadNs2BaseEntityDTOType(xmlTextReaderPtr reader);

/**
 * Writes a BaseEntityDTO to XML.
 *
 * @param writer The XML writer.
 * @param _baseEntityDTO The BaseEntityDTO to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2BaseEntityDTOType(xmlTextWriterPtr writer, struct server_ns2_baseEntityDTO *_baseEntityDTO);

/**
 * Frees the elements of a BaseEntityDTO.
 *
 * @param _baseEntityDTO The BaseEntityDTO to free.
 */
static void freeNs2BaseEntityDTOType(struct server_ns2_baseEntityDTO *_baseEntityDTO);

#endif /* DEF_server_ns2_baseEntityDTO_H */
#ifndef DEF_server_ns2_projectDTO_H
#define DEF_server_ns2_projectDTO_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_projectDTO {

};

/**
 * Reads a ProjectDTO from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The ProjectDTO, or NULL in case of error.
 */
static struct server_ns2_projectDTO *xmlTextReaderReadNs2ProjectDTOType(xmlTextReaderPtr reader);

/**
 * Writes a ProjectDTO to XML.
 *
 * @param writer The XML writer.
 * @param _projectDTO The ProjectDTO to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2ProjectDTOType(xmlTextWriterPtr writer, struct server_ns2_projectDTO *_projectDTO);

/**
 * Frees the elements of a ProjectDTO.
 *
 * @param _projectDTO The ProjectDTO to free.
 */
static void freeNs2ProjectDTOType(struct server_ns2_projectDTO *_projectDTO);

#endif /* DEF_server_ns2_projectDTO_H */
#ifndef DEF_server_ns2_sessionDTO_H
#define DEF_server_ns2_sessionDTO_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_sessionDTO {

};

/**
 * Reads a SessionDTO from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The SessionDTO, or NULL in case of error.
 */
static struct server_ns2_sessionDTO *xmlTextReaderReadNs2SessionDTOType(xmlTextReaderPtr reader);

/**
 * Writes a SessionDTO to XML.
 *
 * @param writer The XML writer.
 * @param _sessionDTO The SessionDTO to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2SessionDTOType(xmlTextWriterPtr writer, struct server_ns2_sessionDTO *_sessionDTO);

/**
 * Frees the elements of a SessionDTO.
 *
 * @param _sessionDTO The SessionDTO to free.
 */
static void freeNs2SessionDTOType(struct server_ns2_sessionDTO *_sessionDTO);

#endif /* DEF_server_ns2_sessionDTO_H */
#ifndef DEF_server_ns2_taskDTO_H
#define DEF_server_ns2_taskDTO_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_taskDTO {

};

/**
 * Reads a TaskDTO from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The TaskDTO, or NULL in case of error.
 */
static struct server_ns2_taskDTO *xmlTextReaderReadNs2TaskDTOType(xmlTextReaderPtr reader);

/**
 * Writes a TaskDTO to XML.
 *
 * @param writer The XML writer.
 * @param _taskDTO The TaskDTO to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2TaskDTOType(xmlTextWriterPtr writer, struct server_ns2_taskDTO *_taskDTO);

/**
 * Frees the elements of a TaskDTO.
 *
 * @param _taskDTO The TaskDTO to free.
 */
static void freeNs2TaskDTOType(struct server_ns2_taskDTO *_taskDTO);

#endif /* DEF_server_ns2_taskDTO_H */
#ifndef DEF_server_ns2_userDTO_H
#define DEF_server_ns2_userDTO_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_userDTO {

};

/**
 * Reads a UserDTO from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The UserDTO, or NULL in case of error.
 */
static struct server_ns2_userDTO *xmlTextReaderReadNs2UserDTOType(xmlTextReaderPtr reader);

/**
 * Writes a UserDTO to XML.
 *
 * @param writer The XML writer.
 * @param _userDTO The UserDTO to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2UserDTOType(xmlTextWriterPtr writer, struct server_ns2_userDTO *_userDTO);

/**
 * Frees the elements of a UserDTO.
 *
 * @param _userDTO The UserDTO to free.
 */
static void freeNs2UserDTOType(struct server_ns2_userDTO *_userDTO);

#endif /* DEF_server_ns2_userDTO_H */
#ifndef DEF_server_ns2_project_H
#define DEF_server_ns2_project_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_project {

};

/**
 * Reads a Project from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Project, or NULL in case of error.
 */
static struct server_ns2_project *xmlTextReaderReadNs2ProjectType(xmlTextReaderPtr reader);

/**
 * Writes a Project to XML.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2ProjectType(xmlTextWriterPtr writer, struct server_ns2_project *_project);

/**
 * Frees the elements of a Project.
 *
 * @param _project The Project to free.
 */
static void freeNs2ProjectType(struct server_ns2_project *_project);

#endif /* DEF_server_ns2_project_H */
#ifndef DEF_server_ns2_session_H
#define DEF_server_ns2_session_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_session {

};

/**
 * Reads a Session from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Session, or NULL in case of error.
 */
static struct server_ns2_session *xmlTextReaderReadNs2SessionType(xmlTextReaderPtr reader);

/**
 * Writes a Session to XML.
 *
 * @param writer The XML writer.
 * @param _session The Session to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2SessionType(xmlTextWriterPtr writer, struct server_ns2_session *_session);

/**
 * Frees the elements of a Session.
 *
 * @param _session The Session to free.
 */
static void freeNs2SessionType(struct server_ns2_session *_session);

#endif /* DEF_server_ns2_session_H */
#ifndef DEF_server_ns2_task_H
#define DEF_server_ns2_task_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_task {

};

/**
 * Reads a Task from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Task, or NULL in case of error.
 */
static struct server_ns2_task *xmlTextReaderReadNs2TaskType(xmlTextReaderPtr reader);

/**
 * Writes a Task to XML.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2TaskType(xmlTextWriterPtr writer, struct server_ns2_task *_task);

/**
 * Frees the elements of a Task.
 *
 * @param _task The Task to free.
 */
static void freeNs2TaskType(struct server_ns2_task *_task);

#endif /* DEF_server_ns2_task_H */
#ifndef DEF_server_ns2_user_H
#define DEF_server_ns2_user_H

/**
 *  @author Roman Kravchenko
 */
struct server_ns2_user {

};

/**
 * Reads a User from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The User, or NULL in case of error.
 */
static struct server_ns2_user *xmlTextReaderReadNs2UserType(xmlTextReaderPtr reader);

/**
 * Writes a User to XML.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs2UserType(xmlTextWriterPtr writer, struct server_ns2_user *_user);

/**
 * Frees the elements of a User.
 *
 * @param _user The User to free.
 */
static void freeNs2UserType(struct server_ns2_user *_user);

#endif /* DEF_server_ns2_user_H */
#ifndef DEF_server_ns2_baseEntityDTO_M
#define DEF_server_ns2_baseEntityDTO_M

/**
 * Reads a BaseEntityDTO from XML. The reader is assumed to be at the start element.
 *
 * @return the BaseEntityDTO, or NULL in case of error.
 */
static struct server_ns2_baseEntityDTO *xmlTextReaderReadNs2BaseEntityDTOType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_baseEntityDTO *_baseEntityDTO = calloc(1, sizeof(struct server_ns2_baseEntityDTO));




  return _baseEntityDTO;
}

/**
 * Writes a BaseEntityDTO to XML.
 *
 * @param writer The XML writer.
 * @param _baseEntityDTO The BaseEntityDTO to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2BaseEntityDTOType(xmlTextWriterPtr writer, struct server_ns2_baseEntityDTO *_baseEntityDTO) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a BaseEntityDTO.
 *
 * @param _baseEntityDTO The BaseEntityDTO to free.
 */
static void freeNs2BaseEntityDTOType(struct server_ns2_baseEntityDTO *_baseEntityDTO) {
  int i;
}
#endif /* DEF_server_ns2_baseEntityDTO_M */
#ifndef DEF_server_ns2_projectDTO_M
#define DEF_server_ns2_projectDTO_M

/**
 * Reads a ProjectDTO from XML. The reader is assumed to be at the start element.
 *
 * @return the ProjectDTO, or NULL in case of error.
 */
static struct server_ns2_projectDTO *xmlTextReaderReadNs2ProjectDTOType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_projectDTO *_projectDTO = calloc(1, sizeof(struct server_ns2_projectDTO));




  return _projectDTO;
}

/**
 * Writes a ProjectDTO to XML.
 *
 * @param writer The XML writer.
 * @param _projectDTO The ProjectDTO to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2ProjectDTOType(xmlTextWriterPtr writer, struct server_ns2_projectDTO *_projectDTO) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a ProjectDTO.
 *
 * @param _projectDTO The ProjectDTO to free.
 */
static void freeNs2ProjectDTOType(struct server_ns2_projectDTO *_projectDTO) {
  int i;
}
#endif /* DEF_server_ns2_projectDTO_M */
#ifndef DEF_server_ns2_sessionDTO_M
#define DEF_server_ns2_sessionDTO_M

/**
 * Reads a SessionDTO from XML. The reader is assumed to be at the start element.
 *
 * @return the SessionDTO, or NULL in case of error.
 */
static struct server_ns2_sessionDTO *xmlTextReaderReadNs2SessionDTOType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_sessionDTO *_sessionDTO = calloc(1, sizeof(struct server_ns2_sessionDTO));




  return _sessionDTO;
}

/**
 * Writes a SessionDTO to XML.
 *
 * @param writer The XML writer.
 * @param _sessionDTO The SessionDTO to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2SessionDTOType(xmlTextWriterPtr writer, struct server_ns2_sessionDTO *_sessionDTO) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a SessionDTO.
 *
 * @param _sessionDTO The SessionDTO to free.
 */
static void freeNs2SessionDTOType(struct server_ns2_sessionDTO *_sessionDTO) {
  int i;
}
#endif /* DEF_server_ns2_sessionDTO_M */
#ifndef DEF_server_ns2_taskDTO_M
#define DEF_server_ns2_taskDTO_M

/**
 * Reads a TaskDTO from XML. The reader is assumed to be at the start element.
 *
 * @return the TaskDTO, or NULL in case of error.
 */
static struct server_ns2_taskDTO *xmlTextReaderReadNs2TaskDTOType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_taskDTO *_taskDTO = calloc(1, sizeof(struct server_ns2_taskDTO));




  return _taskDTO;
}

/**
 * Writes a TaskDTO to XML.
 *
 * @param writer The XML writer.
 * @param _taskDTO The TaskDTO to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2TaskDTOType(xmlTextWriterPtr writer, struct server_ns2_taskDTO *_taskDTO) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a TaskDTO.
 *
 * @param _taskDTO The TaskDTO to free.
 */
static void freeNs2TaskDTOType(struct server_ns2_taskDTO *_taskDTO) {
  int i;
}
#endif /* DEF_server_ns2_taskDTO_M */
#ifndef DEF_server_ns2_userDTO_M
#define DEF_server_ns2_userDTO_M

/**
 * Reads a UserDTO from XML. The reader is assumed to be at the start element.
 *
 * @return the UserDTO, or NULL in case of error.
 */
static struct server_ns2_userDTO *xmlTextReaderReadNs2UserDTOType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_userDTO *_userDTO = calloc(1, sizeof(struct server_ns2_userDTO));




  return _userDTO;
}

/**
 * Writes a UserDTO to XML.
 *
 * @param writer The XML writer.
 * @param _userDTO The UserDTO to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2UserDTOType(xmlTextWriterPtr writer, struct server_ns2_userDTO *_userDTO) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a UserDTO.
 *
 * @param _userDTO The UserDTO to free.
 */
static void freeNs2UserDTOType(struct server_ns2_userDTO *_userDTO) {
  int i;
}
#endif /* DEF_server_ns2_userDTO_M */
#ifndef DEF_server_ns2_project_M
#define DEF_server_ns2_project_M

/**
 * Reads a Project from XML. The reader is assumed to be at the start element.
 *
 * @return the Project, or NULL in case of error.
 */
static struct server_ns2_project *xmlTextReaderReadNs2ProjectType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_project *_project = calloc(1, sizeof(struct server_ns2_project));




  return _project;
}

/**
 * Writes a Project to XML.
 *
 * @param writer The XML writer.
 * @param _project The Project to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2ProjectType(xmlTextWriterPtr writer, struct server_ns2_project *_project) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a Project.
 *
 * @param _project The Project to free.
 */
static void freeNs2ProjectType(struct server_ns2_project *_project) {
  int i;
}
#endif /* DEF_server_ns2_project_M */
#ifndef DEF_server_ns2_session_M
#define DEF_server_ns2_session_M

/**
 * Reads a Session from XML. The reader is assumed to be at the start element.
 *
 * @return the Session, or NULL in case of error.
 */
static struct server_ns2_session *xmlTextReaderReadNs2SessionType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_session *_session = calloc(1, sizeof(struct server_ns2_session));




  return _session;
}

/**
 * Writes a Session to XML.
 *
 * @param writer The XML writer.
 * @param _session The Session to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2SessionType(xmlTextWriterPtr writer, struct server_ns2_session *_session) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a Session.
 *
 * @param _session The Session to free.
 */
static void freeNs2SessionType(struct server_ns2_session *_session) {
  int i;
}
#endif /* DEF_server_ns2_session_M */
#ifndef DEF_server_ns2_task_M
#define DEF_server_ns2_task_M

/**
 * Reads a Task from XML. The reader is assumed to be at the start element.
 *
 * @return the Task, or NULL in case of error.
 */
static struct server_ns2_task *xmlTextReaderReadNs2TaskType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_task *_task = calloc(1, sizeof(struct server_ns2_task));




  return _task;
}

/**
 * Writes a Task to XML.
 *
 * @param writer The XML writer.
 * @param _task The Task to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2TaskType(xmlTextWriterPtr writer, struct server_ns2_task *_task) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a Task.
 *
 * @param _task The Task to free.
 */
static void freeNs2TaskType(struct server_ns2_task *_task) {
  int i;
}
#endif /* DEF_server_ns2_task_M */
#ifndef DEF_server_ns2_user_M
#define DEF_server_ns2_user_M

/**
 * Reads a User from XML. The reader is assumed to be at the start element.
 *
 * @return the User, or NULL in case of error.
 */
static struct server_ns2_user *xmlTextReaderReadNs2UserType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct server_ns2_user *_user = calloc(1, sizeof(struct server_ns2_user));




  return _user;
}

/**
 * Writes a User to XML.
 *
 * @param writer The XML writer.
 * @param _user The User to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs2UserType(xmlTextWriterPtr writer, struct server_ns2_user *_user) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;

  return totalBytes;
}

/**
 * Frees the elements of a User.
 *
 * @param _user The User to free.
 */
static void freeNs2UserType(struct server_ns2_user *_user) {
  int i;
}
#endif /* DEF_server_ns2_user_M */
