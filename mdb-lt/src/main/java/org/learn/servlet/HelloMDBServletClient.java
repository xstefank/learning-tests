package org.learn.servlet;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@JMSDestinationDefinitions(
        value = {
                @JMSDestinationDefinition(
                        name = "java:/queue/HELLOMDBQueue",
                        interfaceName = "javax.jms.Queue",
                        destinationName = "HelloMDB"
                )
        }
)

@WebServlet("/HelloMDB")
public class HelloMDBServletClient extends HttpServlet {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/queue/HELLOMDBQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h1>HelloMDB servlet client</h1>");

        try {
            out.write("<p>Sending message to <em>" + queue + "</em></p>");
            out.write("<h2>Sending messages:</h2>");
            for (int i = 0; i < 5; i++) {
                String s = "Testing Message " + (i + 1);
                context.createProducer().send(queue, s);
                out.write("Message " + (i + 1) + " - " + s + "</br>");
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
