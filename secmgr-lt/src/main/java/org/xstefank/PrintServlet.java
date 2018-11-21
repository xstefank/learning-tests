package org.xstefank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/*")
public class PrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = new PrintWriter("/home/mstefank/workspace/file.txt", "UTF-8");
//        writer.println("The first line");
//        writer.println("The second line");
//        writer.close();

        resp.getWriter().println(System.getProperty("java.home"));
        
        resp.getWriter().write("Successfully written file");
    }
}
