package hu.alkfejl.model.bean;

public class Game {

  private String time;
  private int level;


  public Game() {
  }

  public Game( int level,String time) {

    this.time = time;
    this.level = level;
  }


  public String getTime() { return time; }

  public void setTime(String time) { this.time = time; }

  public int getLevel() { return level; }

  public void setLevel(int level) { this.level = level; }
}

