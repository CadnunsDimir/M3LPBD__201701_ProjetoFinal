//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Tiago Silva do Nascimento
//******************************************************

package com.cadnunsdev;

import com.cadnunsdev.core.db.CursoRepository;
import com.cadnunsdev.core.modelos.Curso;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiago Silva
 */

//OBJETIVO..:: formulário que é usado para exibir a lista de cursos salvos e poder excluir os indesejados
public class ListaCursosForm extends javax.swing.JFrame {

    //OBJETIVO..: método usado para invocar a interface com a lista de cursos salvos
    static void start() {
        
        ListaCursosForm listaCursosForm = new ListaCursosForm();      
        listaCursosForm.setVisible(true);
    }

    /**
     * Creates new form ListaCursosForm
     */
    
    int selectedRows = 0;
    private final CursoRepository repository;
    private final DefaultTableModel tb;
    
    public ListaCursosForm() {
        initComponents();
        repository = new CursoRepository();
        
        tb = ((DefaultTableModel)tabelaCursos.getModel());
        
        btnDeletar.setVisible(false);
        
        lerDadosDoDB();
        
        tabelaCursos.addPropertyChangeListener(evt -> {
            int numRows = tb.getRowCount();
            selectedRows = 0;
            for(int i = 0; i < numRows; i++){
                boolean isSelected = (boolean)tb.getValueAt(i, 0);
                if(isSelected){
                    selectedRows++;
                }
            }
            btnDeletar.setVisible(selectedRows > 0);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCursos = new javax.swing.JTable();
        btnDeletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escola - Lista de Cursos");

        tabelaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Selecionar", "Codigo", "Curso", "vagas", "Carga Horaria", "Periodo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCursos);
        if (tabelaCursos.getColumnModel().getColumnCount() > 0) {
            tabelaCursos.getColumnModel().getColumn(0).setResizable(false);
            tabelaCursos.getColumnModel().getColumn(5).setResizable(false);
        }

        btnDeletar.setText("Deletar Selecionados");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jLabel1.setText("Veja abaixo a lista de cursos cadastrados:");

        btnAdicionarNovo.setText("Adicionar Novo");
        btnAdicionarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdicionarNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnAdicionarNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //OBJETIVO..:: ao ser acionado através do btnDeletar, exclui os selecionados, 
    //e recarrega a interface para que ela reflita as alterações
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int numRows = tb.getRowCount();
        selectedRows = 0;
        for(int i = 0; i < numRows; i++){
            boolean isSelected = (boolean)tb.getValueAt(i, 0);
            if(isSelected){
                int chaveCurso = (int)tb.getValueAt(i, 1);
                repository.removerCurso(chaveCurso);
            }
        }
        
        btnDeletar.setVisible(false);  
        this.setVisible(false);
        lerDadosDoDB();        
        this.setVisible(true);
    }//GEN-LAST:event_btnDeletarActionPerformed

    //OBJETIVO..:: invoca formulário para criar novo curso
    private void btnAdicionarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarNovoActionPerformed
        // TODO add your handling code here:
        new NovoCursoForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdicionarNovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaCursosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCursosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCursosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCursosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCursosForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarNovo;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCursos;
    // End of variables declaration//GEN-END:variables

    private void lerDadosDoDB() {
        ArrayList<Curso> cursos = repository.Listar();
        
        tb.getDataVector().removeAllElements();        
        DefaultTableModel tb =  ((DefaultTableModel)tabelaCursos.getModel());
        
        for(Curso curso : cursos){            
            Vector vector = new Vector();
            
            vector.add(false);
            vector.add(curso.getChaveCurso());
            vector.add(curso.getNomeDisciplina());
            vector.add(curso.getNumeroVagas());
            vector.add(curso.getCargaHoraria());
            vector.add(curso.getPeriodo());
            
            tb.addRow(vector);
        }
    }
        
    
}
