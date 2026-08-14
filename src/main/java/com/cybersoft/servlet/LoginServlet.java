package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.cybersoft.service.LoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Khởi tạo LoginService để xử lý logic
    private LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Kết quả đăng nhập</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h2>Kết quả đăng nhập</h2>");
        
        // Gọi LoginService để check login logic
        boolean isSuccess = loginService.checkLogin(username, password);
        
        if (isSuccess) {
            out.println("    <h3 style='color:green;'>Đăng nhập thành công!</h3>");
            out.println("    <p>Chào mừng tài khoản: <strong>" + username + "</strong></p>");
        } else {
            out.println("    <h3 style='color:red;'>Đăng nhập thất bại!</h3>");
            out.println("    <p>Tên đăng nhập hoặc mật khẩu không chính xác.</p>");
        }
        
        out.println("    <br>");
        out.println("    <a href='login.html'>Quay lại trang đăng nhập</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
