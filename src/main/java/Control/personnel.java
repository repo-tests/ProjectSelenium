/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dao.EtatManager;

/**
 * Servlet implementation class personnel
 */
@WebServlet("/personnel")
public class personnel extends HttpServlet {

    private static final long serialVersionUID = 1L;
    EtatManager mg;

    public personnel() {
        super();
        mg = new EtatManager();
    }

    /**
     * @param request
     * @param response
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listepersonnel", mg.getAllPersonnel());
        request.getRequestDispatcher("affecter.jsp").forward(request,
                response);

    }

    /**
     * @param request
     * @param response
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom_tache");
        String datedebut = request.getParameter("ddebut");
        String datefin = request.getParameter("dfin");
        int id = Integer.parseInt(request.getParameter("personnel"));
        mg.addTache(nom, datedebut, datefin, id);
        response.sendRedirect("manager.jsp");
    }

}
