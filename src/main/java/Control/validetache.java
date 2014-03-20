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
import javax.servlet.http.HttpSession;

import Model.dao.EtatManager;
import Model.entities.Personnel;

/**
 * Servlet implementation class validetache
 */
@WebServlet("/validetache")
public class validetache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EtatManager mg;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validetache() {
        super();
       mg=new EtatManager();
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		Personnel p=(Personnel)s.getAttribute("personnel");
		request.setAttribute("tacheencours", mg.getTacheByetatPersonnel("en cours de traitement", p.getId_pers()));
		request.getRequestDispatcher("validetache.jsp").forward(request, response);
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		Personnel p=(Personnel)s.getAttribute("personnel");
		int id=Integer.parseInt(request.getParameter("tache"));
		mg.updateEtatTache(id, "achve");
		request.setAttribute("tacheencours", mg.getTacheByetatPersonnel("en cours de traitement", p.getId_pers()));
		request.getRequestDispatcher("validetache.jsp").forward(request, response);
	}

}
