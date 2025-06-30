package br.edu.ifb.java_web_dev.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
@CrossOrigin
public class CalculatorRestController {

    // Métodos GET
    @GetMapping("/soma")
    public double GetSoma(@RequestParam double x, @RequestParam double y) {
        return x + y;
    }

    @GetMapping("/subtracao")
    public double GetSubtracao(@RequestParam double x, @RequestParam double y) {
        return x - y;
    }

    @GetMapping("/multiplicacao")
    public double GetMultiplicacao(@RequestParam double x, @RequestParam double y) {
        return x * y;
    }

    @GetMapping("/divisao")
    public double GetDivisao(@RequestParam double x, @RequestParam double y) {
        return x / y;
    }

    // Métodos POST
    @PostMapping("/soma")
    public double PostSoma(@RequestBody Operands operandos) {
        return operandos.x + operandos.y;
    }

    @PostMapping("/subtracao")
    public double subPost(@RequestBody Operands operandos) {
        return operandos.x - operandos.y;
    }

    @PostMapping("/multiplicacao")
    public double mulPost(@RequestBody Operands operandos) {
        return operandos.x * operandos.y;
    }

    @PostMapping("/divisao")
    public double divPost(@RequestBody Operands operandos) {
        return operandos.x / operandos.y;
    }

    // Classe auxiliar para POST
    public static class Operandos {
        public double x;
        public double y;
    }
}