/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev;

import com.cadnunsdev.core.db.MySqlDbManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Silva
 */
public class ComCadnunsdev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MySqlDbManager.exceptionCallback = ex ->{
            JOptionPane.showMessageDialog(null, ex.getMessage());
        };
        new MySqlDbManager().initDb();
        ListaCursosForm.start();
    }
    
}
