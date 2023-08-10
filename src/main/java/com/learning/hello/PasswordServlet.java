package com.learning.hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private List<String> bannedPasswords;

    @Override
    public void init() throws ServletException {
        super.init();

        // Load the list of banned passwords from a text file
        bannedPasswords = new ArrayList<>();
        String filePath = "/home/srimasarajita/eclipse-workspace/learning-web/src/main/java/com/learning/hello/banned_passwords.txt"; // Update with the actual path
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                bannedPasswords.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");

        if (isBannedPassword(password)) {
            response.getWriter().write("Password validation failed due to banned password.");
        } else {
            response.getWriter().write("Password validated successfully!");
        }
    }

    private boolean isBannedPassword(String password) {
        return bannedPasswords.contains(password);
    }
}
