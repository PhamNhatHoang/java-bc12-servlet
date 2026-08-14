package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Lời chào</title>");
        out.println("</head>");
        out.println("<body>");
        
        // Check parameter name có null hoặc empty hay không
        if (name == null || name.trim().isEmpty()) {
            out.println("    <h2>Xin chào bạn!</h2>");
        } else {
            out.println("    <h2>Xin chào " + name + "!</h2>");
        }
        
        out.println("    <br>");
        out.println("    <a href='hello.html'>Quay lại trang nhập</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
