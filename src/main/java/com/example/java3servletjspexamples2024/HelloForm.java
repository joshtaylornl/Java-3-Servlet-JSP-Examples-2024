package com.example.Java_3_Servlets_JSP_Examples;

// Import required java libraries
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// Extend HttpServlet class
@WebServlet(name = "helloForm", value = "/hello-form")
public class HelloForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET/PUT Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>"
        );
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

        //Just pass it up to the doGet method - it will be handled the same way in this simple example
        doGet(req,resp);

    }
}