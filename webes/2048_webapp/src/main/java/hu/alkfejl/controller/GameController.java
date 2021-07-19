package hu.alkfejl.controller;

import hu.alkfejl.model.GameDAO;
import hu.alkfejl.model.GameDAODBImpl;
import hu.alkfejl.model.bean.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
    private GameDAO dao = new GameDAODBImpl();

    int atvalt(int num){
        switch (num){
            case 4:
                return 2;
            case 8:
                return 3;
            case 16:

                return 4;
            case 32:
                return 5;
            case 64:
                return 6;
            case 128:
                return 7;
            case 256:
                return 8;
            case 512:
                return 9;
            case 1024:
                return 10;
            case 2048:
                return 11;
            default:
                return 1;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Game p = new Game();




        String message=request.getParameter("input");
        String message2=request.getParameter("input2");
        int a= Integer.parseInt(message2);
        a-=8;
        String b =String.valueOf(a);


        try {
            p.setTime(b+" s");
            p.setLevel(atvalt(Integer.parseInt(message)));

            if(dao.addGame(p)) {

                response.sendRedirect("pages/list_game.jsp");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("gameList", dao.listGame());
    }





}
