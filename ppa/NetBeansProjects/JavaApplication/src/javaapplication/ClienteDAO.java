package javaapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        try {
            String url = "jdbc:mysql://db4free.net:3306/trab_pooj";
            String username = "paulo10";
            String password = "Pa80731501";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarCliente(String nome, String email) {
        try {
            String query = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrarCliente("João", "joao@example.com");
    }
}
