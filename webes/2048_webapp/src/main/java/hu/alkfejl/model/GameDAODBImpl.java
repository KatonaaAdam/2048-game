package hu.alkfejl.model;

import hu.alkfejl.model.bean.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GameDAODBImpl implements GameDAO {

  // EZEKET MAJD ÁT KELL ÍRNI!!!!!!!
  private static final String CONN = "jdbc:sqlite:D:\\_Desktop\\ALKALMAZASFEJLESZTES_PROJEKT\\webes\\2048_webapp\\src\\main\\resources\\db\\sqlite.db";
  private static final String ADD_GAME = "INSERT INTO game (lvl,ido) VALUES (?,?)";
  private static final String LIST_GAME = "SELECT * FROM game";

  
  
  public GameDAODBImpl() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public boolean addGame(Game p) {
    
    try (Connection c = DriverManager.getConnection(CONN);
         PreparedStatement pst = c.prepareStatement(ADD_GAME)) {
      pst.setString(2, p.getTime());
      pst.setInt(1, p.getLevel());
      return pst.executeUpdate() == 1;
      
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Game> listGame() {
    
    List<Game> game = new ArrayList<Game>();

    try (Connection c = DriverManager.getConnection(CONN);
         Statement st = c.createStatement()) {

      ResultSet rs = st.executeQuery(LIST_GAME);

      while (rs.next()) {
        game.add(new Game(rs.getInt(1),rs.getString(2)));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return game;

  }

}
