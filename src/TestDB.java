import java.sql.*;
import java.util.Scanner;

public class TestDB {
    static final String URL = "jdbc:mysql://127.0.1.16:3306/test_db";
    static final String USER = "root";
    static final String PASSWORD = "";
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Загрузка драйвера (актуально для старых версий Java)
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение установлено!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            System.out.println("Введите Email: ");
            String email = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String pass = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, lastname, email, pass) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, pass);

            preparedStatement.executeUpdate();
            System.out.println("Добавлен новый пользователь");
            //statement = connection.createStatement();

            //statement.execute("INSERT INTO users (name, lastname, email, pass) VALUES ('Коля', 'Николаев', 'nikola@mail.ru', '123')");

            /*resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                System.out.printf("==============================" +
                        "\nID: %d, Имя: %s, Фамилия: %s, Email: %s\n", id, name, lastname, email);
            }*/

            //statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}