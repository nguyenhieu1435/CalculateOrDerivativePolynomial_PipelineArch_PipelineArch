package vn.edu.iuh.fit.utils;

import vn.edu.iuh.fit.entities.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class PolynomialUtil {


    public static Function<String, List<Element>> splitPolynomialToElement() {
        return polynomial -> {
            Pattern pattern = Pattern.compile(" (?=[+-])|(?=[*])|(?=[/])");
            String polynomialSplited[] = pattern.split(polynomial);

            List<Element> elements = new ArrayList<>();

            for (int i = 0; i < polynomialSplited.length; i++) {
                Element element = getElementFromPolynomialSplited(polynomialSplited[i]);
                elements.add(element);
            }
            return elements;
        };
    }
    private static Element getElementFromPolynomialSplited(String elementStr){
        Element element = new Element();

        char mathSymbol = '+';
        String coefficient = "";
        for (int i = 0; i < elementStr.length(); i++) {
            if (elementStr.charAt(i) == '+' || elementStr.charAt(i) == '-') {
                mathSymbol = elementStr.charAt(i);
            }

            if (elementStr.charAt(i) == '^'){
                element.setCoefficient(coefficient);
                coefficient = "";
                element.setExponent(getExponentFromString(elementStr, i+1));
            }
            if (elementStr.charAt(i) != '-' && elementStr.charAt(i) != '+' && elementStr.charAt(i) != ' '){
                coefficient += elementStr.charAt(i);
            }
        }
        if (element.getCoefficient() == null){
            element.setCoefficient(coefficient);
        }
        element.setMathSymbol(mathSymbol);
        return element;
    }
    public static double getExponentFromString(String string, int beginIndex){
        String exponentStr = "";
        for (int i = beginIndex; i < string.length(); i++){
            if (string.charAt(i) == ' '){
                break;
            }
            exponentStr += string.charAt(i) + "";
        }

        return Double.parseDouble(exponentStr);
    }

    public static Function<List<Element>, Double> calculatePolynomial(double x){
        return elements -> {
            double result = 0;
            for (int i = 0; i < elements.size(); i++){

                Element element = elements.get(i);
                boolean isContainX = element.getCoefficient().contains("x");
                String cleanXFromCoefficient = element.getCoefficient().replace("x", "");
                double coefficientValue = Double.parseDouble(cleanXFromCoefficient);
                double resultElement = isContainX ? coefficientValue * Math.pow(x, element.getExponent()) : coefficientValue;
                if (element.getMathSymbol() == '-'){
                    resultElement = -resultElement;
                }
                result += resultElement;
            }
            return result;
        };
    }
    public static Function<List<Element>, String> derivativePolynomial(){
        return elements -> {
            String derivative = "";
            for (int i = 0; i < elements.size(); i++){
                Element element = elements.get(i);
                boolean isContainX = element.getCoefficient().contains("x");
                if (isContainX){
                    String space = i == 0 ? "" : " ";
                    String mathSymbol = "";
                    if (i == 0){
                        if (element.getMathSymbol() == '-'){
                            mathSymbol = "-";
                        }
                    } else {
                        if (element.getMathSymbol() == '-'){
                            mathSymbol = "-";
                        } else {
                            mathSymbol = "+";
                        }
                    }

                    if (element.getExponent() != 1){
                        double oldCoefficient = Double.parseDouble(element.getCoefficient().replace("x", ""));

                        double newExponent = element.getExponent() -  1;
                        String newExponentStr = newExponent + "";
                        newExponentStr = newExponentStr.replaceAll(".0", "");
                        String consequent = newExponent != 1 ? "^" + newExponentStr : "";
                        derivative += space + mathSymbol + space + cleanDotZero((oldCoefficient*element.getExponent())+"") + "x" + consequent;
                    } else {
                        String newCoefficient = element.getCoefficient().replace("x", "");
                        derivative += space + mathSymbol + space + cleanDotZero(newCoefficient);
                    }
                }
            }
            return derivative;
        };

    }
    private static String cleanDotZero(String value){
        return (value).replaceAll(".0", "");
    }
}
