package com.goit;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    /**
     * Use this url for connection to separate H2 instance.
     * Use username and password.
     */
    private static final String URL = "jdbc:h2:~/test";
    /**
     * Use this url with 'mem:local' for connection to H2 without separate instance.
     * In this case we don't need username and password.
     */
    private static final String URL_IN_MEMORY = "jdbc:h2:mem:local";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "12345";
    private static final String DB_STRUCTURE_LOCATION = "db/db-structure.sql";


    public static void main(String[] args) {
        try (H2Repository repository = new H2Repository(URL_IN_MEMORY);
             InputStream resource = Main.class.getClassLoader().getResourceAsStream(DB_STRUCTURE_LOCATION)) {
            Scanner scanner = new Scanner(resource);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
            repository.execute(builder.toString());
            repository.execute("INSERT INTO user_account(id,username,age) VALUES(1,'test_user',20);");
            ResultSet resultSet = repository.executeQuery("SELECT * FROM user_account");
            resultSet.first();
            Integer id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            Integer age = resultSet.getInt("age");
            System.out.println("id: " + id + " username: " + username + " age: " + age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
