package hu.alkfejl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EightFieldController")
public class EightFieldController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EightFieldController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");


        response.sendRedirect("pages/field8x8.jsp");
    }

}
