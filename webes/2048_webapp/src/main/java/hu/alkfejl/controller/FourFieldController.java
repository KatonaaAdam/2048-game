package hu.alkfejl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FourFieldController")
public class FourFieldController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public FourFieldController() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");


        response.sendRedirect("pages/field4x4.jsp");
    }





}