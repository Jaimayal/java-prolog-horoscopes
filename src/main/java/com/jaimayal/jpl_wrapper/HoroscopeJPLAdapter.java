package com.jaimayal.jpl_wrapper;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoroscopeJPLAdapter {
    
    public HoroscopeJPLAdapter() {
        Query query = new Query(
                "consult", 
                new Term[] {new Atom("prolog-backend/horoscope.pl")}
        );

        if (!query.hasSolution()) {
            throw new RuntimeException(
                    "Connection to prolog failed. Please check that the file exists and that the path is correct"
            );
        }
    }
    
    public List<Map<String , String>> executeQuery(String query) {
        Query q = new Query(query);
        if (!q.hasSolution()) {
            throw new RuntimeException(
                    "Query failed. Please check that the query is correct"
            );
        }
        Map<String, Term>[] solutions = q.allSolutions();
        List<Map<String, String>> result = new ArrayList<>();
        
        for (Map<String, Term> solution : solutions) {
            Map<String, String> solutionResult = new HashMap<>();
            for (Map.Entry<String, Term> entry : solution.entrySet()) {
                solutionResult.put(entry.getKey(), entry.getValue().toString());
            }
            result.add(solutionResult);
        }
        return result;
    }
}
