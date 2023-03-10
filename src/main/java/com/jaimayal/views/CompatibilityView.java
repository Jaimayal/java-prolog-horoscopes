package com.jaimayal.views;

import com.jaimayal.controllers.CompatibilityController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CompatibilityView extends JFrame {
    private final CompatibilityController compatibilityController;
    private final JScrollPane mainScrollPane;
    private final JButton compatiblityButton;
    private final JButton backButton;
    private final JTextArea compatibilityResultsArea;
    private final JLabel horoscopeLabel;
    private final JFormattedTextField horoscopeField;
    
    
    public CompatibilityView() {
        super("Compatibility");
        this.compatibilityController = new CompatibilityController();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        
        this.mainScrollPane = new JScrollPane();
        this.compatibilityResultsArea = new JTextArea();
        this.initializeCompatibilityResultsArea();
        this.getContentPane().add(this.mainScrollPane);
        
        this.compatiblityButton = new JButton();
        this.initializeCompatibilityButton();
        this.getContentPane().add(this.compatiblityButton);
        
        this.backButton = new JButton();
        this.initializeBackButton();
        this.getContentPane().add(this.backButton);
        
        this.horoscopeLabel = new JLabel();
        this.initializeHoroscopeLabel();
        this.getContentPane().add(this.horoscopeLabel);
        
        this.horoscopeField = new JFormattedTextField();
        this.initializeHoroscopeFormattedTextField();
        this.getContentPane().add(this.horoscopeField);
        
        this.pack();
        this.setVisible(true);
    }
    
    private void initializeCompatibilityResultsArea() {
        this.compatibilityResultsArea.setColumns(20);
        this.compatibilityResultsArea.setRows(5);
        this.mainScrollPane.setViewportView(this.compatibilityResultsArea);
        this.mainScrollPane.setBounds(320, 220, 310, 90);
    }
    
    private void initializeCompatibilityButton() {
        this.compatiblityButton.setBackground(new Color(255, 204, 255));
        this.compatiblityButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.compatiblityButton.setText("Ver");
        this.compatiblityButton.setBounds(170, 270, 100, 30);
        this.compatiblityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compatibilityButtonTriggered();
            }
        });
    }

    private void compatibilityButtonTriggered() {
        String horoscope = this.horoscopeField.getText();
        System.out.println(horoscope);
        String compatibility = this.compatibilityController.getCompatibility(horoscope);
        System.out.println(compatibility);
        this.compatibilityResultsArea.setText(compatibility);
    }
    
    private void initializeBackButton() {
        this.backButton.setBackground(new Color(255, 255, 255));
        this.backButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.backButton.setForeground(new Color(204, 0, 204));
        this.backButton.setText("Inicio");
        this.backButton.setBounds(140, 180, 140, 30);
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonTriggered();
            }
        });
    }
    
    private void backButtonTriggered() {
        this.dispose();
        System.out.println("Back button triggered");
    }
    
    private void initializeHoroscopeFormattedTextField() {
        this.horoscopeField.setBounds(140, 220, 140, 30);
        this.horoscopeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                horoscopeFieldKeyTyped(e);
            }
        });
    }
    
    private void horoscopeFieldKeyTyped(KeyEvent e) {
        char userInput = e.getKeyChar();
        if (Character.isDigit(userInput)) {
            e.consume();
        }
    }
    
    private void initializeHoroscopeLabel() {
        this.horoscopeLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.horoscopeLabel.setForeground(new Color(255, 255, 255));
        this.horoscopeLabel.setText("Escribe tu horoscopo:");
        this.horoscopeLabel.setBounds(20, 220, 160, 30);
    }

    public static void main(String[] args) {
        new CompatibilityView();
    }
}
