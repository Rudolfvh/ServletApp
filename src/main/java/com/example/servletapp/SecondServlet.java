package com.example.servletapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(var writer = resp.getWriter()){
            writer.println("<h3>SSSSDDSSSSSSssss</h3>");
            writer.println("<br/><a href=\"first\">First Servlet</a>");
            writer.println("<br/><a href=\"Smth.html\">Go to Login</a>");
            writer.println("<br/><a href=\"Smth.html\">Go to Login</a>");
            writer.println("<br/><a href=\"Smth.html\">Go to Login</a>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("Kyrs: <inpit type=\"text\" name=\"course\">");

        writer.close();

        resp.sendRedirect("Smth.xml");
    }
}
