package vn.edu.iuh.fit.entities;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Element {
    private char mathSymbol;
    private String coefficient;
    private double exponent;


    public Element() {
        this.mathSymbol = '+';
        this.exponent = 1;
    }
}
