/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class TicTacToeF extends javax.swing.JFrame implements ActionListener {

    int start = 0;
    Boolean AI = false;
    JButton[][] butArray = new JButton[3][3];

    int moves = 0; //counts how many moves a person has made
    boolean gameOver = false;

    /**
     * Creates new form MatchingFrame
     */
    public TicTacToeF() {
        initComponents();
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        ResultDisplay = new javax.swing.JTextField();
        NewGame = new javax.swing.JButton();
        AIBut = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 700));

        GamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        GamePanel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        GamePanel.setPreferredSize(new java.awt.Dimension(500, 400));
        GamePanel.setLayout(new java.awt.GridLayout(3, 3, 10, 10));

        Title.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Tic Tac Toe");

        ResultDisplay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ResultDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ResultDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultDisplayActionPerformed(evt);
            }
        });

        NewGame.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        NewGame.setText("New Game");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        AIBut.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        AIBut.setText("AI");
        AIBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(GamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AIBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(ResultDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(AIBut, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ResultDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResultDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultDisplayActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        gameOver = false;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                butArray[a][b].setText(" ");//clears all buttons
                butArray[a][b].setEnabled(true); //lets them click button again
                butArray[a][b].setBackground(new Color(240, 240, 240)); //resets background color to white
                if (start % 2 == 0) {
                    ResultDisplay.setText("X Move");

                } else {
                    ResultDisplay.setText("O Move");
                }
            }

        }
        if (AI && start % 2 == 1) {
            int temp[] = getPlace();
            int RCord = temp[0];
            int CCord = temp[1];
            butArray[RCord][CCord].setText("O");
            butArray[RCord][CCord].setEnabled(false);
            ResultDisplay.setText("X Move");
            moves++;
        }
    }//GEN-LAST:event_NewGameActionPerformed

    private void AIButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIButActionPerformed
        AI = !AI;
        ResultDisplay.setText("AI= " + AI);
        if (AI && moves % 2 == 1) {
            int temp[] = getPlace();
            int RCord = temp[0];
            int CCord = temp[1];
            butArray[RCord][CCord].setText("O");
            moves++;
            butArray[RCord][CCord].setEnabled(false);
            int y = checkWin();
            if (y == 1) {
                ResultDisplay.setText("X win");
                Over();
            }
            if (y == 2) {
                ResultDisplay.setText("O win");
                Over();
            }
            if (y == 0) {
                int count = 0;
                for (int r1 = 0; r1 < 3; r1++) {
                    for (int c1 = 0; c1 < 3; c1++) {
                        if (butArray[r1][c1].getText().equals("X") || butArray[r1][c1].getText().equals("O")) {
                            count++;

                        }
                    }
                }
                if (count == 9) {
                    ResultDisplay.setText("Tie!");

                }
            }
        }
    }//GEN-LAST:event_AIButActionPerformed

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
            java.util.logging.Logger.getLogger(TicTacToeF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AIBut;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JButton NewGame;
    private javax.swing.JTextField ResultDisplay;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
public void initialize() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                butArray[r][c] = new JButton(); //creates an array of buttons
                butArray[r][c].addActionListener(this);
                butArray[r][c].setSize(50, 50);
                butArray[r][c].setBackground(new Color(240, 240, 240)); //sets default color to white
                butArray[r][c].setText(" "); // sets default display to spaces
                butArray[r][c].setFont(new Font("Arial", Font.PLAIN, 40));
                GamePanel.add(butArray[r][c]);
                if (moves % 2 == 0) {
                    ResultDisplay.setText("X Move");

                } else {
                    ResultDisplay.setText("O Move");
                }

            }
        }

        // butArray = CreateBoard(); //creates the butArray that the player will be playing on
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!AI) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {

                    if (ae.getSource() == butArray[r][c]) {
                        if (moves % 2 == 0) {
                            butArray[r][c].setText("X");
                            butArray[r][c].setEnabled(false);
                        } else {
                            butArray[r][c].setText("O");
                            butArray[r][c].setEnabled(false);
                        }

                        moves++;
                        if (moves % 2 == 0) {
                            ResultDisplay.setText("X Move");

                        } else {
                            ResultDisplay.setText("O Move");
                        }
                        int x = checkWin();
                        if (x == 1) {
                            ResultDisplay.setText("X win");
                            Over();
                        }
                        if (x == 2) {
                            ResultDisplay.setText("O win");
                            Over();
                        }
                        if (x == 0) {
                            int count = 0;
                            for (int r1 = 0; r1 < 3; r1++) {
                                for (int c1 = 0; c1 < 3; c1++) {
                                    if (butArray[r1][c1].getText().equals("X") || butArray[r1][c1].getText().equals("O")) {
                                        count++;

                                    }
                                }
                            }
                            if (count == 9) {
                                ResultDisplay.setText("Tie!");

                            }
                        }
                    }
                }

            }
        } else {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (ae.getSource() == butArray[r][c]) {
                        butArray[r][c].setText("X");
                        butArray[r][c].setEnabled(false);
                        moves++;
                        int x = checkWin();
                        if (x == 1) {
                            ResultDisplay.setText("X win");
                            Over();
                        }
                        if (x == 2) {
                            ResultDisplay.setText("O win");
                            Over();
                        }
                        if (x == 0) {
                            int count = 0;
                            for (int r1 = 0; r1 < 3; r1++) {
                                for (int c1 = 0; c1 < 3; c1++) {
                                    if (butArray[r1][c1].getText().equals("X") || butArray[r1][c1].getText().equals("O")) {
                                        count++;

                                    }
                                }
                            }
                            if (count == 9) {
                                ResultDisplay.setText("Tie!");
                                Over();
                            }
                        }
                        if (!gameOver) {
                            int temp[] = getPlace();
                            int RCord = temp[0];
                            int CCord = temp[1];
                            butArray[RCord][CCord].setText("O");
                            moves++;
                            butArray[RCord][CCord].setEnabled(false);
                            int y = checkWin();
                            if (y == 1) {
                                ResultDisplay.setText("X win");
                                Over();
                            }
                            if (y == 2) {
                                ResultDisplay.setText("O win");
                                Over();
                            }
                            if (y == 0) {
                                int count = 0;
                                for (int r1 = 0; r1 < 3; r1++) {
                                    for (int c1 = 0; c1 < 3; c1++) {
                                        if (butArray[r1][c1].getText().equals("X") || butArray[r1][c1].getText().equals("O")) {
                                            count++;

                                        }
                                    }
                                }
                                if (count == 9) {
                                    ResultDisplay.setText("Tie!");
                                    Over();
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public int[] getPlace() {
        int[] coordinates = new int[2];
        for (int r = 0; r < 3; r++) { //Horizontal win for X
///////////////////////WIN O
            if (butArray[r][0].getText().equals("O") && butArray[r][1].getText().equals("O") && butArray[r][2].getText().equals(" ")) {
                coordinates[0] = r;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[r][0].getText().equals("O") && butArray[r][1].getText().equals(" ") && butArray[r][2].getText().equals("O")) {
                coordinates[0] = r;
                coordinates[1] = 1;
                return coordinates;
            }
            if (butArray[r][0].getText().equals(" ") && butArray[r][1].getText().equals("O") && butArray[r][2].getText().equals("O")) {
                coordinates[0] = r;
                coordinates[1] = 0;
                return coordinates;
            }
        }
        for (int c = 0; c < 3; c++) { //Vertical win for O

            if (butArray[0][c].getText().equals("O") && butArray[1][c].getText().equals("O") && butArray[2][c].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = c;
                return coordinates;
            }
            if (butArray[0][c].getText().equals("O") && butArray[1][c].getText().equals(" ") && butArray[2][c].getText().equals("O")) {
                coordinates[0] = 1;
                coordinates[1] = c;
                return coordinates;
            }
            if (butArray[0][c].getText().equals(" ") && butArray[1][c].getText().equals("O") && butArray[2][c].getText().equals("O")) {
                coordinates[0] = 0;
                coordinates[1] = c;
                return coordinates;
            }
        }
        if (butArray[0][0].getText().equals("O") && butArray[1][1].getText().equals("O") && butArray[2][2].getText().equals(" ")) { //diagonal 1 for O
            coordinates[0] = 2;
            coordinates[1] = 2;
            return coordinates;

        }
        if (butArray[0][0].getText().equals("O") && butArray[1][1].getText().equals(" ") && butArray[2][2].getText().equals("O")) { //diagonal 1 for O
            coordinates[0] = 1;
            coordinates[1] = 1;
            return coordinates;

        }
        if (butArray[0][0].getText().equals(" ") && butArray[1][1].getText().equals("O") && butArray[2][2].getText().equals("O")) { //diagonal 1 for O
            coordinates[0] = 0;
            coordinates[1] = 0;
            return coordinates;

        }
        if (butArray[0][2].getText().equals("O") && butArray[1][1].getText().equals("O") && butArray[2][0].getText().equals(" ")) { //diagonal 2 for O
            coordinates[0] = 2;
            coordinates[1] = 0;
            return coordinates;
        }
        if (butArray[0][2].getText().equals("O") && butArray[1][1].getText().equals(" ") && butArray[2][0].getText().equals("O")) { //diagonal 2 for O
            coordinates[0] = 1;
            coordinates[1] = 1;
            return coordinates;
        }
        if (butArray[0][2].getText().equals(" ") && butArray[1][1].getText().equals("O") && butArray[2][0].getText().equals("O")) { //diagonal 2 for O
            coordinates[0] = 0;
            coordinates[1] = 2;
            return coordinates;
        }

        ///////////////////////////////////////////////////Block X
        for (int r = 0; r < 3; r++) { //Horizontal win for X

            if (butArray[r][0].getText().equals("X") && butArray[r][1].getText().equals("X") && butArray[r][2].getText().equals(" ")) {
                coordinates[0] = r;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[r][0].getText().equals("X") && butArray[r][1].getText().equals(" ") && butArray[r][2].getText().equals("X")) {
                coordinates[0] = r;
                coordinates[1] = 1;
                return coordinates;
            }
            if (butArray[r][0].getText().equals(" ") && butArray[r][1].getText().equals("X") && butArray[r][2].getText().equals("X")) {
                coordinates[0] = r;
                coordinates[1] = 0;
                return coordinates;
            }
        }
        for (int c = 0; c < 3; c++) { //Vertical win for X

            if (butArray[0][c].getText().equals("X") && butArray[1][c].getText().equals("X") && butArray[2][c].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = c;
                return coordinates;
            }
            if (butArray[0][c].getText().equals("X") && butArray[1][c].getText().equals(" ") && butArray[2][c].getText().equals("X")) {
                coordinates[0] = 1;
                coordinates[1] = c;
                return coordinates;
            }
            if (butArray[0][c].getText().equals(" ") && butArray[1][c].getText().equals("X") && butArray[2][c].getText().equals("X")) {
                coordinates[0] = 0;
                coordinates[1] = c;
                return coordinates;
            }
        }
        if (butArray[0][0].getText().equals("X") && butArray[1][1].getText().equals("X") && butArray[2][2].getText().equals(" ")) { //diagonal 1 for X
            coordinates[0] = 2;
            coordinates[1] = 2;
            return coordinates;

        }
        if (butArray[0][0].getText().equals("X") && butArray[1][1].getText().equals(" ") && butArray[2][2].getText().equals("X")) { //diagonal 1 for X
            coordinates[0] = 1;
            coordinates[1] = 1;
            return coordinates;

        }
        if (butArray[0][0].getText().equals(" ") && butArray[1][1].getText().equals("X") && butArray[2][2].getText().equals("X")) { //diagonal 1 for X
            coordinates[0] = 0;
            coordinates[1] = 0;
            return coordinates;

        }
        if (butArray[0][2].getText().equals("X") && butArray[1][1].getText().equals("X") && butArray[2][0].getText().equals(" ")) { //diagonal 2 for X
            coordinates[0] = 2;
            coordinates[1] = 0;
            return coordinates;
        }
        if (butArray[0][2].getText().equals("X") && butArray[1][1].getText().equals(" ") && butArray[2][0].getText().equals("X")) { //diagonal 2 for X
            coordinates[0] = 1;
            coordinates[1] = 1;
            return coordinates;
        }
        if (butArray[0][2].getText().equals(" ") && butArray[1][1].getText().equals("X") && butArray[2][0].getText().equals("X")) { //diagonal 2 for X
            coordinates[0] = 0;
            coordinates[1] = 2;
            return coordinates;
        }
        if (start % 2 == 1) { //different strategy when going first vs second
            /////////special cases
            if (butArray[0][0].getText().equals("O") && butArray[0][1].getText().equals("X") && butArray[0][2].getText().equals("O") && butArray[1][2].getText().equals("X") && butArray[2][0].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[0][0].getText().equals("O") && butArray[2][0].getText().equals("O") && butArray[2][2].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[0][0].getText().equals("O") && butArray[0][2].getText().equals("O") && butArray[2][2].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
            }

            if (butArray[0][0].getText().equals("O") && butArray[1][1].getText().equals("X") && butArray[0][1].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[0][0].getText().equals("O") && butArray[0][1].getText().equals("X") && butArray[2][0].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[0][0].getText().equals("O") && butArray[1][0].getText().equals("X") && butArray[0][2].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 2;
                return coordinates;
            }
            ///////Goes to Corners if open
            if (butArray[0][0].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 0;
                return coordinates;
            }

            if (butArray[0][2].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[2][0].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[2][2].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
            }

            //////////////////////////Tells it to go middle
            if (butArray[1][1].getText().equals(" ")) {
                coordinates[0] = 1;
                coordinates[1] = 1;
                return coordinates;
            }
            ///sides re llow priority
            if (butArray[1][0].getText().equals(" ")) {
                coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[1][2].getText().equals(" ")) {
                coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[0][1].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 1;
                return coordinates;
            }
            if (butArray[2][1].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
            }
            //going first
        } else {
              if (butArray[1][1].getText().equals(" ")) { //strategy when going second
                coordinates[0] = 1;
                coordinates[1] = 1;
                return coordinates;
            }
             if (butArray[0][0].getText().equals("X") && butArray[2][2].getText().equals("X") && butArray[1][1].getText().equals("O")) {
                if(butArray[1][0].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
                }
                if(butArray[1][2].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
                }
                if(butArray[0][1].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
                }
                if(butArray[2][1].getText().equals(" ")){
                     coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
                }
                
            }
               if (butArray[0][2].getText().equals("X") && butArray[2][0].getText().equals("X") && butArray[1][1].getText().equals("O")) {
                if(butArray[1][0].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
                }
                if(butArray[1][2].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
                }
                if(butArray[0][1].getText().equals(" ")){
                     coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
                }
                if(butArray[2][1].getText().equals(" ")){
                     coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
                }
                
            }
                   if (butArray[2][1].getText().equals("X") && butArray[1][2].getText().equals("X") && butArray[1][1].getText().equals("O")&& butArray[2][2].getText().equals(" ")) {
                       coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
                   }
            ///////Goes to Corners if open
            if (butArray[0][0].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 0;
                return coordinates;
            }

            if (butArray[0][2].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[2][0].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[2][2].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
            }

            if (butArray[1][0].getText().equals(" ")) { //sides more important when going second
                coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
            }
            if (butArray[1][2].getText().equals(" ")) {
                coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
            }
            if (butArray[0][1].getText().equals(" ")) {
                coordinates[0] = 0;
                coordinates[1] = 1;
                return coordinates;
            }
            if (butArray[2][1].getText().equals(" ")) {
                coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
            } 
         
        }

        return coordinates;
    }

    public void Over() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                butArray[r][c].setEnabled(false);
            }
        }
        start++;
        gameOver = true;
        moves = start;
    }

    public int checkWin() {
        for (int r = 0; r < 3; r++) { //Horizontal win for X

            if (butArray[r][0].getText().equals("X") && butArray[r][1].getText().equals("X") && butArray[r][2].getText().equals("X")) {
                return 1;

            }
        }
        for (int r = 0; r < 3; r++) { //Horizontal win for O

            if (butArray[r][0].getText().equals("O") && butArray[r][1].getText().equals("O") && butArray[r][2].getText().equals("O")) {
                return 2;

            }
        }
        for (int c = 0; c < 3; c++) { //Vertical win for X

            if (butArray[0][c].getText().equals("X") && butArray[1][c].getText().equals("X") && butArray[2][c].getText().equals("X")) {
                return 1;

            }
        }
        for (int c = 0; c < 3; c++) { //Vertical win for O

            if (butArray[0][c].getText().equals("O") && butArray[1][c].getText().equals("O") && butArray[2][c].getText().equals("O")) {
                return 2;

            }
        }

        if (butArray[0][0].getText().equals("X") && butArray[1][1].getText().equals("X") && butArray[2][2].getText().equals("X")) { //diagonal 1 for X
            return 1;

        }

        if (butArray[0][0].getText().equals("O") && butArray[1][1].getText().equals("O") && butArray[2][2].getText().equals("O")) { //diagonal 1 for O
            return 2;

        }
        if (butArray[0][2].getText().equals("X") && butArray[1][1].getText().equals("X") && butArray[2][0].getText().equals("X")) { //diagonal 2 for X
            return 1;

        }
        if (butArray[0][2].getText().equals("O") && butArray[1][1].getText().equals("O") && butArray[2][0].getText().equals("O")) { //diagonal 2 for O
            return 2;

        }

        return 0; //if tie
    }
}
