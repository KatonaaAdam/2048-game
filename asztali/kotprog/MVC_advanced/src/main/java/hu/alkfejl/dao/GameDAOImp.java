package hu.alkfejl.dao;

import hu.alkfejl.model.ModelGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImp implements GameDAO {
    final String DB="jdbc:sqlite:D:\\_Desktop\\ALKALMAZASFEJLESZTES_PROJEKT\\webes\\2048_webapp\\src\\main\\resources\\db\\sqlite.db";

    public void initializeTables() {
        try (Connection conn = DriverManager.getConnection(DB); Statement st = conn.createStatement()) {
            st.executeUpdate(CREATE_GAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GameDAOImp(){initializeTables();}

    final String CREATE_GAME="Create table if not exists game (" +
            "lvl INTEGER," +
            "ido TEXT" +
            ")";
    final String ADD_GAME="Insert into game (lvl,ido) values(?,?)";
    final String LIST_GAME="Select * from game";



    @Override
    public boolean add(int lvl,String ido) {
        try (Connection conn = DriverManager.getConnection(DB);
             PreparedStatement ps = conn.prepareStatement(ADD_GAME)){
            ps.setInt(1,lvl);
            System.out.println(lvl);
            ps.setString(2,ido +" s");
            System.out.println(ido);
            int res= ps.executeUpdate();
            if (res==1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<ModelGame> getAll() {
            List<ModelGame> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(LIST_GAME)){
            ModelGame m;
            while (rs.next()) {
                m = new ModelGame();

                m.setLvl(rs.getInt("lvl"));
                m.setIdo(rs.getString("ido"));
                result.add(m);


            }
            return result;
        }catch (Exception e){
            System.out.println("get all exception");
            e.printStackTrace();
        }
        return null;
    }
}
