package server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SimpleAuthService implements AuthService {



    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        try {
            JdbcApp.connect();
            return JdbcApp.nick(login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcApp.disconnect();
        }
        return null;
    }




}
