package com.example.ampelschaltung_final;



import java.sql.*;


public class Highscore {
  public static void Highscore(String[] args) throws Exception {
    Connection con = DriverManager.getConnection("ichmagpommes");

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("select * from Tabelle11");

    while (rs.next()) {
      System.out.println(rs.getString(1) + "\t" + rs.getString(2));
    }

    con.close();
  }
}
