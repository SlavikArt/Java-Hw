package com.itstep;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LaptopManufacturerServlet extends HttpServlet {
    private final Map<String, String> laptops = new HashMap<>();
    private final Map<String, String> news = new HashMap<>();

    @Override
    public void init() throws ServletException {
        laptops.put("model1", "MacBook Pro 16\" - Powerful laptop for professionals");
        laptops.put("model2", "MacBook Air - Lightweight and efficient");
        laptops.put("model3", "MacBook Pro 14\" - Perfect balance of power and portability");
        
        news.put("news1", "Apple announces new M3 chip");
        news.put("news2", "Record sales in Q4 2023");
        news.put("news3", "New manufacturing facility in India");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Apple Inc.</title>");
        out.println("<style>");
        out.println("nav { background: #333; padding: 10px; }");
        out.println("nav a { color: white; margin: 0 10px; text-decoration: none; }");
        out.println(".content { padding: 20px; }");
        out.println(".laptop-grid { display: grid; grid-template-columns: repeat(3, 1fr); gap: 20px; }");
        out.println(".news-grid { display: grid; grid-template-columns: repeat(2, 1fr); gap: 20px; }");
        out.println("</style></head>");
        out.println("<body>");
        out.println("<nav>");
        out.println("<a href='laptop/'>General Info</a>");
        out.println("<a href='laptop/history'>History</a>");
        out.println("<a href='laptop/news'>News</a>");
        out.println("<a href='laptop/models'>Models</a>");
        out.println("</nav>");
        out.println("<div class='content'>");

        if (path == null || path.equals("/")) {
            showGeneralInfo(out);
        } else if (path.equals("/history")) {
            showHistory(out);
        } else if (path.equals("/news")) {
            showNews(out);
        } else if (path.equals("/models")) {
            showModels(out);
        } else if (path.startsWith("/model/")) {
            String model = path.substring(7);
            showModelDetails(out, model);
        }

        out.println("</div></body></html>");
    }

    private void showGeneralInfo(PrintWriter out) {
        out.println("<h1>Apple Inc.</h1>");
        out.println("<img src='apple-logo.png' alt='Apple Logo' style='width:200px;'>");
        out.println("<p>Headquarters: Cupertino, California, USA</p>");
        out.println("<p>Employees: 164,000+</p>");
        out.println("<p>Apple Inc. is an American multinational technology company that designs, develops, and sells consumer electronics, computer software, and online services.</p>");
    }

    private void showHistory(PrintWriter out) {
        out.println("<h1>History</h1>");
        out.println("<p>Founded in 1976 by Steve Jobs, Steve Wozniak, and Ronald Wayne, Apple has grown to become one of the world's most valuable companies.</p>");
        out.println("<img src='history1.jpg' alt='Early Apple' style='width:300px;'>");
        out.println("<p>Learn more at <a href='https://www.apple.com/history/'>Apple's History Page</a></p>");
    }

    private void showNews(PrintWriter out) {
        out.println("<h1>Latest News</h1>");
        out.println("<div class='news-grid'>");
        for (Map.Entry<String, String> entry : news.entrySet()) {
            out.println("<div>");
            out.println("<img src='" + entry.getKey() + ".jpg' alt='News Image' style='width:100%;'>");
            out.println("<p>" + entry.getValue() + "</p>");
            out.println("</div>");
        }
        out.println("</div>");
    }

    private void showModels(PrintWriter out) {
        out.println("<h1>Laptop Models</h1>");
        out.println("<div class='laptop-grid'>");
        for (Map.Entry<String, String> entry : laptops.entrySet()) {
            out.println("<div>");
            out.println("<img src='" + entry.getKey() + ".jpg' alt='Laptop' style='width:100%;'>");
            out.println("<p>" + entry.getValue() + "</p>");
            out.println("<a href='laptop/model/" + entry.getKey() + "'>Learn More</a>");
            out.println("</div>");
        }
        out.println("</div>");
    }

    private void showModelDetails(PrintWriter out, String model) {
        String description = laptops.get(model);
        if (description != null) {
            out.println("<h1>" + model + "</h1>");
            out.println("<img src='" + model + "-detail.jpg' alt='Laptop Detail' style='width:100%;'>");
            out.println("<p>" + description + "</p>");
            out.println("<h2>Specifications:</h2>");
            out.println("<ul>");
            out.println("<li>Processor: M3 Pro/Max</li>");
            out.println("<li>Memory: Up to 96GB</li>");
            out.println("<li>Storage: Up to 8TB</li>");
            out.println("<li>Display: Liquid Retina XDR</li>");
            out.println("</ul>");
            out.println("<a href='laptop/models'>Back to Models</a>");
        } else {
            out.println("<h1>Model not found</h1>");
            out.println("<a href='laptop/models'>Back to Models</a>");
        }
    }
} 