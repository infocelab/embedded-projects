package connect;

public class calculator extends javax.swing.JFrame {

    double firstnum, secondnum,result;
    int plusclicked, minusclicked,multiplyclicked, devideclicked,x2clicked,percentclicked,powerclicked,devidebyclicked,sqrtclicked,inverseclicked;
    
    public calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_calculator_7 = new javax.swing.JButton();
        btn_calculator_8 = new javax.swing.JButton();
        btn_calculator_9 = new javax.swing.JButton();
        btn_calculator_4 = new javax.swing.JButton();
        btn_calculator_5 = new javax.swing.JButton();
        btn_calculator_6 = new javax.swing.JButton();
        btn_calculator_1 = new javax.swing.JButton();
        btn_calculator_2 = new javax.swing.JButton();
        btn_calculator_3 = new javax.swing.JButton();
        btn_calculator_0 = new javax.swing.JButton();
        btn_calculator_point = new javax.swing.JButton();
        btn_calculator_multiplication = new javax.swing.JButton();
        btn_calculator_substract = new javax.swing.JButton();
        btn_calculator_add = new javax.swing.JButton();
        btn_calculator_division = new javax.swing.JButton();
        btn_calculator_equal = new javax.swing.JButton();
        btn_calculator_clear = new javax.swing.JButton();
        txt_calculator = new javax.swing.JTextField();
        btn_calculator_cancel = new javax.swing.JButton();
        btn_calculator_x2 = new javax.swing.JButton();
        btn_calculator_percent = new javax.swing.JButton();
        btn_calculator_x_pow_n = new javax.swing.JButton();
        btn_calculator_sqrt = new javax.swing.JButton();
        btn_calculator_inverse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 365, 460));
        setMaximumSize(new java.awt.Dimension(357, 453));

        jPanel1.setBackground(new java.awt.Color(112, 152, 93));

        btn_calculator_7.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_7.setText("7");
        btn_calculator_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_7ActionPerformed(evt);
            }
        });

        btn_calculator_8.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_8.setText("8");
        btn_calculator_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_8ActionPerformed(evt);
            }
        });

        btn_calculator_9.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_9.setText("9");
        btn_calculator_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_9ActionPerformed(evt);
            }
        });

        btn_calculator_4.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_4.setText("4");
        btn_calculator_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_4ActionPerformed(evt);
            }
        });

        btn_calculator_5.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_5.setText("5");
        btn_calculator_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_5ActionPerformed(evt);
            }
        });

        btn_calculator_6.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_6.setText("6");
        btn_calculator_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_6ActionPerformed(evt);
            }
        });

        btn_calculator_1.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_1.setText("1");
        btn_calculator_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_1ActionPerformed(evt);
            }
        });

        btn_calculator_2.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_2.setText("2");
        btn_calculator_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_2ActionPerformed(evt);
            }
        });

        btn_calculator_3.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_3.setText("3");
        btn_calculator_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_3ActionPerformed(evt);
            }
        });

        btn_calculator_0.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_0.setText("0");
        btn_calculator_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_0ActionPerformed(evt);
            }
        });

        btn_calculator_point.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_point.setText(".");
        btn_calculator_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_pointActionPerformed(evt);
            }
        });

        btn_calculator_multiplication.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_multiplication.setText("*");
        btn_calculator_multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_multiplicationActionPerformed(evt);
            }
        });

        btn_calculator_substract.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_substract.setText("-");
        btn_calculator_substract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_substractActionPerformed(evt);
            }
        });

        btn_calculator_add.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_add.setText("+");
        btn_calculator_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_addActionPerformed(evt);
            }
        });

        btn_calculator_division.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_division.setText("/");
        btn_calculator_division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_divisionActionPerformed(evt);
            }
        });

        btn_calculator_equal.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_equal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_calculator_equal.setText("=");
        btn_calculator_equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_equalActionPerformed(evt);
            }
        });

        btn_calculator_clear.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_clear.setText("Clear");
        btn_calculator_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_clearActionPerformed(evt);
            }
        });

        txt_calculator.setBackground(new java.awt.Color(117, 207, 207));
        txt_calculator.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_calculator.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btn_calculator_cancel.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_cancel.setText("Cancel");
        btn_calculator_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_cancelActionPerformed(evt);
            }
        });

        btn_calculator_x2.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_x2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_calculator_x2.setText("x2");
        btn_calculator_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_x2ActionPerformed(evt);
            }
        });

        btn_calculator_percent.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_percent.setText("%");
        btn_calculator_percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_percentActionPerformed(evt);
            }
        });

        btn_calculator_x_pow_n.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_x_pow_n.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_calculator_x_pow_n.setText("X^n");
        btn_calculator_x_pow_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_x_pow_nActionPerformed(evt);
            }
        });

        btn_calculator_sqrt.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_sqrt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_calculator_sqrt.setText("sqrt");
        btn_calculator_sqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_sqrtActionPerformed(evt);
            }
        });

        btn_calculator_inverse.setBackground(new java.awt.Color(75, 138, 169));
        btn_calculator_inverse.setText("1/x");
        btn_calculator_inverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculator_inverseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_calculator_1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(btn_calculator_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_calculator_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_calculator_3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_calculator_substract, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_calculator_percent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_calculator_7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_calculator_8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_calculator_4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_calculator_point, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_calculator_5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_calculator_6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_calculator_multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_calculator_9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_calculator_division, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_calculator_x_pow_n, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_calculator_x2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_calculator_add, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_calculator_inverse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_calculator_sqrt))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_calculator_clear)
                                .addGap(36, 36, 36)
                                .addComponent(btn_calculator_cancel)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_calculator)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_calculator_equal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calculator_clear)
                    .addComponent(btn_calculator_cancel))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calculator_8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_division, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calculator_4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_x_pow_n, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calculator_3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_substract, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculator_percent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_calculator_sqrt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_calculator_0, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_calculator_point, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_calculator_add, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_calculator_inverse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_calculator_equal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 44, 174));
        jLabel1.setText("Calculator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calculator_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_0ActionPerformed
         txt_calculator.setText(txt_calculator.getText()+btn_calculator_0.getText());
    }//GEN-LAST:event_btn_calculator_0ActionPerformed

    private void btn_calculator_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_1ActionPerformed
        txt_calculator.setText(txt_calculator.getText()+btn_calculator_1.getText());
    }//GEN-LAST:event_btn_calculator_1ActionPerformed

    private void btn_calculator_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_2ActionPerformed
        txt_calculator.setText(txt_calculator.getText()+btn_calculator_2.getText());
    }//GEN-LAST:event_btn_calculator_2ActionPerformed

    private void btn_calculator_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_3ActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_3.getText());
    }//GEN-LAST:event_btn_calculator_3ActionPerformed

    private void btn_calculator_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_4ActionPerformed
        txt_calculator.setText(txt_calculator.getText()+btn_calculator_4.getText());
    }//GEN-LAST:event_btn_calculator_4ActionPerformed

    private void btn_calculator_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_5ActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_5.getText());
    }//GEN-LAST:event_btn_calculator_5ActionPerformed

    private void btn_calculator_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_6ActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_6.getText());
    }//GEN-LAST:event_btn_calculator_6ActionPerformed

    private void btn_calculator_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_7ActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_7.getText());
    }//GEN-LAST:event_btn_calculator_7ActionPerformed

    private void btn_calculator_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_8ActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_8.getText());
    }//GEN-LAST:event_btn_calculator_8ActionPerformed

    private void btn_calculator_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_9ActionPerformed
     txt_calculator.setText(txt_calculator.getText()+btn_calculator_9.getText());
    }//GEN-LAST:event_btn_calculator_9ActionPerformed

    private void btn_calculator_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_pointActionPerformed
       txt_calculator.setText(txt_calculator.getText()+btn_calculator_point.getText());
        
    }//GEN-LAST:event_btn_calculator_pointActionPerformed

    private void btn_calculator_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_clearActionPerformed
        txt_calculator.setText("");
    }//GEN-LAST:event_btn_calculator_clearActionPerformed

    private void btn_calculator_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_cancelActionPerformed
        String text;
        text = txt_calculator.getText();
        int len = text.length();
        text = text.substring(0,len-1);
        txt_calculator.setText(text);
    }//GEN-LAST:event_btn_calculator_cancelActionPerformed

    private void btn_calculator_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_addActionPerformed
      firstnum = Double.parseDouble(txt_calculator.getText());
      txt_calculator.setText("");
      plusclicked =5;
      minusclicked=multiplyclicked=devideclicked=0;
    }//GEN-LAST:event_btn_calculator_addActionPerformed

    private void btn_calculator_equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_equalActionPerformed
        secondnum = Double.parseDouble(txt_calculator.getText());
        if(plusclicked>0)
        {
            result = firstnum + secondnum;
            txt_calculator.setText(String.valueOf(result));
        }else if(minusclicked>0)
        {
            result = firstnum - secondnum;
            txt_calculator.setText(String.valueOf(result));
        }
        else if(multiplyclicked>0)
        {
            result = firstnum * secondnum;
            txt_calculator.setText(String.valueOf(result));
        }
        else if(devideclicked>0)
        {
            result = firstnum / secondnum;
            txt_calculator.setText(String.valueOf(result));
        }
        else if(powerclicked>0)
        {
            result = Math.pow(firstnum, secondnum);
            txt_calculator.setText(String.valueOf(result));
        }
        else if(percentclicked>0)
        {
            result = (firstnum* secondnum)/100;
            txt_calculator.setText(String.valueOf(result));
        }
       
    }//GEN-LAST:event_btn_calculator_equalActionPerformed

    private void btn_calculator_substractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_substractActionPerformed
       
        firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText("");
        minusclicked =3;
        plusclicked=multiplyclicked=devideclicked=0;
       
    }//GEN-LAST:event_btn_calculator_substractActionPerformed

    private void btn_calculator_multiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_multiplicationActionPerformed
        firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText("");
        multiplyclicked =7;
        plusclicked=minusclicked=devideclicked=0;
    }//GEN-LAST:event_btn_calculator_multiplicationActionPerformed

    private void btn_calculator_divisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_divisionActionPerformed
        firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText("");
        devideclicked =9;
        plusclicked=minusclicked=multiplyclicked=0;
    }//GEN-LAST:event_btn_calculator_divisionActionPerformed

    private void btn_calculator_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_x2ActionPerformed
        firstnum = Double.parseDouble(txt_calculator.getText());
        x2clicked =9;
        if(x2clicked>0)
        {
            result = firstnum * firstnum;
            txt_calculator.setText(String.valueOf(result));
        }
     
    }//GEN-LAST:event_btn_calculator_x2ActionPerformed

    private void btn_calculator_percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_percentActionPerformed
        firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText("");
        percentclicked =9;
        plusclicked=minusclicked=multiplyclicked=devideclicked=x2clicked=powerclicked=0;
    }//GEN-LAST:event_btn_calculator_percentActionPerformed

    private void btn_calculator_x_pow_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_x_pow_nActionPerformed
       firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText("");
        powerclicked =9;
        plusclicked=minusclicked=multiplyclicked=devideclicked=x2clicked=0;
    }//GEN-LAST:event_btn_calculator_x_pow_nActionPerformed

    private void btn_calculator_sqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_sqrtActionPerformed
       firstnum = Double.parseDouble(txt_calculator.getText());
       txt_calculator.setText(String.valueOf(Math.sqrt(firstnum)));
    }//GEN-LAST:event_btn_calculator_sqrtActionPerformed

    private void btn_calculator_inverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculator_inverseActionPerformed
        firstnum = Double.parseDouble(txt_calculator.getText());
        txt_calculator.setText(String.valueOf(1/firstnum));
    }//GEN-LAST:event_btn_calculator_inverseActionPerformed

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
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calculator_0;
    private javax.swing.JButton btn_calculator_1;
    private javax.swing.JButton btn_calculator_2;
    private javax.swing.JButton btn_calculator_3;
    private javax.swing.JButton btn_calculator_4;
    private javax.swing.JButton btn_calculator_5;
    private javax.swing.JButton btn_calculator_6;
    private javax.swing.JButton btn_calculator_7;
    private javax.swing.JButton btn_calculator_8;
    private javax.swing.JButton btn_calculator_9;
    private javax.swing.JButton btn_calculator_add;
    private javax.swing.JButton btn_calculator_cancel;
    private javax.swing.JButton btn_calculator_clear;
    private javax.swing.JButton btn_calculator_division;
    private javax.swing.JButton btn_calculator_equal;
    private javax.swing.JButton btn_calculator_inverse;
    private javax.swing.JButton btn_calculator_multiplication;
    private javax.swing.JButton btn_calculator_percent;
    private javax.swing.JButton btn_calculator_point;
    private javax.swing.JButton btn_calculator_sqrt;
    private javax.swing.JButton btn_calculator_substract;
    private javax.swing.JButton btn_calculator_x2;
    private javax.swing.JButton btn_calculator_x_pow_n;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_calculator;
    // End of variables declaration//GEN-END:variables
}
