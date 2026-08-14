package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String[] hobbies = request.getParameterValues("hobbies");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Kết quả khảo sát</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h2>Kết quả khảo sát sở thích</h2>");
        out.println("    <p>Họ tên: <strong>" + (username != null ? username : "") + "</strong></p>");

        // Check array sở thích có null hoặc empty hay không
        if (hobbies != null && hobbies.length > 0) {
            out.println("    <p>Danh sách sở thích của bạn:</p>");
            out.println("    <ul>");
            for (String hobby : hobbies) {
                out.println("        <li>" + hobby + "</li>");
            }
            out.println("    </ul>");
        } else {
            out.println("    <p style='color:red;'>Bạn không chọn sở thích nào!</p>");
        }

        out.println("    <br>");
        out.println("    <a href='survey.html'>Quay lại trang khảo sát</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
