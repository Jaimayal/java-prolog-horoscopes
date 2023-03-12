package com.jaimayal.views;

import com.jaimayal.controllers.HoroscopeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CompatibilityView extends JFrame {
    private final HoroscopeController compatibilityController;
    private final JScrollPane mainScrollPane;
    private final JButton compatiblityButton;
    private final JButton backButton;
    private final JTextArea compatibilityResultsArea;
    private final JLabel horoscopeLabel;
    private final JFormattedTextField horoscopeField;
    
    
    public CompatibilityView() {
        super("Compatibility");
        this.compatibilityController = new HoroscopeController();
        
        this.mainScrollPane = new JScrollPane();
        this.compatibilityResultsArea = new JTextArea();
        this.compatiblityButton = new JButton();
        this.backButton = new JButton();
        this.horoscopeLabel = new JLabel();
        this.horoscopeField = new JFormattedTextField();

        this.setSize(680, 530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.display();
        this.getContentPane().setLayout(null);
        this.setVisible(true);
    }
    
    private void display() {
        this.initializeBackButton();
        this.initializeCompatibilityButton();
        this.initializeCompatibilityResultsArea();
        this.initializeHoroscopeFormattedTextField();
        this.initializeHoroscopeLabel();
    }
    
    private void initializeCompatibilityResultsArea() {
        this.compatibilityResultsArea.setColumns(20);
        this.compatibilityResultsArea.setRows(5);
        this.mainScrollPane.setViewportView(this.compatibilityResultsArea);
        this.mainScrollPane.setBounds(340, 220, 310, 90);
        this.add(this.mainScrollPane);
    }
    
    private void initializeCompatibilityButton() {
        this.compatiblityButton.setBackground(new Color(255, 204, 255));
        this.compatiblityButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.compatiblityButton.setText("Ver");
        this.compatiblityButton.setBounds(180, 270, 100, 30);
        this.compatiblityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compatibilityButtonTriggered();
            }
        });
        this.add(this.compatiblityButton);
    }

    private void compatibilityButtonTriggered() {
        String horoscope = this.horoscopeField.getText();
        System.out.println(horoscope);
        String compatibility = this.compatibilityController.getCompatibility(horoscope);
        System.out.println(compatibility);
        this.compatibilityResultsArea.setText(compatibility);
        this.add(this.mainScrollPane);
    }
    
    private void initializeBackButton() {
        this.backButton.setBackground(new Color(255, 255, 255));
        this.backButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.backButton.setForeground(new Color(204, 0, 204));
        this.backButton.setText("Inicio");
        this.backButton.setBounds(180, 180, 140, 30);
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonTriggered();
            }
        });
        this.add(this.backButton);
    }
    
    private void backButtonTriggered() {
        this.dispose();
        HomeView homeView = new HomeView();
        homeView.setLocationRelativeTo(this);
    }
    
    private void initializeHoroscopeFormattedTextField() {
        this.horoscopeField.setBounds(180, 220, 140, 30);
        this.horoscopeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                horoscopeFieldKeyTyped(e);
            }
        });
        this.add(this.horoscopeField);
    }
    
    private void horoscopeFieldKeyTyped(KeyEvent e) {
        char userInput = e.getKeyChar();
        if (Character.isDigit(userInput)) {
            e.consume();
        }
    }
    
    private void initializeHoroscopeLabel() {
        this.horoscopeLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.horoscopeLabel.setForeground(new Color(0, 0, 0));
        this.horoscopeLabel.setText("Escribe tu horoscopo:");
        this.horoscopeLabel.setBounds(20, 220, 160, 30);
        this.add(this.horoscopeLabel);
    }
}
