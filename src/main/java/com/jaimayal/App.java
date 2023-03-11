package com.jaimayal;

import com.jaimayal.views.HomeView;

import javax.swing.*;

public class App {
    private HomeView homeView;
    
    public void run() {
        this.homeView = new HomeView();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
