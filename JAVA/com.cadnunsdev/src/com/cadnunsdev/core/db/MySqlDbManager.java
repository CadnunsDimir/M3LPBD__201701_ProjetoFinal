/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev.core.db;

import com.cadnunsdev.core.AppConfig;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Silva
 */
public class MySqlDbManager {
    static{
         try
        {
            Class.forName(AppConfig.MYSQL_DRIVER_NAME).newInstance();
            System.out.println("*** Driver loaded");
        }
        catch(Exception e)
        {
            System.out.println("*** Error : "+e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() throws SQLException{        
        return getConnection(AppConfig.MYSQL_URL);
    }
    
    private Connection getConnection(String db_url)throws SQLException{
        return DriverManager.getConnection(db_url, AppConfig.MYSQL_USER, AppConfig.MYSQL_PW);
    }
    
    public void initDb() {
        Connection conn;
        
        String[] scripts = AppConfig.CREATE_DATABASE_SQL.split(";");
        
        try {
            conn = getConnection(AppConfig.MYSQL_URL_NO_DB);
            for(String sql : scripts)
                if(sql.trim().length() > 0)
                    conn.prepareStatement(sql).execute();
            //executeSystem.err.println(AppConfig.CREATE_DATABASE_SQL);
        } catch (SQLException ex) {
            System.err.println("erro : "+ex.getLocalizedMessage());
        }
        
    }
}
