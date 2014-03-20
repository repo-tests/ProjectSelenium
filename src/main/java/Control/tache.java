/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GHAOUTA
 */
import Model.dao.EtatManager;
import Model.entities.Personnel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class tache
 */
@WebServlet("/tache")
public class tache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   EtatManager mg;
    public tache() {
        super();
        mg=new EtatManager();
    }

	/**
         * @param request
     * @param response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
	Personnel p=(Personnel)s.getAttribute("personnel");
	request.setAttribute("tacheaffecte", mg.getTacheByetatPersonnel("affecte", p.getId_pers()));
	request.getRequestDispatcher("tache.jsp").forward(request, response);
	
	}

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		          HttpSession s=request.getSession();
		Personnel p=(Personnel)s.getAttribute("personnel");
		int id=Integer.parseInt(request.getParameter("tache"));
		mg.updateEtatTache(id, "en cours de traitement");
		request.setAttribute("tacheaffecte", mg.getTacheByetatPersonnel("affecte", p.getId_pers()));
		request.getRequestDispatcher("tache.jsp").forward(request, response);
	}

}
