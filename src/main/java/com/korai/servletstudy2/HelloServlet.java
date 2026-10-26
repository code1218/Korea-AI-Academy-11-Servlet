package com.korai.servletstudy2;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String[] names = {"김준일", "김준이"};

        // Hello
        PrintWriter out = response.getWriter();
        out.println(String.format("""
                <html>
                    <head>
                        <title>탭제목</title>
                    </head>
                    <body>
                        <h1>%s</h1>
                        <h1>%s</h1>
                    </body>
                </html>""", names[0], names[1]));
    }

    public void destroy() {
    }
}