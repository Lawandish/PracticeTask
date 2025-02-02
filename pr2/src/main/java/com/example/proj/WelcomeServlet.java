package com.example.proj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "welcomeServlet", value = "/welcome-servlet")
public class WelcomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html> \n" +
                "  <html>\n");

        out.print("<hr>Welcome back, user! Which medicine would you like to buy?</hr>");

        out.println(Pictures.buttonName("Buy"));

        out.print( "</html>\n");

        out.close();
    }

}
