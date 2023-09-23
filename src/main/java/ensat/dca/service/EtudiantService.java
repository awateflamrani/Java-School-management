package ensat.dca.service;

import ensat.dca.dao.IDao;
import ensat.dca.dao.daoFactory;
import ensat.dca.model.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EtudiantService implements IDao {

    public static Connection MyCon;

    public EtudiantService(){
        MyCon= daoFactory.getConnection();}
    @Override
    public boolean create(Object o) {
        Etudiant etu=(Etudiant) o;
        String req="Insert into etudiant(idEtu,nom,prenom,sexe,filiere) values(?,?,?,?,?)";
        PreparedStatement ps;
        try{
            ps=MyCon.prepareStatement(req);
            ps.setString(1,etu.getIdEtu());
            ps.setString(2,etu.getNom());
            ps.setString(3,etu.getPrenom());
            ps.setString(4,etu.getSexe());
            ps.setString(5,etu.getFiliere());
            int rows=ps.executeUpdate();
            if(rows>0)
            {
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Object o) {
        Etudiant etu=(Etudiant) o;
        String req="Delete From etudiant where idEtu=?";
        PreparedStatement ps;
        try{
        ps=MyCon.prepareStatement(req);
        ps.setString(1,etu.getIdEtu());
        int rows=ps.executeUpdate();
        if(rows<0)
        {
            System.out.println("successfully DELETED");
            return true;
        }
        else
        {
            System.out.println("no student deleted");
            return false;
        }

    }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Object o) {
        Etudiant e=(Etudiant) o;
        String req="UPDATE etudiant SET nom=?,prenom=?,sexe=?,filiere=? WHERE idEtu=?";
        PreparedStatement ps;
        try{
            ps= MyCon.prepareStatement(req);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getSexe());
            ps.setString(4, e.getFiliere());
            ps.setString(5, e.getIdEtu());
            int res= ps.executeUpdate();
            if(res>0)
            {
                return true;
            }
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Object findById(String id) {
        Etudiant etu=null;
        String req="Select * From etudiant where idEtu=?";
        PreparedStatement ps;
        try {
            ps = MyCon.prepareStatement(req);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etu = new Etudiant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return etu;
    }

    @Override
    public List findAll() {
        List<Etudiant> etuLst=new ArrayList<>();
        String req="Select * From etudiant";
        PreparedStatement ps;
        try{
            ps=MyCon.prepareStatement(req);
            ResultSet rs=ps.executeQuery(req);
            while(rs.next())
            {
                etuLst.add(new Etudiant(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            return etuLst;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
