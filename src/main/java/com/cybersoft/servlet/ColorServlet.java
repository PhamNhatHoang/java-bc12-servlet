package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String color = request.getParameter("color");
        PrintWriter out = response.getWriter();
        
        // Set màu default là white nếu user không chọn color
        String bgColor = "white";
        if (color != null && !color.trim().isEmpty()) {
            bgColor = color;
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Màu nền trang</title>");
        out.println("</head>");
        out.println("<body style='background-color: " + bgColor + ";'>");
        out.println("    <h2>Bài 4: Chọn màu nền trang (GET)</h2>");
        out.println("    <p>Màu nền trang web hiện tại là: <strong>" + bgColor + "</strong></p>");
        out.println("    <br>");
        out.println("    <a href='color.html'>Quay lại chọn màu</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
