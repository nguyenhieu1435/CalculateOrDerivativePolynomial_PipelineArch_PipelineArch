package vn.edu.iuh.fit;


import org.apache.catalina.Pipeline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.entities.Element;
import vn.edu.iuh.fit.utils.PolynomialUtil;

import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class CalculateOrDerivativePolynomialPipelineArchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateOrDerivativePolynomialPipelineArchApplication.class, args);

//        Function<String, List<Element>> splitPolynomialToElement = PolynomialUtil.splitPolynomialToElement();
//        Function<List<Element>, Double> calculatePolynomial = PolynomialUtil.calculatePolynomial(2);
//
//        splitPolynomialToElement.andThen(calculatePolynomial);
//        Function<String, Double> resultPipeline = splitPolynomialToElement.andThen(calculatePolynomial);
//
//        double result = resultPipeline.apply("5x^3 - 6x^4 + 6x^9 + 7x + 2");
//
//        System.out.println(result);
//
//        Function<List<Element>, String> derivativePolynomial = PolynomialUtil.derivativePolynomial();
//        Function<String, String> resultPipe2 = splitPolynomialToElement.andThen(derivativePolynomial);
//
//        String result2 = resultPipe2.apply("- 5x^3 - 6x^4 + 6x^9 + 7x + 2");
//        System.out.println(result2);
    }

}
