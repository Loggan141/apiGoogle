package com.example.forumdois.controller;

import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import com.example.forumdois.service.CookieService;
import com.example.forumdois.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.List;

@RestController

@RequestMapping("/api/v2/funcionarios")
@AllArgsConstructor
public class FuncionarioControllerV2 {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioResponse> obterFuncionario(@RequestParam("codigo") List<String> codigos) {
        return this.funcionarioService.obterTodos(codigos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioResponse criar(@RequestBody FuncionarioRequest funcionario) {
        return this.funcionarioService.criar(funcionario);
        }
    @PutMapping("/{codigo}")
    public FuncionarioResponse alterarFuncionarioPeloId(@PathVariable(value = "codigo") String codigo,
                                                        @RequestBody FuncionarioRequest funcionarioRequest){
           return funcionarioService.alterarDadosPorCodigo(codigo, funcionarioRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")

    public void deletar(@RequestParam("codigo") List<String> codigos) {
        this.funcionarioService.deletar(codigos);
    }

    //-----------------------COOKIES----------------------------

    @GetMapping("/cookie")
    public String getReadCookie(HttpServletRequest request){
        return CookieService.readAllCookies(request);
    }

    @PostMapping("/cookie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCookie(HttpServletResponse response){
        CookieService.setCookie(response, 30);
    }


}
