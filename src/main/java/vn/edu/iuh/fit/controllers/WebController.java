package vn.edu.iuh.fit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.entities.Element;
import vn.edu.iuh.fit.utils.PolynomialUtil;

import java.util.List;
import java.util.function.Function;

@RequestMapping("")
@Controller
public class WebController {
    @GetMapping({"*",  "/calculatePolynomial", "/derivativePolynomial"})
    public String handleOpenPolynomial(){
        return "polynomial";
    }
    @PostMapping("/calculatePolynomial")
    public String calculatePolynomial(@RequestParam("varX") double x,
                                      @RequestParam("polynomial1") String polynomial, Model model) {

        Function<String, List<Element>> splitPolynomialToElement = PolynomialUtil.splitPolynomialToElement();
        Function<List<Element>, Double> calculatePolynomial = PolynomialUtil.calculatePolynomial(x);

        splitPolynomialToElement.andThen(calculatePolynomial);
        Function<String, Double> resultPipeline = splitPolynomialToElement.andThen(calculatePolynomial);

        double result = resultPipeline.apply(polynomial);
        System.out.println(result);

        model.addAttribute("resultCalculatePolynomial", result);
        return "polynomial";
    }

    @PostMapping("/derivativePolynomial")
    public String derivativePolynomial(@RequestParam("polynomial2") String polynomial, Model model) {

        Function<List<Element>, String> derivativePolynomial = PolynomialUtil.derivativePolynomial();
        Function<String, List<Element>> splitPolynomialToElement = PolynomialUtil.splitPolynomialToElement();
        Function<String, String> resultPipe2 = splitPolynomialToElement.andThen(derivativePolynomial);

        String result = resultPipe2.apply(polynomial);
        System.out.println(result);

        model.addAttribute("resultDerivativePolynomial", result);
        return "polynomial";
    }



}