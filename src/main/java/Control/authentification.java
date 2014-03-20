/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.dao.EtatManager;

import Model.entities.Personnel;

/**
 * Servlet implementation class authentification
 */
@WebServlet("/authentification")
public class authentification extends HttpServlet {

    private static final long serialVersionUID = 1L;
    EtatManager mg;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentification() {
        super();
        mg = new EtatManager();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }  
 
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        Personnel pr = new Personnel("Ghaouta", "samir", "15/10/1991", "manager");
        mg.addPersonnel(pr); 
        List<Personnel> p = new ArrayList<Personnel>();
        p = mg.getlogin(login, password);

        if (!p.isEmpty()) {
            HttpSession s = request.getSession(true);
            Personnel p1 = p.get(0);
            s.setAttribute("personnel", p1);
            response.sendRedirect(p1.getRole() + ".jsp");
        } else {
            request.setAttribute("erreur", 1);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }

}
