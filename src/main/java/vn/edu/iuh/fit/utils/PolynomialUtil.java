package vn.edu.iuh.fit.utils;

import java.util.regex.Pattern;

public class CalculatePolynomial {

    
    public static double calculatePolynomial(String polynomial, double x) {
        Pattern pattern = Pattern.compile(" (?=[+-])|(?=[*])|(?=[/])");
        String polynomialSplited[] = pattern.split(polynomial);

        for (int i = 0; i < polynomialSplited.length; i++) {
            System.out.println(polynomialSplited[i]);
        }

        return 0;
    }
}
