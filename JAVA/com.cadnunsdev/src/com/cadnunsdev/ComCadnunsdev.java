/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev;

import com.cadnunsdev.core.db.MySqlDbManager;

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
        new MySqlDbManager().initDb();
        ListaCursosForm.start();
    }
    
}
