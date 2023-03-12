package com.jaimayal.views;

import com.jaimayal.controllers.HoroscopeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoroscopeShowcaseView extends JFrame {
    
    private HoroscopeController horoscopeController;
    private JTextArea horoscopeTextArea;
    private JScrollPane horoscopeTextPane;
    private JScrollPane compatibilityTextPane;
    private JTextArea compatibilityTextArea;
    
    private JFormattedTextField dayInputArea;
    private JFormattedTextField monthInputArea;
    private JTextArea horoscopeDetailsTextArea;
    private JScrollPane horoscopeTextPaneResult;
    private JLabel horoscopeLabel;
    private JLabel monthLabel;
    private JLabel compatibilityLabel;
    private JLabel horoscopeSignLabel;
    private JLabel dayLabel;
    private JLabel image;
    private JButton calaculateEverythingButton;
    private JButton returnHomeButton;
    
    public HoroscopeShowcaseView() {
        super("Obten tu todo");
        this.horoscopeController = new HoroscopeController();
        this.horoscopeTextPane = new JScrollPane();
        this.horoscopeTextArea = new JTextArea();
        this.compatibilityTextPane = new JScrollPane();
        this.compatibilityTextArea = new JTextArea();
        this.dayInputArea = new JFormattedTextField();
        this.monthInputArea = new JFormattedTextField();
        this.horoscopeTextPaneResult = new JScrollPane();
        this.horoscopeDetailsTextArea = new JTextArea();
        this.horoscopeLabel = new JLabel();
        this.monthLabel = new JLabel();
        this.compatibilityLabel = new JLabel();
        this.dayLabel = new JLabel();
        this.image = new JLabel();
        this.horoscopeSignLabel = new JLabel();
        this.calaculateEverythingButton = new JButton();
        this.returnHomeButton = new JButton();
        
        this.setSize(680, 530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.display();
        this.getContentPane().setLayout(null);
        this.setVisible(true);
    }
    
    private void display() {
        this.horoscopeTextArea.setColumns(20);
        this.horoscopeTextArea.setRows(5);
        this.horoscopeTextPane.setViewportView(this.horoscopeTextArea);
        this.horoscopeTextPane.setBounds(30, 300, 200, 50);
        this.getContentPane().add(this.horoscopeTextPane);

        this.compatibilityTextArea.setColumns(20);
        this.compatibilityTextArea.setRows(5);
        this.compatibilityTextPane.setViewportView(this.compatibilityTextArea);
        this.compatibilityTextPane.setBounds(320, 260, 290, 50);
        this.getContentPane().add(this.compatibilityTextPane);
        
        this.getContentPane().add(this.dayInputArea);
        this.dayInputArea.setBounds(100, 100, 70, 30);
        
        this.getContentPane().add(this.monthInputArea);
        this.monthInputArea.setBounds(100, 140, 70, 30);

        this.horoscopeDetailsTextArea.setColumns(20);
        this.horoscopeDetailsTextArea.setRows(5);
        this.horoscopeTextPaneResult.setViewportView(this.horoscopeDetailsTextArea);

        this.getContentPane().add(this.horoscopeTextPaneResult);
        this.horoscopeTextPaneResult.setBounds(240, 330, 380, 120);

        this.horoscopeLabel.setFont(new Font("Rockwell", 1, 36));
        this.horoscopeLabel.setForeground(new Color(0, 0, 0));
        this.horoscopeLabel.setText("Horóscopo");
        this.getContentPane().add(this.horoscopeLabel);
        this.horoscopeLabel.setBounds(30, 370, 200, 40);

        this.monthLabel.setFont(new Font("Rockwell", 1, 24)); // NOI18N
        this.monthLabel.setForeground(new Color(0, 0, 0));
        this.monthLabel.setText("Mes:");
        getContentPane().add(this.monthLabel);
        this.monthLabel.setBounds(30, 130, 70, 40);

        this.compatibilityLabel.setFont(new Font("Rockwell", 1, 36)); // NOI18N
        this.compatibilityLabel.setForeground(new Color(0, 0, 0));
        this.compatibilityLabel.setText("Compatibilidad");
        getContentPane().add(this.compatibilityLabel);
        this.compatibilityLabel.setBounds(300, 210, 320, 40);

        this.horoscopeSignLabel.setFont(new Font("Rockwell", 1, 36)); // NOI18N
        this.horoscopeSignLabel.setForeground(new Color(0, 0, 0));
        this.horoscopeSignLabel.setText("Signo");
        this.getContentPane().add(this.horoscopeLabel);
        this.horoscopeSignLabel.setBounds(50, 250, 140, 40);

        this.dayLabel.setFont(new Font("Rockwell", 1, 24)); // NOI18N
        this.dayLabel.setForeground(new Color(0, 0, 0));
        this.dayLabel.setText("Dia:");
        this.getContentPane().add(this.dayLabel);
        this.dayLabel.setBounds(40, 90, 70, 40);
        this.getContentPane().add(this.image);
        this.image.setBounds(500, 14, 120, 170);

        this.calaculateEverythingButton.setBackground(new Color(102, 255, 255));
        this.calaculateEverythingButton.setFont(new Font("Rockwell", 1, 18)); // NOI18N
        this.calaculateEverythingButton.setText("Dime todo");
        this.calaculateEverythingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calculateEverythingTrigger(evt);
            }
        });
        this.getContentPane().add(this.calaculateEverythingButton);
        this.calaculateEverythingButton.setBounds(210, 120, 150, 40);

        this.returnHomeButton.setFont(new Font("Rockwell", 1, 18)); // NOI18N
        this.returnHomeButton.setText("Inicio");
        this.returnHomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                returnHomeTrigger(evt);
            }
        });
        this.getContentPane().add(this.returnHomeButton);
        this.returnHomeButton.setBounds(210, 70, 140, 30);
    }
    
    private void calculateEverythingTrigger(ActionEvent evt) {
        String day = this.dayInputArea.getText();
        String month = this.monthInputArea.getText();
        
        String horoscope = this.horoscopeController.calculateHoroscope(day, month);
        String compatibility = this.horoscopeController.getCompatibility(horoscope);
        String sign = this.horoscopeController.calculateHoroscope(day, month);
        String horoscopeDetails = this.horoscopeController.getHoroscopeDetails(horoscope);
    
        this.horoscopeTextArea.setText(horoscope);
        this.compatibilityTextArea.setText(compatibility);
        this.horoscopeDetailsTextArea.setText(horoscopeDetails);
        this.horoscopeSignLabel.setText(sign);
    }
    
    private void returnHomeTrigger(ActionEvent evt) {
        this.dispose();
        HomeView homeView = new HomeView();
        homeView.setLocationRelativeTo(this);
    }

    public static void main(String[] args) {
        HoroscopeShowcaseView horoscopeShowcaseView = new HoroscopeShowcaseView();
        
    }
}
