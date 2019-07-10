#import "server.h"
#ifndef DEF_SERVERNS2AbstractEntity_M
#define DEF_SERVERNS2AbstractEntity_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2AbstractEntity

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2AbstractEntity */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2AbstractEntity (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2AbstractEntity (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2AbstractEntity (JAXB)

/**
 * Read an instance of SERVERNS2AbstractEntity from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2AbstractEntity defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2AbstractEntity *_sERVERNS2AbstractEntity = [[SERVERNS2AbstractEntity alloc] init];
  NS_DURING
  {
    [_sERVERNS2AbstractEntity initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2AbstractEntity = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2AbstractEntity autorelease];
  return _sERVERNS2AbstractEntity;
}

/**
 * Initialize this instance of SERVERNS2AbstractEntity according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2AbstractEntity to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2AbstractEntity (JAXB) */

#endif /* DEF_SERVERNS2AbstractEntity_M */
#ifndef DEF_SERVERNS2AbstractEntityDTO_M
#define DEF_SERVERNS2AbstractEntityDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2AbstractEntityDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2AbstractEntityDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2AbstractEntityDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2AbstractEntityDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2AbstractEntityDTO (JAXB)

/**
 * Read an instance of SERVERNS2AbstractEntityDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2AbstractEntityDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2AbstractEntityDTO *_sERVERNS2AbstractEntityDTO = [[SERVERNS2AbstractEntityDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2AbstractEntityDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2AbstractEntityDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2AbstractEntityDTO autorelease];
  return _sERVERNS2AbstractEntityDTO;
}

/**
 * Initialize this instance of SERVERNS2AbstractEntityDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2AbstractEntityDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2AbstractEntityDTO (JAXB) */

#endif /* DEF_SERVERNS2AbstractEntityDTO_M */
#ifndef DEF_SERVERNS2SessionDTO_M
#define DEF_SERVERNS2SessionDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2SessionDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2SessionDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2SessionDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2SessionDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2SessionDTO (JAXB)

/**
 * Read an instance of SERVERNS2SessionDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2SessionDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2SessionDTO *_sERVERNS2SessionDTO = [[SERVERNS2SessionDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2SessionDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2SessionDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2SessionDTO autorelease];
  return _sERVERNS2SessionDTO;
}

/**
 * Initialize this instance of SERVERNS2SessionDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2SessionDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2SessionDTO (JAXB) */

#endif /* DEF_SERVERNS2SessionDTO_M */
#ifndef DEF_SERVERNS2Session_M
#define DEF_SERVERNS2Session_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2Session

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2Session */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2Session (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2Session (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2Session (JAXB)

/**
 * Read an instance of SERVERNS2Session from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2Session defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2Session *_sERVERNS2Session = [[SERVERNS2Session alloc] init];
  NS_DURING
  {
    [_sERVERNS2Session initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2Session = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2Session autorelease];
  return _sERVERNS2Session;
}

/**
 * Initialize this instance of SERVERNS2Session according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2Session to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2Session (JAXB) */

#endif /* DEF_SERVERNS2Session_M */
#ifndef DEF_SERVERNS2User_M
#define DEF_SERVERNS2User_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2User

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2User */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2User (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2User (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2User (JAXB)

/**
 * Read an instance of SERVERNS2User from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2User defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2User *_sERVERNS2User = [[SERVERNS2User alloc] init];
  NS_DURING
  {
    [_sERVERNS2User initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2User = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2User autorelease];
  return _sERVERNS2User;
}

/**
 * Initialize this instance of SERVERNS2User according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2User to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2User (JAXB) */

#endif /* DEF_SERVERNS2User_M */
#ifndef DEF_SERVERNS2Task_M
#define DEF_SERVERNS2Task_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2Task

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2Task */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2Task (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2Task (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2Task (JAXB)

/**
 * Read an instance of SERVERNS2Task from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2Task defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2Task *_sERVERNS2Task = [[SERVERNS2Task alloc] init];
  NS_DURING
  {
    [_sERVERNS2Task initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2Task = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2Task autorelease];
  return _sERVERNS2Task;
}

/**
 * Initialize this instance of SERVERNS2Task according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2Task to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2Task (JAXB) */

#endif /* DEF_SERVERNS2Task_M */
#ifndef DEF_SERVERNS2Project_M
#define DEF_SERVERNS2Project_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2Project

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2Project */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2Project (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2Project (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2Project (JAXB)

/**
 * Read an instance of SERVERNS2Project from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2Project defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2Project *_sERVERNS2Project = [[SERVERNS2Project alloc] init];
  NS_DURING
  {
    [_sERVERNS2Project initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2Project = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2Project autorelease];
  return _sERVERNS2Project;
}

/**
 * Initialize this instance of SERVERNS2Project according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2Project to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2Project (JAXB) */

#endif /* DEF_SERVERNS2Project_M */
#ifndef DEF_SERVERNS2UserDTO_M
#define DEF_SERVERNS2UserDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2UserDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2UserDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2UserDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2UserDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2UserDTO (JAXB)

/**
 * Read an instance of SERVERNS2UserDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2UserDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2UserDTO *_sERVERNS2UserDTO = [[SERVERNS2UserDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2UserDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2UserDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2UserDTO autorelease];
  return _sERVERNS2UserDTO;
}

/**
 * Initialize this instance of SERVERNS2UserDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2UserDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2UserDTO (JAXB) */

#endif /* DEF_SERVERNS2UserDTO_M */
#ifndef DEF_SERVERNS2BaseEntityDTO_M
#define DEF_SERVERNS2BaseEntityDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2BaseEntityDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2BaseEntityDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2BaseEntityDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2BaseEntityDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2BaseEntityDTO (JAXB)

/**
 * Read an instance of SERVERNS2BaseEntityDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2BaseEntityDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2BaseEntityDTO *_sERVERNS2BaseEntityDTO = [[SERVERNS2BaseEntityDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2BaseEntityDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2BaseEntityDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2BaseEntityDTO autorelease];
  return _sERVERNS2BaseEntityDTO;
}

/**
 * Initialize this instance of SERVERNS2BaseEntityDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2BaseEntityDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2BaseEntityDTO (JAXB) */

#endif /* DEF_SERVERNS2BaseEntityDTO_M */
#ifndef DEF_SERVERNS2TaskDTO_M
#define DEF_SERVERNS2TaskDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2TaskDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2TaskDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2TaskDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2TaskDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2TaskDTO (JAXB)

/**
 * Read an instance of SERVERNS2TaskDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2TaskDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2TaskDTO *_sERVERNS2TaskDTO = [[SERVERNS2TaskDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2TaskDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2TaskDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2TaskDTO autorelease];
  return _sERVERNS2TaskDTO;
}

/**
 * Initialize this instance of SERVERNS2TaskDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2TaskDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2TaskDTO (JAXB) */

#endif /* DEF_SERVERNS2TaskDTO_M */
#ifndef DEF_SERVERNS2ProjectDTO_M
#define DEF_SERVERNS2ProjectDTO_M

/**
 *  @author Roman Kravchenko
 */
@implementation SERVERNS2ProjectDTO

- (void) dealloc
{
  [super dealloc];
}
@end /* implementation SERVERNS2ProjectDTO */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface SERVERNS2ProjectDTO (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface SERVERNS2ProjectDTO (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation SERVERNS2ProjectDTO (JAXB)

/**
 * Read an instance of SERVERNS2ProjectDTO from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of SERVERNS2ProjectDTO defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  SERVERNS2ProjectDTO *_sERVERNS2ProjectDTO = [[SERVERNS2ProjectDTO alloc] init];
  NS_DURING
  {
    [_sERVERNS2ProjectDTO initWithReader: reader];
  }
  NS_HANDLER
  {
    _sERVERNS2ProjectDTO = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sERVERNS2ProjectDTO autorelease];
  return _sERVERNS2ProjectDTO;
}

/**
 * Initialize this instance of SERVERNS2ProjectDTO according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of SERVERNS2ProjectDTO to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation SERVERNS2ProjectDTO (JAXB) */

#endif /* DEF_SERVERNS2ProjectDTO_M */
