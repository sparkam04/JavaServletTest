package com.sparkam.WebProjectTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class XmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String request1 = request.getParameter("request1");
        request1 = request1.equals("") ? "empty" : request1;
        String request2 = request.getParameter("request2");
        request2 = request2.equals("") ? "empty" : request2;

        writer.println("<h1>Hello from xml post </h1><br>");
        writer.println("request1: " + request1 + "<br>");
        writer.println("request2: " + request2 + "<br>");

        String rad = request.getParameter("rad");
        writer.println("radio input: " + rad + "<br>");
        String[] options = request.getParameterValues("options");

        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        if (options != null) {
            servletContext.setAttribute("savedContext", options[0]);

            writer.println("options selected: " + options.length + "<br>");
            for (String option : options) {
                writer.println(option + "<br>");
            }
        } else {
            writer.println("no options selected. <br>");
        }

        if (rad != null) {
            session.setAttribute("savedSession", rad);
        }

        writer.println("Session is: " + session.getAttribute("savedSession")+ "<br>");
        writer.println("Context is (first option): " + servletContext.getAttribute("savedContext") + "<br>");
        writer.println("Servlet Config parameter is: " + getServletConfig().getInitParameter("defaultParamName") + "<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Hello from xml get</h1>");
    }
}
