package com.cybersoft.service;

public class LoginService {
    
    // Check credentials giả lập có khớp admin/123 hay không
    public boolean checkLogin(String username, String password) {
        return "admin".equals(username) && "123".equals(password);
    }
}
