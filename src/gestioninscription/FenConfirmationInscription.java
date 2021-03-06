/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioninscription;
import sql.GestionBdd;
import java.sql.*;
import java.util.GregorianCalendar;

/**
 *
 * @author Valoo22
 */

public class FenConfirmationInscription extends javax.swing.JDialog 
    {
        Statement stmt1 = null;
        Statement stmt2 = null;
        int matricule;
        int numero;
        String nom_client;
        
        /**
         * Creates new form FenConfirmationInscription2
         */
        
        public FenConfirmationInscription(java.awt.Frame parent, boolean modal) 
            {
                super(parent, modal);
                initComponents();
            }
        public void init(Object id_client, Object numSession)
            {
                matricule = (Integer)id_client;
                numero = (Integer)numSession;
                //jLabel2.setText((String)matClient + " " + (Integer)numSession);
                stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor", "localhost", "root", "");
                stmt2 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor", "localhost", "root", "");
                String req = "Select libelle, niveau, date_debut, nb_inscrits, nb_places ";
                req += "From session_formation s, formation f ";
                req += "Where s.formation_id = f.id ";
                req += "And s.id = " + numero;
                ResultSet rsSession = GestionBdd.envoiRequeteLMD(stmt1, req);
                req = "Select nom from client Where id =" + id_client;
                ResultSet rsClient = GestionBdd.envoiRequeteLMD(stmt2, req);
                try
                    {
                        rsClient.first();
                        nom_client = rsClient.getString("nom");
                        rsSession.first();
                        tfSession.setText(rsSession.getString("libelle") + " " + rsSession.getString("niveau") );
                        tfDate.setText(rsSession.getString("date_debut"));
                        tfNbPlace.setText(String.valueOf(rsSession.getInt("nb_places")));
                        tfNbreInscrit.setText(String.valueOf(rsSession.getInt("nb_inscrits")));
                        tfNom.setText(nom_client);
                        rsSession.close();
                        stmt1.close();
                    }
                catch(SQLException sqle)
                    {
                        System.out.println("Erreur SQL3 : " + sqle.getMessage());
                    }
            }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitre = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        lblSession = new javax.swing.JLabel();
        tfSession = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        tfNbreInscrit = new javax.swing.JTextField();
        lblInscrit = new javax.swing.JLabel();
        tfNbPlace = new javax.swing.JTextField();
        lblPlace = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnAnullation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmer l'inscription");

        lblTitre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitre.setText("Confirmation d'inscription");

        lblNom.setText("Nom :");

        lblSession.setText("Session :");

        lblDate.setText("Date : ");

        lblInscrit.setText("inscrit(s) pour ");

        lblPlace.setText("places");

        btnConfirm.setText("Confirmation");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnAnullation.setText("Annulation");
        btnAnullation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnullationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfNbreInscrit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInscrit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNbPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAnullation, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(lblNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSession, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNom)
                                .addComponent(tfSession, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(tfDate)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSession)
                    .addComponent(tfSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInscrit)
                    .addComponent(tfNbreInscrit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNbPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnAnullation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        GregorianCalendar dateJour = new GregorianCalendar();
        String ddate = dateJour.get(GregorianCalendar.YEAR) + "-" + (dateJour.get(GregorianCalendar.MONTH) + 1) + "-" + dateJour.get(GregorianCalendar.DATE);
        // Insertion dans la table inscription
        String req = "Insert into inscription(client_id, session_formation_id, date_inscription) values (" + matricule + ", " + numero + ",'" + ddate + "')";
        // M.A.J de la table session_formation (un inscrit de plus)
        String req2 = "Update session_formation set nb_inscrits = nb_inscrits +1 Where id = " + numero;
        // Récupération du numéro de la session concernée
        String req3 = "Select formation_id from session_formation where id = " + numero;
        stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor", "localhost", "root", "");
        ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1, req3);
        int numForm=0;
            try
                {
                    rs.first();
                    numForm = rs.getInt(1);
                }
            catch(Exception e)
                {
                    System.out.println("Erreur requete3 " + e.getMessage());
                }
        // M.A.J de la table plan_formation (effectue passe à 1 pour le client et la session concernés)
        String req4 = "Update plan_formation set effectue = 1 Where client_id = " + numero + " And formation_id = " + numForm;
        int nb1 = GestionBdd.envoiRequeteLID(stmt1, req);
        int nb2 = GestionBdd.envoiRequeteLID(stmt1, req2);
        int nb3 = GestionBdd.envoiRequeteLID(stmt1, req4);
        this.dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnAnullationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnullationActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAnullationActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnullation;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblInscrit;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblSession;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfNbPlace;
    private javax.swing.JTextField tfNbreInscrit;
    private javax.swing.JTextField tfNom;
    private javax.swing.JTextField tfSession;
    // End of variables declaration//GEN-END:variables
}
