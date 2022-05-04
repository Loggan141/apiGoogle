package com.example.forumdois.controller;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.model.mapper.FuncionarioMapper;
import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import com.example.forumdois.service.FuncionarioService;
import com.example.forumdois.service.impl.CookieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioResponse> obterFuncionario(@RequestParam("codigo") List<String> codigos) {
        List<FuncionarioResponse> funcionarioResponses = new ArrayList<>();
        if (codigos.isEmpty()) {
            return this.funcionarioService.obterTodos();
        } else {
            for (String codigo : codigos) {
               funcionarioResponses.add(this.funcionarioService.obterPorCodigo(codigo));
            }
            return funcionarioResponses;
        }
    }


//    @GetMapping("/{codigo}")
//    public FuncionarioResponse obterCodigo(@PathVariable(value = "codigo") String codigo) {
//        return this.funcionarioService.obterPorCodigo(codigo);
//    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
       return this.funcionarioService.criar(funcionario);
    }
    @PutMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse alterarFuncionarioPeloId(@PathVariable(value = "codigo") String codigo,
                                                @RequestBody FuncionarioRequest funcionarioRequest){

            var funcionario = FuncionarioMapper.requestToFuncionario(funcionarioRequest);

            return FuncionarioMapper.funcionarioToResponse(funcionarioService.alterarDadosPorCodigo(codigo, funcionario));
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@RequestParam("codigo") List<String> codigos) {
        if(codigos.isEmpty()){
            this.funcionarioService.deletarTudo();
        }else {
            for (String codigo : codigos) {
                this.funcionarioService.deletar(codigo);
            }
        }
    }

    @GetMapping("/cookie")
    @ResponseStatus(HttpStatus.OK)
    public String getReadCookie(HttpServletRequest request){
        return CookieServiceImpl.readAllCookies(request);
    }

    @PostMapping("/cookie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCookie(HttpServletResponse response){
        CookieServiceImpl.setCookie(response, 30);
    }


}
