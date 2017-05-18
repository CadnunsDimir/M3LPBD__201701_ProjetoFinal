//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Tiago Silva do Nascimento
//******************************************************

package com.cadnunsdev.core.db;

import com.cadnunsdev.core.AppConfig;
import com.cadnunsdev.core.modelos.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Silva
 */

//OBJETIVO..: Classe responsável para recuperação de dados no 
//Banco de dados e a sua conversão em objetos java
public class CursoRepository {
    
    public ArrayList<Curso> Listar(){    
        ArrayList<Curso> lista = new ArrayList<>();
        
        try {
            ResultSet cursor = MySqlDbManager.Query(AppConfig.SELECT_CURSOS);
            while(cursor.next()){
                Curso curso = new Curso();
                
                curso.setChaveCurso(cursor.getInt("ChaveCurso"));
                curso.setNomeDisciplina(cursor.getString("NomeDisciplina"));
                curso.setCargaHoraria(cursor.getInt("CargaHoraria"));                
                curso.setNumeroVagas(cursor.getInt("NumeroVagas"));
                curso.setPeriodo(cursor.getString("Periodo"));
                
                lista.add(curso);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(CursoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public void removerCurso(int chaveCurso) {
        MySqlDbManager.ExecuteCommand("delete from cursos where ChaveCurso = "+chaveCurso);
    }

    public void inserir(Curso curso) {
        MySqlDbManager.ExecuteCommand("insert into cursos"
                + "(NomeDisciplina,Periodo,CargaHoraria,NumeroVagas) values('"
                +curso.getNomeDisciplina()+"','"
                +curso.getPeriodo()+"',"
                +curso.getCargaHoraria()+","
                +curso.getNumeroVagas()
                +")");
    }
}
