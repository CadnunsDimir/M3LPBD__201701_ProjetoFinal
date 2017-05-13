/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev.core.db;

import com.cadnunsdev.core.modelos.Curso;
import java.util.ArrayList;

/**
 *
 * @author Tiago Silva
 */
public class CursoRepository {

    private final MySqlDbManager db;

    public CursoRepository(MySqlDbManager manager) {
        db = manager;
    }
    
    public ArrayList<Curso> Listar(){    
        return new ArrayList<>();
    }
}
