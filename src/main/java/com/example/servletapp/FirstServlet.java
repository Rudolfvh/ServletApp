package com.example.servletapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    private String msg;

    @Override
    public void init() throws ServletException {
        msg = "hi Serv";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("MYHEADER", "Hi");

        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");
        String[] age = req.getParameterValues("age");

        try(PrintWriter writer = resp.getWriter()) {
            writer.println("<h1>" + param1 + "</h1>");
            writer.println("<h1>" + param2 + "</h1>");
            writer.println("<h1>" + Arrays.toString(age) + "</h1>");
            writer.println("<h1>" + age[1] + "</h1>");
            writer.println("<br/><a href=\"second\">SecondServlet</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>" + req.getParameter("name") + "</h2>");
        writer.println("<h2>" + req.getParameter("pwd") + "</h2>");

        writer.println("<form action=\"second\" method=\"POST\">");
        writer.println("Курс: <input type=\"text\" name=\"course\">");
        writer.println("<input type=\"submit\" value=\"отправить\">");
        writer.println("</form>");
        writer.close();

    }
}

