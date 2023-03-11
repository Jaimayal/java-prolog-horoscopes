package com.jaimayal.views;

import com.jaimayal.controllers.HoroscopeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoroscopeDetailsView extends JFrame {
    
    private final HoroscopeController fullHoroscopeDetailsController;
    private final JButton renderHoroscopeDetailsButton;
    private final JLabel horoscopeLabel;
    private final JButton returnHomeButton;
    private final JScrollPane resultsAreaPane;
    private final JTextArea horoscopeDetailsResultArea;
    private final JFormattedTextField horoscopeInputField;
    
    public HoroscopeDetailsView() {
        super("Tu Horoscopo");
        this.fullHoroscopeDetailsController = new HoroscopeController();
        this.renderHoroscopeDetailsButton = new JButton();
        this.horoscopeLabel = new JLabel();
        this.returnHomeButton = new JButton();
        this.resultsAreaPane = new JScrollPane();
        this.horoscopeDetailsResultArea = new JTextArea();
        this.horoscopeInputField = new JFormattedTextField();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(680, 530);
        this.getContentPane().setLayout(null);
        this.setBackground(new Color(0, 0, 0));
        this.display();
        this.setVisible(true);
    }
    
    private void display() {
        this.initializeHoroscopeInputFieldFormattedTextField();
        this.initializeHoroscopeDetailsResultArea();
        this.initializeHoroscopeLabel();
        this.initializeRenderHoroscopeDetailsButton();
        this.initializeReturnHomeButton();
    }
    
    private void initializeHoroscopeInputFieldFormattedTextField() {
        this.horoscopeInputField.setBounds(180, 240, 150, 40);
        this.add(this.horoscopeInputField);
    }

    private void initializeRenderHoroscopeDetailsButton() {
        this.renderHoroscopeDetailsButton.setBackground(new Color(255, 204, 204));
        this.renderHoroscopeDetailsButton.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.renderHoroscopeDetailsButton.setBounds(340, 240, 110, 40);
        this.renderHoroscopeDetailsButton.setText("Dime");
        this.renderHoroscopeDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                renderHoroscopeDetailsTriggered();
            }
        });
        this.add(this.renderHoroscopeDetailsButton);
    }
    
    private void initializeHoroscopeDetailsResultArea() {
        this.horoscopeDetailsResultArea.setColumns(20);
        this.horoscopeDetailsResultArea.setRows(5);
        this.resultsAreaPane.setViewportView(this.horoscopeDetailsResultArea);
        this.resultsAreaPane.setBounds(150, 300, 300, 170);
        this.add(this.resultsAreaPane);
    }
    
    private void initializeHoroscopeLabel() {
        this.horoscopeLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.horoscopeLabel.setBackground(new Color(255, 255, 255));
        this.horoscopeLabel.setForeground(new Color(255, 255, 255));
        this.horoscopeLabel.setText("Escribe tu signo:");
        this.horoscopeLabel.setBounds(20, 230, 150, 50);
        this.add(this.horoscopeLabel);
    }
    
    private void initializeReturnHomeButton() {
        this.returnHomeButton.setText("Inicio");
        this.returnHomeButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        this.returnHomeButton.setBounds(20, 110, 110, 30);
        this.returnHomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                returnHomeButtonTriggered(evt);
            }
        });
        this.add(this.returnHomeButton);
    }
    
    private void returnHomeButtonTriggered(ActionEvent evt) {
        this.dispose();
        HomeView homeView = new HomeView();
        homeView.setLocationRelativeTo(this);
    }
    
    private void renderHoroscopeDetailsTriggered() {
        String horoscope = this.horoscopeInputField.getText();
        String horoscopeDetails = this.fullHoroscopeDetailsController.getHoroscopeDetails(horoscope);
        this.horoscopeDetailsResultArea.setText(horoscopeDetails);
    }

    public static void main(String[] args) {
        HoroscopeDetailsView horoscopeDetailsView = new HoroscopeDetailsView();
    }
}
