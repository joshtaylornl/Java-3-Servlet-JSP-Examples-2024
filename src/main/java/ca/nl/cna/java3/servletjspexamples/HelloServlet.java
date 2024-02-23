package ca.nl.cna.java3.servletjspexamples;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * A simple servlet that prints "Hello World!" to the web browser
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Setup the foo for later Session example
        HttpSession session = request.getSession();
        session.setAttribute(Foo.NAME, new Foo(0, "Hello Servlet Foo"));

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Josh Rules <br/>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}