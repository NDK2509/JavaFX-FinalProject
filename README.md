# JavaFX connect DB

1. Add library mysql-connector in build.gradle
```.gradle
    dependencies {
        implementation("mysql:mysql-connector-java:8.0.29")
    }
```
2. In module-info.java, add required 
```
    module your_projectname {
        requires java.sql;
    }
```
3. Create a DBConnect class, declare constants
```java
    //example 
    public class DBConnect {
        private static final String URL = "jdbc:mysql://localhost/ndkshop"; //jdbc:mysql is required 
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";
    }
```
4. Connect MySQL with java.sql
```java
    import java.sql.*;

    public class DBConnect {
        private static final String URL = "jdbc:mysql://localhost/ndkshop"; //jdbc:mysql is required 
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";
        
        public DBConnect() {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connect successfully!!!");
            } catch (SQLException e) {
                connection = null;
                System.out.println(e);
            }
        }
    }
```