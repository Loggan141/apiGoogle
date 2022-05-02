package com.example.forumdois.controller;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.service.CookieService;
import com.example.forumdois.service.impl.CookieServiceImpl;
import com.example.forumdois.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
//teste
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> obterCodigo(@PathVariable(value = "codigo") String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
        this.funcionarioService.criar(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/{codigo}")
    public Funcionario alterarFuncionarioPeloId(@PathVariable(value = "codigo") String codigo, @RequestBody Funcionario funcionario) {
        return this.funcionarioService.alterarDadosPorCodigo(codigo, funcionario);
    }
    @DeleteMapping("/deleteById")
    public void deletarPorCodigo(@RequestParam("codigo") List<String> codigos) {
          for(String codigo:codigos){
              this.funcionarioService.deletar(codigo);
          }
    }
    @DeleteMapping("/deleteAllFuncionarios")
    public void deletarTudo() {
        this.funcionarioService.deletarTudo();
    }

    @GetMapping("/Cookie")
    public String getReadCookie(HttpServletRequest request){
        return CookieServiceImpl.readAllCookies(request);
    }

    @PostMapping("/Cookie")
    public void createCookie(HttpServletResponse response){
        CookieServiceImpl.setCookie(response, 30);
    }


    //todolist
}
