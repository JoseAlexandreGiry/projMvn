package com.objis.demomaven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    /**
     * Servlet implementation class FormationServlet
     */
    @WebServlet("/FormationServlet")
    public class FormationServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public FormationServlet() {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 1. Obtenir une connection database
            EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
            EntityManager em = emf.createEntityManager();

            try {
                // 2. Création d'une nouvelle formation ?:
                String theme = request.getParameter("themeFormation");
                if (theme != null) {
                    em.getTransaction().begin();
                    em.persist(new Formation(theme));
                    em.getTransaction().commit();
                }

                // 3. Afficher la liste des formations en Base:
                List<Formation> listeFormations = em.createQuery(
                        "SELECT f FROM Formation f", Formation.class).getResultList();
                request.setAttribute("listeDesFormations", listeFormations);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);

            } finally {
                // 4. fermer la connection
                if (em.getTransaction().isActive())
                    em.getTransaction().rollback();
                em.close();
            }
        }

    }
