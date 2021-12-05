package server;

import java.sql.*;

class JdbcApp {
    private static Connection connection;
    private static String a;
    private static String b;

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:clients.db");
    }

    static String authLogin(String login) throws SQLException {
        String result = null;
        try (final PreparedStatement ps = connection.prepareStatement("select id from Auth where login = ?;")) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
            rs.close();
        }
        return result;
    }

    static String authPass(String pass) throws SQLException {
        String result = null;
        try (final PreparedStatement ps = connection.prepareStatement("select id from Auth where password = ?;")) {
            ps.setString(1, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
            rs.close();
        }
        return result;
    }

    static String nick(String log) throws SQLException {
        String result = null;
            try (final PreparedStatement ps = connection.prepareStatement("select nick from Auth where id = ?;")) {
                ps.setString(1, log);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    result = rs.getString(1);
                }
                rs.close();
            }
            return result;
        }


        public static void disconnect () {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


