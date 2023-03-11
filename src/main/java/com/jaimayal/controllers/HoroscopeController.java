package com.jaimayal.controllers;

import com.jaimayal.jpl_wrapper.HoroscopeJPLAdapter;

public class HoroscopeController {
    
    private HoroscopeJPLAdapter horoscopeJPLAdapter;
    
    public HoroscopeController() {
        this.horoscopeJPLAdapter = new HoroscopeJPLAdapter();
    }

    public String getCompatibility(String horoscope) {
        String query = "prueba(X, " + horoscope + ", Y)";
        return horoscopeJPLAdapter.executeQuery(query).get(0).get("Y");
    }

    public String calculateHoroscope(String day, String month) {
        String query = "signo(" + day + ", " + month + ", Signo)";
        return horoscopeJPLAdapter.executeQuery(query).get(0).get("Signo");
    }

    public String getHoroscopeDetails(String horoscope) {
        String query = "prueba2(" + horoscope + ", Y)";
        return horoscopeJPLAdapter.executeQuery(query).get(0).get("Y");
    }
}
