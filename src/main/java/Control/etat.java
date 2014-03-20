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
 * Servlet implementation class etat
 */
@WebServlet("/etat")
public class etat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   EtatManager mg;
    public etat() {
        super();
        mg=new EtatManager();
    }

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String etat=request.getParameter("e");
		
		request.setAttribute(""+etat, mg.getTacheByetat(etat));
		request.getRequestDispatcher("etat.jsp?e="+etat).forward(request, response);
	}

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
