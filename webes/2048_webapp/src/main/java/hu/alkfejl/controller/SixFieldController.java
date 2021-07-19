package hu.alkfejl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SixFieldController")
public class SixFieldController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public SixFieldController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");


        response.sendRedirect("pages/field6x6.jsp");
    }

}
