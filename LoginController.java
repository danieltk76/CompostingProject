import javax.servlet;
import javax.servlet.http.HttpServlet;
import javax.sql.rowset.serial.SerialException;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;

import java.servlet.http.*;
import java.io.IOException;


public class LoginController extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServlet response) throws SerialException, IOException
    {
        String username = request.getParamester("username");
        String password = request.getParameter("password");

        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated)
        {
            response.sendRedirect("example address for correct login page");

        }
        else
        {
            response.sendRedirect("failed login page");
        }


    }

    private boolean authenticate(String username, String password)
    {
        return "admin".equals(username) && "password".equals(password);
    }
}
