/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev.core.modelos;

/**
 *
 * @author Tiago Silva
 */
public class Curso {
    private int chaveCurso;
    private String nomeDisciplina;
    private int cargaHoraria;
    private int numeroVagas;
    private String Periodo;
    
    
    public int getChaveCurso(){
      return chaveCurso;
    }
    public void setChaveCurso(int chave){
      chaveCurso = chave;
    }    
    
    public String getNomeDisciplina(){
      return nomeDisciplina;
    }
    public void setNomeDisciplina(String nome){
      nomeDisciplina = nome;
    }
    
    public int getCargaHoraria(){
      return cargaHoraria;
    }
    public void setCargaHoraria(int carga){
      cargaHoraria = carga;
    }
    
    public int getNumeroVagas(){
      return numeroVagas;
    }
    public void setNumeroVagas(int numero){
      numeroVagas = numero;
    }
        
    public String getPeriodo(){
      return Periodo;
    }
    public void setPeriodo(String periodo){
      Periodo = periodo;
    }
}
