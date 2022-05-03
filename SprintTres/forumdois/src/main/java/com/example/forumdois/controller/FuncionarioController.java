package com.example.forumdois.controller;

import com.example.forumdois.model.FuncionarioDTO;
import com.example.forumdois.service.FuncionarioService;
import com.example.forumdois.service.impl.CookieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
//teste
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @GetMapping
    public List<FuncionarioDTO> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<FuncionarioDTO> obterCodigo(@PathVariable(value = "codigo") String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping

    public FuncionarioDTO criar(@RequestBody FuncionarioDTO funcionarioDTO, HttpServletResponse response) {
        this.funcionarioService.criar(funcionarioDTO);
        return new ResponseEntity<>(funcionarioDTO, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/{codigo}")
    public FuncionarioDTO alterarFuncionarioPeloId(@PathVariable(value = "codigo") String codigo,
                                                   @RequestBody FuncionarioDTO funcionarioDTO){
            return this.funcionarioService.alterarDadosPorCodigo(codigo, funcionarioDTO);
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
