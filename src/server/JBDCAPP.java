package server;

import java.sql.*;

    class JdbcApp {
        private static Connection connection;
        private static String a;
        private static String b;

        public static void connect() throws SQLException {
            connection = DriverManager.getConnection("jdbc:sqlite:clients.db");
        }

        static String authLogin (String login) throws SQLException {
            try (final PreparedStatement ps = connection.prepareStatement("select id from Auth where login = '" + login + "'")) {
                a = ps.toString();
                return a;
            }
        }

        static String authPass (String pass) throws SQLException {
            try (final PreparedStatement ps = connection.prepareStatement("select id from Auth where password = '" + pass + "'")) {
                b = ps.toString();
                return b;
            }
        }

        static String nick (String log) throws SQLException {
            if (a.equals(b)) {
                try (final PreparedStatement ps = connection.prepareStatement("select nick from Auth where id = '" + Integer.parseInt(a) + "'")) {
                  return ps.toString();
                }
            }
            return null;
        }

        public static void disconnect() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


