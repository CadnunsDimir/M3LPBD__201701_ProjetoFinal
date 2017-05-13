/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadnunsdev.core;
/**
 *
 * @author Tiago Silva
 */
public class AppConfig {
    public static final String CREATE_DATABASE_SQL = 
        "CREATE DATABASE IF NOT EXISTS escola;\n" +
        "\n" +
        "USE escola;\n" +
        "\n" +
        "CREATE TABLE IF NOT EXISTS cursos(\n" +
        "    ChaveCurso int(11) NOT NULL auto_increment,\n" +
        "    NomeDisciplina varchar(100) not null ,\n" +
        "    CargaHoraria int(5) not null,\n" +
        "    NumeroVagas int(5) not null,\n" +
        "    Periodo varchar(100) not null,\n" +
        "    Primary Key(ChaveCurso)\n" +
        ") ;\n" +
        "";
    public static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3307/escola";
    public static final String MYSQL_URL_NO_DB =  "jdbc:mysql://localhost:3307/";
    public static final String MYSQL_USER = "root";
    public static final String MYSQL_PW = "usbw";
    public static final String MYSQL_DB = "escola";
}
