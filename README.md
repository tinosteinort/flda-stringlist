FLDA - String List
==========================

Using [FLDA](https://github.com/tinosteinort/flda-core) for records of type `List<String>` with a fix amount of
 elements.

### Example for Character-separated attributes
Character-separated data consists of attributes that are separated by a character. In this example, the attributes
 are semicolon-separated: 
```
Fruit;Cherry;30
Fruit;Apple;5
Vegetable;Potato;23
```
The task of FLDA-StringList is _not_ to split a String or row into a `List<String>`, it operates on records of this type.  

See [StringListInterfaceTest](src/test/java/com/github/tinosteinort/flda/stringlist/fullexample/StringListInterfaceTest.java)
 for a full working example with:
* Validator
* RecordFactory
* Reading / writing of types: String, Integer, Enum

## Maven

To use `FLDA - StringList`, include the following artifacts:
*TODO*: not available on Maven Central at the moment.
```xml
<dependency>
    <groupId>com.github.tinosteinort</groupId>
    <artifactId>flda-core</artifactId>
    <version>2.0.0</version>
</dependency>
<dependency>
    <groupId>com.github.tinosteinort</groupId>
    <artifactId>flda-stringlist</artifactId>
    <version>1.0.0</version>
</dependency>
```