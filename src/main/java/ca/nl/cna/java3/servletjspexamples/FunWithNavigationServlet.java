package ca.nl.cna.java3.servletjspexamples;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class shows the use of RequestDispatcher to forward the request to another servlet
 */
@WebServlet(name = "funWithNavigationServlet", value = "/fun-with-navigation-servlet")
public class FunWithNavigationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String name=request.getParameter("user_name");
        String pass=request.getParameter("user_password");
        if(name.equals("Chaitanya") &&
                pass.equals("beginnersbook"))
        {
            RequestDispatcher dis=request.getRequestDispatcher("welcome-servlet");
            dis.forward(request, response);
        }
        else
        {
            pwriter.print("User name or password is incorrect!");
            RequestDispatcher dis=request.getRequestDispatcher("index.html");
            dis.include(request, response);
        }

    }
}
