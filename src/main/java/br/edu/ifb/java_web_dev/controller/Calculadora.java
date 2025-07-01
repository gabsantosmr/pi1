package br.edu.ifb.java_web_dev.controller;

import org.springframework.web.bind.annotation.*;

import br.edu.ifb.java_web_dev.model.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
@CrossOrigin
public class Calculadora {
    @GetMapping(value = "/soma/{a}/{b}")
    public @ResponseBody Double soma(@PathVariable double a, @PathVariable double b) {
        return CalculadoraService.somar(a, b);
    }
    
    @GetMapping(value = "/subtracao/{a}/{b}")
    public @ResponseBody Double subtracao(@PathVariable double a, @PathVariable double b) {
        return CalculadoraService.subtrair(a, b);
    }
    
    @GetMapping(value = "/multiplicacao/{a}/{b}")
    public @ResponseBody Double multiplicacao(@PathVariable double a, @PathVariable double b) {
        return CalculadoraService.multiplicar(a, b);
    }
    
    @GetMapping(value = "/divisao/{a}/{b}")
    public @ResponseBody Double divisao(@PathVariable double a, @PathVariable double b) {
        return CalculadoraService.dividir(a, b);
    }
}