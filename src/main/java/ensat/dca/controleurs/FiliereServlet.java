package ensat.dca.controleurs;

import ensat.dca.model.Etudiant;
import ensat.dca.model.Filiere;
import ensat.dca.service.EtudiantService;
import ensat.dca.service.FiliereService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FiliereServlet", value = "/FiliereServlet")
public class FiliereServlet extends HttpServlet {

    Etudiant e;
    Filiere f;
    protected void updatefil(HttpServletRequest req) throws ServletException, IOException {
        FiliereService fil=new FiliereService();
        fil.update(new Filiere(req.getParameter("idFil"), req.getParameter("nomFil")));
    }
    protected void deletefil(HttpServletRequest req) throws ServletException, IOException {
        FiliereService fil = new FiliereService();
        String id = req.getParameter("id");
        fil.delete(fil.findById(id));
    }
    protected void processfil(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        FiliereService fil=new FiliereService();
        req.setAttribute("filieres", fil.findAll());
        req.getRequestDispatcher("lstFilieres.jsp").forward(req, res);

    }
    protected void addfil(HttpServletRequest req) {
        FiliereService fil = new FiliereService();
        fil.create(new Filiere(req.getParameter("idFil"), req.getParameter("nomFil")));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FiliereService fil=new FiliereService();
        List<Filiere> filLst=new ArrayList<>();
        EtudiantService etu=new EtudiantService();
        filLst=fil.findAll();
        String id;
        request.setAttribute("filieres", fil.findAll());
         if(request.getParameter("action").equals("ajouter"))
        request.getRequestDispatcher("addForm.jsp").forward(request,response);
        else if(request.getParameter("action").equals("edit")){
            id= request.getParameter("id");
            e= (Etudiant) etu.findById(id);
            request.setAttribute("ID",e);
            request.getRequestDispatcher("editForm.jsp").forward(request,response);}
        if(request.getParameter("action").equals("show"))
        {
            processfil(request,response);
        } else if (request.getParameter("action").equals("editfil")) {
            id= request.getParameter("id");
            f= (Filiere) fil.findById(id);
            request.setAttribute("ID",f);
            request.getRequestDispatcher("editFil.jsp").forward(request,response);
        }
        if (request.getParameter("action").equals("Ajouterfil"))
        {
            request.getRequestDispatcher("addFil.jsp").forward(request,response);
        }
        else if (request.getParameter("action").equals("deletefil")) {
            deletefil(request);
            processfil(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add")!=null)
        {   addfil(request);
            processfil(request,response);}
        else if(request.getParameter("updatefil")!=null){
            updatefil(request);
            processfil(request,response);
        }

      //  else processfil(request,response);

    }
}
