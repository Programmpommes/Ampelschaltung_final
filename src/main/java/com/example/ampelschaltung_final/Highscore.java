package com.example.ampelschaltung_final;

import java.sql.*;
public class Highscore{
    Connection con;
    
    Highscore(){
        try{
            //Registrierung des Datenbanktreibers - kann nach der ersten Benutzung auskommentiert werden. 
            Class.forName("org.sqlite.JDBC").newInstance();
            //Pfad zur Datenbank (Datei highscore.db im Projektordner) 
            //über die Schnittstelle JDBC (Java Database Connectivity)
            //unter Nutzung eines Treibers für SQLite Datenbanken
            String url = "jdbc:sqlite:Datenbank1.db";
            // Aufbau der Verbindung zur Datenbank
            con = DriverManager.getConnection(url);
            
            System.out.println("Verbindung zur Datenbank aufgebaut");
        }
        catch(Exception ex)
        {
            System.out.println("Irgendwas ist schiefgelaufen");
            System.out.println(ex.getMessage());
        }
    }
    public void TabelleAusgeben(){
        try{
            Statement anfrage = con.createStatement();
            
            ResultSet x = anfrage.executeQuery("select * from Tabelle1 order by HIGHSCORE DESC");
            
            //wiederhole 3 mal   // wiederhole solange x.next
            for(int i = 0; i < 100; i++){   
                System.out.println(x.getString(3));
                System.out.println(x.getString(2));
                x.next();
                // endewiederhole
            }
        }
        catch(Exception ex)
        {
            System.out.println("Tabelle konnte nicht ausgegeben werden");
            System.out.println(ex.getMessage());
        }
    }
}
