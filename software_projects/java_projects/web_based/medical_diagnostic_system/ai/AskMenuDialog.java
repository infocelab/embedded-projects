
//Title:        Amzi! IDE
//Version:
//Copyright:    Copyright (c) 1999
//Author:       Mary
//Company:      Amzi!
//Description:

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;

/**
 This program has been solely programmed for an AI project and not meant for any business means.
 If you intend to you the code please do so freely on condition you acknowledge us.
 Created by Group 13 - CyberVision softwares.
 The ODBC datasource name is AI please do not forget to set that before running then program.
 Please do not hesitate to submit any bug to us.
 you can mail us on dh002211@ex.apiit.edu.my

 @author Asrar Ahmed Makrani
 @version 1.4.0 build 3
 */

public class AskMenuDialog extends JDialog
{
   JTextArea promptTextArea;
   JButton okButton = new JButton();
   JButton stopButton = new JButton();
   JPanel buttonPanel = new JPanel();
   JPanel formPanel = new JPanel();
   JList menuList;
   JScrollPane menuScroller = new JScrollPane();
   JScrollPane promptScroller = new JScrollPane();
   JLabel selectLabel = new JLabel();
   GridBagLayout gbl = new GridBagLayout();
   boolean oneAnswer;
   boolean stopRun;
   JFrame app;

   public AskMenuDialog(JFrame app, String title, String prompt, Vector menu, boolean oneAnswer)
   {
      super(app, title, true);
      try
      {
         this.setTitle(title);
         this.oneAnswer = oneAnswer;
         this.app = app;
         this.getContentPane().setLayout(new BorderLayout());
         formPanel.setLayout(new BorderLayout());
         promptTextArea = new JTextArea(prompt);
         promptTextArea.setColumns(30);
         menuList = new JList(menu);
/*         if (menu.size() > 20)
            menuList.setVisibleRowCount(20);
         else
            menuList.setVisibleRowCount(menu.size());
*/
         if (menu.size() < 20)
            menuList.setVisibleRowCount(menu.size());
         if (oneAnswer)
         {
            selectLabel.setText("Select one of the following:");
            menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         }
         else
         {
            selectLabel.setText("Select any number of the following:");
            menuList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         }
         jbInit();
         menuList.setSelectedIndex(0);
         menuList.requestFocus();
         pack();
         Dimension ps = this.getPreferredSize();
         this.setSize(ps);
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }

   void jbInit() throws Exception
   {
      this.getContentPane().setLayout(new BorderLayout());

      this.getRootPane().setDefaultButton(okButton);
      okButton.setText("OK");
      okButton.setMnemonic(KeyEvent.VK_ENTER);
      okButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            okButton_actionPerformed(e);
         }
      });
      stopButton.setText("Stop Run");
      stopButton.setMnemonic(KeyEvent.VK_S);
      stopButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            stopButton_actionPerformed(e);
         }
      });
      buttonPanel.add(okButton, null);
      buttonPanel.add(stopButton, null);

      promptTextArea.setLineWrap(true);
      promptTextArea.setWrapStyleWord(true);
      promptTextArea.setBorder(BorderFactory.createRaisedBevelBorder());
      promptTextArea.setEditable(false);
      promptTextArea.setRequestFocusEnabled(false);
      promptScroller.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
      promptScroller.getViewport().add(promptTextArea, null);
      menuScroller.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
      menuScroller.getViewport().add(menuList, null);

      formPanel.add(promptScroller, BorderLayout.NORTH);
      formPanel.add(selectLabel, BorderLayout.CENTER);
      formPanel.add(menuScroller, BorderLayout.SOUTH);
      formPanel.setBorder(BorderFactory.createRaisedBevelBorder());

      this.getContentPane().add(formPanel, BorderLayout.NORTH);
      this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
   }

   public String getSelectedValue()
   {
      if (menuList.isSelectionEmpty())
         return null;
      else
         return menuList.getSelectedValue().toString();
   }

   public Vector getSelectedValues()
   {
      Object[] facts = menuList.getSelectedValues();
      Vector v = new Vector();
      for (int i = 0 ; i < facts.length ; i++)
         v.addElement((String)facts[i]);
      return v;
   }

   public boolean getStopRun()
   {
      return stopRun;
   }

   void okButton_actionPerformed(ActionEvent e)
   {
      stopRun = false;
      if (!menuList.isSelectionEmpty())
         hide();
   }

   void stopButton_actionPerformed(ActionEvent e)
   {
      stopRun = true;
      menuList.clearSelection();
      hide();
   }

}

