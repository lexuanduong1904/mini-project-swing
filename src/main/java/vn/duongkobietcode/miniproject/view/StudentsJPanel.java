/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vn.duongkobietcode.miniproject.view;

import java.sql.SQLException;

import vn.duongkobietcode.miniproject.controller.StudentManagerController;

/**
 *
 * @author ADMIN
 */
public class StudentsJPanel extends javax.swing.JPanel {

        /**
         * Creates new form StudentsJPanel
         */
        public StudentsJPanel() {
                initComponents();

                try {
                        StudentManagerController studentManagerController = new StudentManagerController(jPanelView,
                                        jButtonAdd,
                                        jTextFieldSearch);
                        studentManagerController.setDataTable();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanelRoot = new javax.swing.JPanel();
                jButtonAdd = new javax.swing.JButton();
                jTextFieldSearch = new javax.swing.JTextField();
                jPanelView = new javax.swing.JPanel();

                jPanelRoot.setBackground(new java.awt.Color(240, 240, 240));

                jButtonAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                jButtonAdd.setText("+ Thêm mới");
                jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonAddActionPerformed(evt);
                        }
                });

                jTextFieldSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

                javax.swing.GroupLayout jPanelViewLayout = new javax.swing.GroupLayout(jPanelView);
                jPanelView.setLayout(jPanelViewLayout);
                jPanelViewLayout.setHorizontalGroup(
                                jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                jPanelViewLayout.setVerticalGroup(
                                jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 448, Short.MAX_VALUE));

                javax.swing.GroupLayout jPanelRootLayout = new javax.swing.GroupLayout(jPanelRoot);
                jPanelRoot.setLayout(jPanelRootLayout);
                jPanelRootLayout.setHorizontalGroup(
                                jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelRootLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanelRootLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanelView,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanelRootLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jTextFieldSearch,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                250,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                411,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButtonAdd)))
                                                                .addContainerGap()));
                jPanelRootLayout.setVerticalGroup(
                                jPanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelRootLayout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(
                                                                                jPanelRootLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jButtonAdd,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                30,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jTextFieldSearch,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                30,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanelView,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanelRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanelRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        }// </editor-fold>//GEN-END:initComponents

        private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButtonAddActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButtonAdd;
        private javax.swing.JPanel jPanelRoot;
        private javax.swing.JPanel jPanelView;
        private javax.swing.JTextField jTextFieldSearch;
        // End of variables declaration//GEN-END:variables
}
