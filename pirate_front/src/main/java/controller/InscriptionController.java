package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class InscriptionController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Page d'inscription
		if(request.getParameter("inscription") != null) 
		{
			// Affichage de la page JSP inscription
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireInscription.jsp").forward(request, response);
		}
		
		// Sinon, on affiche l'accueil
		else 
		{
			// Affichage de la page JSP connexion
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ici, on récupère les données d'un formulaire HTML
	}
}