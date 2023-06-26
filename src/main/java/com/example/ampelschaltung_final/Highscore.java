package com.example.ampelschaltung_final;
imoport java.sql.*
public class Highscore {
  public static void Highscore(String[] args) throws Exception{
    Connection con = DriverManager.getConnection();

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery();

    while(rs.next()){
      System.out.Println(rs.getString(columnindex:1)+"\t"+rs.getString(columnindex2));
    }

    con.close();
}
