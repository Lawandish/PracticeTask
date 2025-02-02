package com.example.proj;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//Сайт для аптеки.
// логин для аптекаря - admin/pass
// логин для пользователя - user/user_pass
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        ConnectionStatus cs1 = LoginDao.validateAdmin(n, p);
        ConnectionStatus cs2 = LoginDao.validateUser(n, p);

        if (cs1 == ConnectionStatus.WRONG_PASSWORD || cs2 == ConnectionStatus.WRONG_PASSWORD){
            RequestDispatcher rd = request.getRequestDispatcher("wrong-login-servlet");
            rd.forward(request, response);
        } else if (cs1 == ConnectionStatus.OK) {
            RequestDispatcher rd = request.getRequestDispatcher("admin-servlet");
            rd.forward(request, response);
        } else if (cs2 == ConnectionStatus.OK) {
            RequestDispatcher rd = request.getRequestDispatcher("welcome-servlet");
            rd.forward(request, response);
        } else {
            out.print("No such login exists");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

        out.close();
    }

    public void destroy() {
    }
}