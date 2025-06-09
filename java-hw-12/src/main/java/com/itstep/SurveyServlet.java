package com.itstep;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class SurveyServlet extends HttpServlet {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,13}$");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Survey</title></head>");
        out.println("<body>");
        out.println("<h1>Survey Form</h1>");
        out.println("<form method='post'>");
        out.println("Full Name: <input type='text' name='name' required><br>");
        out.println("Phone: <input type='tel' name='phone' required><br>");
        out.println("Email: <input type='email' name='email' required><br>");
        out.println("Age: <input type='number' name='age' required><br>");
        out.println("Gender:<br>");
        out.println("<input type='radio' name='gender' value='male' required> Male<br>");
        out.println("<input type='radio' name='gender' value='female'> Female<br>");
        out.println("<input type='radio' name='gender' value='other'> Other<br>");
        out.println("<input type='checkbox' name='newsletter'> Subscribe to newsletter<br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String newsletter = req.getParameter("newsletter");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Survey Results</title></head>");
        out.println("<body>");

        if (!isValid(name, phone, email, age)) {
            out.println("<h2>Error in form data:</h2>");
            if (name == null || name.trim().isEmpty())
                out.println("<p>Name is required</p>");
            if (!PHONE_PATTERN.matcher(phone).matches())
                out.println("<p>Invalid phone number</p>");
            if (!EMAIL_PATTERN.matcher(email).matches())
                out.println("<p>Invalid email address</p>");
            if (age == null || !age.matches("\\d+") || Integer.parseInt(age) < 0 || Integer.parseInt(age) > 150)
                out.println("<p>Invalid age</p>");
            out.println("<a href='survey'>Back to form</a>");
        } else {
            out.println("<h2>Submitted Information:</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Phone: " + phone + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Age: " + age + "</p>");
            out.println("<p>Gender: " + gender + "</p>");
            out.println("<p>Newsletter subscription: " + (newsletter != null ? "Yes" : "No") + "</p>");
        }
        out.println("</body></html>");
    }

    private boolean isValid(String name, String phone, String email, String age) {
        if (name == null || name.trim().isEmpty()) return false;
        if (!PHONE_PATTERN.matcher(phone).matches()) return false;
        if (!EMAIL_PATTERN.matcher(email).matches()) return false;
        if (age == null || !age.matches("\\d+")) return false;
        int ageNum = Integer.parseInt(age);
        return ageNum >= 0 && ageNum <= 150;
    }
} 