package ca.nl.cna.java3.project;

import ca.nl.cna.java3.a2.Book;
import ca.nl.cna.java3.a2.SimpleDBManager;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.json.Json;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LibraryApiServlet", value = "/LibraryApiServlet")
public class LibraryApiServlet extends HttpServlet {

    private String message;
    public void init() {
        message = "Library Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //TODO Use a variable "view" to determine book or author query
        String scope = request.getParameter("scope");
        String action = request.getParameter("action");


        if(scope.equals("books")){
            if(action.equals("list")){
                //TODO list books
            } else if(action.equals("add")){
                //TODO add books
            }
        } else if(scope.equals("authors")){
            if(action.equals("list")){
                listAuthors(response);
            } else if(action.equals("delete")){
                deleteAuthor(request, response);
            }
        } else {
            //Do nothing
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action.equals("add_author")){
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");

            Unirest.setTimeouts(0, 0);
            try {
                //TODO You can copy your code from postman here
                //Took this code from Postman
                HttpResponse<String> resp =
                        Unirest.post("http://localhost:8080/api/v1/authors?firstName=" + first_name +
                                        "&lastName=" + last_name)
                        .body("")
                        .asString();
                //End Postman code import
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }

        } else if(action.equals("add_author")){

            //TODO insert Author
        } else {

            //Something went wrong? Do nothing?
        }

    }

    private void listAuthors(HttpServletResponse response) throws IOException {
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> resp = Unirest.get("http://localhost:8080/api/v1/authors")
                    .asJson();

            JsonNode body = resp.getBody();
            PrintWriter out = response.getWriter();

            out.println("<html><head>\n" +
                    "<style>\n" +
                    "table, th, td {\n" +
                    "  border: 1px solid white;\n" +
                    "  border-collapse: collapse;\n" +
                    "}\n" +
                    "th, td {\n" +
                    "  background-color: #96D4D4;\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>" +
                    "<body>");
            out.println("<h1> authors<br/></h1>");
            out.println("");

            out.println("<table><tr><th>Author ID</th><th>First Name</th><th>Last Name</th><th>Actions</th></tr>");
            for (int i = 0; i < body.getArray().length(); i++) {
                out.println("<tr>");
                out.println("<td>" + body.getArray().getJSONObject(i).get("id") + "</td>");
                out.println("<td>" + body.getArray().getJSONObject(i).get("firstName") + "</td>");
                out.println("<td>" + body.getArray().getJSONObject(i).get("lastName") + "</td>");
                out.println("<td><a href=\"LibraryApiServlet?scope=authors&action=delete&id=" + body.getArray().getJSONObject(i).get("id")+ "\">Delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>" +
                    "</body></html>");

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> resp = Unirest.delete("http://localhost:8080/api/v1/authors/" + id)
                    .asString();
            listAuthors(response);
//            PrintWriter out = response.getWriter();
//            out.println("<html><head>\n" +
//                    "<style>\n" +
//                    "table, th, td {\n" +
//                    "  border: 1px solid white;\n" +
//                    "  border-collapse: collapse;\n" +
//                    "}\n" +
//                    "th, td {\n" +
//                    "  background-color: #96D4D4;\n" +
//                    "}\n" +
//                    "</style>\n" +
//                    "</head>" +
//                    "<body>");
//            out.println("<h1> authors<br/></h1>");
//            out.println("<p>Author deleted</p>");
//            out.println("<br/><a href=\"index.jsp\">Back to Main Menu</a>");
//            out.println("</body></html>");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
