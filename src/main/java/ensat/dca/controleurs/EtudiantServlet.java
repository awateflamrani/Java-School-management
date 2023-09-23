package ensat.dca.controleurs;

import ensat.dca.model.Etudiant;
import ensat.dca.service.EtudiantService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EtudiantServlet", value = "/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {

    protected void update(HttpServletRequest req) throws ServletException, IOException {
        EtudiantService etu = new EtudiantService();

        etu.update(new Etudiant(req.getParameter("idEtu"), req.getParameter("nom"), req.getParameter("prenom"), req.getParameter("Sexe"), req.getParameter("filiere")));
    }

    protected void delete(HttpServletRequest req) throws ServletException, IOException {
        EtudiantService etu = new EtudiantService();
        String id = req.getParameter("id");
        etu.delete(etu.findById(id));
    }

    protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EtudiantService etu = new EtudiantService();
        req.setAttribute("etudiants", etu.findAll());
        req.getRequestDispatcher("lstEtudiants.jsp").forward(req, res);

    }

    protected void add(HttpServletRequest req) {
        /*String id=request.getParameter("idEtu");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String filiere=request.getParameter("filiere");
        String sexe=request.getParameter("Sexe");*/
        EtudiantService etu = new EtudiantService();
        etu.create(new Etudiant(req.getParameter("idEtu"), req.getParameter("nom"), req.getParameter("prenom"), req.getParameter("Sexe"), req.getParameter("filiere")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("action").equals("delete")) {
            delete(request);
            process(request, response);
        }
        else
            process(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("add")!=null)
        {
            add(request);
            process(request,response);
        }
        else if(request.getParameter("update")!=null){
            update(request);
            process(request,response);
        }else process(request,response);



        /*
       String M=request.getParameter("nom");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + M + "</h1>");
        out.println("</body></html>");
      */
    }
}
