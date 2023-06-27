package com.example.ampelschaltung_final;
imoport java.sql.*
public class Highscore {
  public static void Highscore(String[] args) throws Exception{
    Connection con = DriverManager.getConnection();

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery();

    while(rs.next()){
      System.out.Println(rs.getString(1)+"\t"+rs.getString(2));
    }

    con.close();
}
