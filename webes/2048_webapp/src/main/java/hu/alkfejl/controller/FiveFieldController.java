package hu.alkfejl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FiveFieldController")
public class FiveFieldController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public FiveFieldController() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");


        response.sendRedirect("pages/field5x5.jsp");
    }





}
