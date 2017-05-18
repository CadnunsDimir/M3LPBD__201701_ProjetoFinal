//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Tiago Silva do Nascimento
//******************************************************

package com.cadnunsdev.core.db;

import com.cadnunsdev.core.AppConfig;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Silva
 */

//OBJETIVO..: Classe utilizada para manipulação direta ao banco de dados.
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
    
    public static ExceptionCallback exceptionCallback;
    

    static ResultSet Query(String queryString) throws SQLException {
        return getConnection().createStatement().executeQuery(queryString);
    }
    
    public static Connection getConnection() throws SQLException{        
        return getConnection(AppConfig.MYSQL_URL);
    }
    
    private static Connection getConnection(String db_url)throws SQLException{
        return DriverManager.getConnection(db_url, AppConfig.MYSQL_USER, AppConfig.MYSQL_PW);
    }
    
    public static void initDb() {
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
            fireException(ex);
        }
    }

    public static void ExecuteCommand(String sql) {
        try {
            getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlDbManager.class.getName()).log(Level.SEVERE, null, ex);
            fireException(ex);
        }
    }

    private static void fireException(SQLException ex) {
        if(exceptionCallback != null){
            exceptionCallback.fired(ex);
        }
    }
    
    //interface utilizada para definir o callback de exceções na nossa aplicação
    public interface ExceptionCallback{
        public void fired(Exception ex);
    }
}
