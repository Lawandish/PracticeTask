package com.example.proj;

import java.sql.*;

public class LoginDao {

    // логин для аптекаря - admin/pass
// логин для пользователя - user/user_pass
    public static ConnectionStatus validateAdmin(String name, String pass) {
        if (name.equals("admin") && pass.equals("pass"))
            return ConnectionStatus.OK;

        if (name.equals("admin"))
            return ConnectionStatus.WRONG_PASSWORD;
        else return ConnectionStatus.NO;
    }

    public static ConnectionStatus validateUser(String name, String pass) {
        if (name.equals("user") && pass.equals("user_pass"))
            return ConnectionStatus.OK;

        if (name.equals("user"))
            return ConnectionStatus.WRONG_PASSWORD;
        else return ConnectionStatus.NO;
    }
}

