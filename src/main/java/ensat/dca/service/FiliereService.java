package ensat.dca.service;

import ensat.dca.dao.IDao;
import ensat.dca.dao.daoFactory;
import ensat.dca.model.Etudiant;
import ensat.dca.model.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereService implements IDao {

    public static Connection MyCon;

    public FiliereService() {
        MyCon = daoFactory.getConnection();
    }

    @Override
    public boolean create(Object o) {
        Filiere fil=(Filiere) o;
        String req="Insert into filiere(idFil,nomFil) values(?,?)";
        PreparedStatement ps;
        try{
            ps=MyCon.prepareStatement(req);
            ps.setString(1,fil.getIdFil());
            ps.setString(2,fil.getNomFil());;
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
        Filiere etu=(Filiere) o;
        String req="Delete From filiere where idFil=?";
        PreparedStatement ps;
        try{
            ps=MyCon.prepareStatement(req);
            ps.setString(1,etu.getIdFil());
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
        Filiere f=(Filiere) o;
        String req="UPDATE filiere SET nomFil=? WHERE idFil=?";
        PreparedStatement ps;
        try{
            ps= MyCon.prepareStatement(req);
            ps.setString(1, f.getNomFil());
            ps.setString(2, f.getIdFil());
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
        Filiere fil=null;
        String req="Select * From filiere where idFil=?";
        PreparedStatement ps;
        try {
            ps = MyCon.prepareStatement(req);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fil = new Filiere(rs.getString(1), rs.getString(2));

            }

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return fil;
    }

    @Override
    public List findAll() {
        List filLst = new ArrayList<Filiere>();

        String req = "Select * From filiere";
        PreparedStatement ps;
        try {
            ps = MyCon.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));

                filLst.add(new Filiere(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filLst;
    }
}
