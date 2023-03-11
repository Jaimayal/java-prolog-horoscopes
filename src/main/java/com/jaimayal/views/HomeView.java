package com.jaimayal.views;

import com.jaimayal.controllers.HoroscopeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class HomeView extends JFrame {
    
    private final HoroscopeController homeController;
    private final JTextField dayField;
    private final JTextField monthField;
    private final JLabel dayLabel;
    private final JLabel monthLabel;
    private final JButton calculateHoroscopeButton;
    private final JButton renderCompatibilityViewButton;
    private final JButton renderHoroscopeShowcaseViewButton;
    private final JButton renderFullHoroscopeDetailsViewButton;
    private final JLabel resultHoroscopeLabel;
    
    public HomeView() {
        super("Obten tu Signo");
        this.homeController = new HoroscopeController();
        this.dayField = new JTextField();
        this.monthField = new JTextField();
        this.dayLabel = new JLabel();
        this.monthLabel = new JLabel();
        this.calculateHoroscopeButton = new JButton();
        this.renderCompatibilityViewButton = new JButton();
        this.renderHoroscopeShowcaseViewButton = new JButton();
        this.resultHoroscopeLabel = new JLabel();
        this.renderFullHoroscopeDetailsViewButton = new JButton();
        
        this.setBounds(500, 100, 680, 420);
        this.setSize(1000, 600);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.display();
        this.setVisible(true);
    }
    
    private void display() {
        this.initializeDayField();
        this.initializeMonthField();
        this.initializeDayLabel();
        this.initializeMonthLabel();
        this.initializeCalculateHoroscopeButton();
        this.initializeRenderCompatibilityViewButton();
        this.initializeRenderHoroscopeDetailsViewButton();
        this.initializeResultHoroscopeLabel();
        this.initializeHoroscopeShowcaseViewButton();
    }
    
    private void initializeMonthLabel() {
        this.monthLabel.setText("No. Mes:");
        this.monthLabel.setBounds(30, 300, 110, 30);
        this.monthLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
        this.monthLabel.setForeground(new Color(255, 255, 255));
        this.add(this.monthLabel);
    }
    
    private void initializeDayField() {
        this.dayField.setBounds(30, 300, 110, 30);
        this.dayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dayKeyTyped(evt);
            }
        });
        this.add(this.dayField);
    }
    
    private void initializeMonthField() {
        this.monthField.setBounds(150, 300, 100, 30);
        this.monthField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthKeyTyped(evt);
            }
        });
        this.add(this.monthField);
    }
    
    private void initializeCalculateHoroscopeButton() {
        this.calculateHoroscopeButton.setText("Dime mi signo");
        this.calculateHoroscopeButton.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.calculateHoroscopeButton.setBackground(new Color(255, 255, 255));
        this.calculateHoroscopeButton.setBounds(30, 340, 200, 31);
        this.calculateHoroscopeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateHoroscopeTriggered();
            }
        });
        this.add(this.calculateHoroscopeButton);
    }
    
    private void initializeResultHoroscopeLabel() {
        this.resultHoroscopeLabel.setText("Signo:");
        this.resultHoroscopeLabel.setBounds(250, 330, 300, 40);
        this.resultHoroscopeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
        this.resultHoroscopeLabel.setForeground(new Color(255, 255, 255));
        this.add(this.resultHoroscopeLabel);
    }
    
    private void initializeDayLabel() {
        this.dayLabel.setText("Día:");
        this.dayLabel.setBounds(80, 250, 70, 40);
        this.dayLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
        this.dayLabel.setForeground(new Color(255, 255, 255));
        this.add(this.dayLabel);
    }
    
    private void initializeRenderHoroscopeDetailsViewButton() {
        this.renderHoroscopeShowcaseViewButton.setText("Mi horoscopo");
        this.renderHoroscopeShowcaseViewButton.setBackground(new Color(102, 102, 255));
        this.renderHoroscopeShowcaseViewButton.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.renderHoroscopeShowcaseViewButton.setBounds(420, 13, 210, 30);
        this.renderHoroscopeShowcaseViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderHoroscopeDetailsViewTriggered();
            }
        });
        this.add(this.renderHoroscopeShowcaseViewButton);
    }
    
    private void initializeRenderCompatibilityViewButton() {
        this.renderCompatibilityViewButton.setText("Mi compatibilidad");
        this.renderCompatibilityViewButton.setBackground(new Color(102, 102, 255));
        this.renderCompatibilityViewButton.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.renderCompatibilityViewButton.setBounds(420, 50, 210, 30);
        this.renderCompatibilityViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderCompatibilityViewTriggered();
            }
        });
        this.add(this.renderCompatibilityViewButton);
    }
    
    private void initializeHoroscopeShowcaseViewButton() {
        this.renderFullHoroscopeDetailsViewButton.setText("Dime todo");
        this.renderFullHoroscopeDetailsViewButton.setBackground(new Color(102, 102, 255));
        this.renderFullHoroscopeDetailsViewButton.setFont(new Font("Rockwell", Font.BOLD, 18));
        this.renderFullHoroscopeDetailsViewButton.setBounds(30, 20, 140, 30);
        this.renderFullHoroscopeDetailsViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                renderHoroscopeShowcaseViewTriggered();
            }
        });
        this.add(this.renderFullHoroscopeDetailsViewButton);
    }
    
    private void calculateHoroscopeTriggered() {
        String day = this.dayField.getText();
        String month = this.monthField.getText();
        String horoscope = this.homeController.calculateHoroscope(day, month);
        this.resultHoroscopeLabel.setText(horoscope);
    }
    
    private void renderCompatibilityViewTriggered() {
        CompatibilityView compatibilityView = new CompatibilityView();
        compatibilityView.setLocationRelativeTo(this);
        this.dispose();
    }
    
    private void renderHoroscopeDetailsViewTriggered() {
        HoroscopeDetailsView horoscopeDetailsView = new HoroscopeDetailsView();
        horoscopeDetailsView.setLocationRelativeTo(this);
        this.dispose();
    }
    
    private void renderHoroscopeShowcaseViewTriggered() {
        HoroscopeShowcaseView horoscopeShowcaseView = new HoroscopeShowcaseView();
        horoscopeShowcaseView.setLocationRelativeTo(this);
        this.dispose();
    }
    
    private void monthKeyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String input = this.monthField.getText();
        if (input.length() >= 2) {
            e.consume();
        }
        
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }
    
    private void dayKeyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String input = this.dayField.getText();
        if (input.length() >= 2) {
            e.consume();
        }
        
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }

    public static void main(String[] args) {
        HomeView homeView = new HomeView();
    }
}
