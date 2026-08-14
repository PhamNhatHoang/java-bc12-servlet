package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String paramA = request.getParameter("a");
        String paramB = request.getParameter("b");
        String op = request.getParameter("op");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Kết quả máy tính</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h2>Kết quả phép tính</h2>");
        
        try {
            // Check user nhập đủ số A và B hay chưa
            if (paramA == null || paramB == null || paramA.trim().isEmpty() || paramB.trim().isEmpty()) {
                out.println("    <p style='color:red;'>Vui lòng nhập đầy đủ hai số A và B!</p>");
            } else {
                // Parse kiểu dữ liệu từ String sang double
                double a = Double.parseDouble(paramA);
                double b = Double.parseDouble(paramB);
                double result = 0;
                boolean valid = true;
                
                // Xử lý logic phép toán cộng trừ
                if ("+".equals(op)) {
                    result = a + b;
                } else if ("-".equals(op)) {
                    result = a - b;
                } else {
                    valid = false;
                }
                
                if (valid) {
                    // Format số nguyên hiển thị cho gọn
                    String formattedResult = (result % 1 == 0) ? String.valueOf((long)result) : String.valueOf(result);
                    String formattedA = (a % 1 == 0) ? String.valueOf((long)a) : String.valueOf(a);
                    String formattedB = (b % 1 == 0) ? String.valueOf((long)b) : String.valueOf(b);
                    
                    out.println("    <p>Số A: " + formattedA + "</p>");
                    out.println("    <p>Số B: " + formattedB + "</p>");
                    out.println("    <p>Phép tính: " + op + "</p>");
                    out.println("    <p>Kết quả: <strong>" + formattedResult + "</strong></p>");
                } else {
                    out.println("    <p style='color:red;'>Phép toán không hợp lệ!</p>");
                }
            }
        } catch (NumberFormatException e) {
            // Catch lỗi nếu input không phải là số hợp lệ
            out.println("    <p style='color:red;'>Lỗi định dạng số! Vui lòng nhập số hợp lệ.</p>");
        }
        
        out.println("    <br>");
        out.println("    <a href='calculator.html'>Quay lại trang tính</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
