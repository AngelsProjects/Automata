/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author CLON
 */
public class View extends javax.swing.JFrame {
Object values[][];
    File archivo;
    JFileChooser seleccionado;
    Archivos files;
    int alf = 0;
    int est = 0;
    ImageIcon img;

    public View() {
        img = new ImageIcon("src/resources/atom-icon.png");
        initComponents();
        alfabeto.getDocument().addDocumentListener(new documentListener());
        alfabeto.getDocument().putProperty("name", "alfabeto");
        estados.getDocument().addDocumentListener(new documentListener());
        estados.getDocument().putProperty("name", "estados");

        path.getDocument().addDocumentListener(new pathListener());
        path.getDocument().putProperty("name", "path");

        PromptSupport.setPrompt("Please write characteres for alphabet", alfabeto);
        PromptSupport.setPrompt("Please write number(s) for states", estados);
        PromptSupport.setPrompt("Please write a correct path", path);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, alfabeto);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, estados);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, path);
        PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, alfabeto);
        PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, estados);
        PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, path);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estados = new javax.swing.JTextField();
        alfabeto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selectOption = new javax.swing.JComboBox();
        minimizeBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        path = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());

        jLabel1.setText("Alfabeto: ");

        jLabel2.setText("Estados: ");

        estados.setEnabled(false);

        alfabeto.setEnabled(false);
        alfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetoActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tabla.setEnabled(false);
        jScrollPane1.setViewportView(tabla);

        saveBtn.setBackground(new java.awt.Color(255, 255, 255));
        saveBtn.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        selectOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Automate form file", "Automate from table" }));
        selectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOptionActionPerformed(evt);
            }
        });

        minimizeBtn.setText("Minimize");

        searchBtn.setText("Search");
        searchBtn.setEnabled(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        path.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estados, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(selectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(path)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchBtn)))
                                .addGap(188, 188, 188)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minimizeBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimizeBtn)
                    .addComponent(searchBtn)
                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(alfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBtn)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        /*files = new Archivos();
         seleccionado = new JFileChooser();
         if (!contenido.getText().trim().equals("")) {
         if (seleccionado.showDialog(null, "Save File") == JFileChooser.APPROVE_OPTION) {
         archivo = seleccionado.getSelectedFile();
         if (archivo.getName().endsWith("txt")) {
         String cont = contenido.getText();
         String respuesta = files.SaveText(archivo, contentFile);
         JOptionPane.showMessageDialog(null, respuesta);
         } else {
         JOptionPane.showMessageDialog(null, "The file most be saved as .txt extenssion");
         }
         }
         } else {
         JOptionPane.showMessageDialog(null, "Sorry... You have to select correct tokens and sample files first ☺");
         }*/
 /*
        aqui va a guardar el archivo serializado
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("media.ser"));
            salida.writeObject("guardar este string y un objeto\n");
            salida.writeObject(lista1);
            salida.close();
        
         */
    }//GEN-LAST:event_saveBtnActionPerformed

    private void alfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alfabetoActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        archivo = null;
        seleccionado = new JFileChooser();
        if (seleccionado.showDialog(null, "Open File") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead() && archivo.getName().endsWith("ser")) {
                path.setText(seleccionado.getSelectedFile().getAbsolutePath());
            } else {
                path.setText("");
                JOptionPane.showMessageDialog(null, "Please select a file serialized");
            }
        } else {
            path.setText("");
            JOptionPane.showMessageDialog(null, "Please select a file serialized");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void selectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectOptionActionPerformed
        switch (selectOption.getSelectedIndex()) {
            case 0:
                path.setEnabled(false);
                path.setText("");
                searchBtn.setEnabled(false);
                alfabeto.setEnabled(false);
                alfabeto.setText("");
                estados.setEnabled(false);
                estados.setText("");
                tabla.setEnabled(false);
                break;
            case 1:
                path.setEnabled(true);
                searchBtn.setEnabled(true);
                alfabeto.setEnabled(false);
                alfabeto.setText("");
                estados.setEnabled(false);
                estados.setText("");
                tabla.setEnabled(false);
                break;
            case 2:
                path.setEnabled(false);
                path.setText("");
                searchBtn.setEnabled(false);
                alfabeto.setEnabled(true);
                estados.setEnabled(true);
                tabla.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_selectOptionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alfabeto;
    private javax.swing.JTextField estados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JTextField path;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox selectOption;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
class documentListener implements DocumentListener {

        final String newline = "\n";

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "insertado en");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removido en");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();
            DefaultTableModel model;
            ArrayList<String> columnNames = null;
            
            
            //ALINEA LOS TITULOS DE LAS COLUMNAS
            TableCellRenderer rendererFromHeader = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            //AQUI TERMINA LA ALINEACION DE LOS TITULOS DE LAS COLUMNAS
            
            switch (doc.getProperty("name").toString()) {
                case "alfabeto":
                    alf = doc.getLength()+1;
                    break;
                case "estados":
                    if (estados.getText().matches("\\d+")) {
                        est = Integer.parseInt(estados.getText());
                    } else {
                        est = 0;
                    }
                    break;
            }
            if (est > 0 && alf > 0) {
                 values= new Object[est][alf];
                String titulos[] = new String[alf];
                
                for (int x = 0; x < alf; x++) {
                    if(x==0){
                        titulos[0]="Estado";
                    }
                    else {
                       
                    if ((x + 1) < alf) {
                        
                        if ("[".equals(alfabeto.getText().substring(x, x + 1))) {
                            boolean flag = false;
                            for (int y = x; y < alfabeto.getText().substring(x).length(); y++) {
                                if ("]".equals(alfabeto.getText().substring(y, y + 1))) {
                                    flag = true;
                                    titulos[x] = alfabeto.getText().substring(x, y + 1);
                                    break;
                                }
                            }
                            if (flag == false) {
                                titulos[x] = alfabeto.getText().substring(x, x + 1);
                            }
                        } else {
                            titulos[x] = alfabeto.getText().substring(x, x + 1);
                        }

                    } 
                    else {
                        titulos[x] = alfabeto.getText().substring(x);
                    }
                    System.out.println(titulos[x]);
                }
                
                }
                for (int x = 0; x < est; x++) {
                    values[x][0] = "q" + x;
                }
                
                
                JViewport parent = (JViewport) tabla.getParent();
                JScrollPane enclosing = (JScrollPane) parent.getParent();
               // enclosing.setRowHeaderView(rowHeader);
                getContentPane().add(enclosing, BorderLayout.CENTER);
                System.out.println();
                model = new DefaultTableModel(values, titulos);
                tabla.setModel(model);
            } else {
                tabla.setModel(new DefaultTableModel(0, 0));
            }
                tabla.getColumnModel().getColumn(0).setCellRenderer(new RowHeaderRenderer());//.setHeaderValue("setzo");//.setCellRenderer(new RowHeaderRenderer());
                
            
            
            
        }
    }

 class RowHeaderRenderer extends DefaultTableCellRenderer {
    public RowHeaderRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            JTableHeader header = table.getTableHeader();
        cellComponent.setBackground(header.getBackground());
        cellComponent.setFont(header.getFont());
        cellComponent.setForeground(header.getForeground());
        cellComponent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return cellComponent;
    }
    }


    class pathListener implements DocumentListener {

        final String newline = "\n";

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "insertado en");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removido en");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateLog(e, "cambio en");
        }

        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();
            archivo = new File(path.getText());
            if (archivo.canRead() && archivo.getName().endsWith("ser")) {
                JOptionPane.showMessageDialog(null, "si se podra ingresar los datos dentro de la tabla");
                /*
                Aqui va a leer el archivo serializado
                
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("media.ser"));
            String str = (String) entrada.readObject();
            Lista obj1 = (Lista) entrada.readObject();
            System.out.println("Valor medio " + obj1.valorMedio());
            System.out.println("-----------------------------");
            System.out.println(str + obj1);
            System.out.println("-----------------------------");
            entrada.close();
                 */
            }
        }
    }

    public void minimizeAutomate() {

    }
}
