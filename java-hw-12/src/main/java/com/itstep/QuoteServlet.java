package com.itstep;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Martin Fowler Quote</title></head>");
        out.println("<body>");
        out.println("<h1>Martin Fowler Quote</h1>");
        out.println("<p>Any fool can write code that a computer can understand. Good programmers write code that humans can understand</p>");
        out.println("</body></html>");
    }
} 