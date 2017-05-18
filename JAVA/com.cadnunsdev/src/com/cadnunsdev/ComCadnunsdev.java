//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Tiago Silva do Nascimento
//******************************************************

package com.cadnunsdev;

import com.cadnunsdev.core.db.MySqlDbManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Silva
 */
// Essa classe de inicialização da aplicação
public class ComCadnunsdev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Notificador de excecoes no banco de dados configurado
        MySqlDbManager.exceptionCallback = ex ->{
            JOptionPane.showMessageDialog(null, ex.getMessage());
        };
        
        //inicializacao do banco de dados: caso não tenha sido criado aqui ocorrerá isso
        new MySqlDbManager().initDb();
        
        //aqui é aonde chamamos o form com a lista de cursos salvos
        ListaCursosForm.start();
    }
    
}
