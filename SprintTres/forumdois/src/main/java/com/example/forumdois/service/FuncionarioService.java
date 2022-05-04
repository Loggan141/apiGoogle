package com.example.forumdois.service;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.model.response.FuncionarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncionarioService {

    public List<FuncionarioResponse> obterTodos();
    public FuncionarioResponse obterPorCodigo(String codigo);
    public Funcionario criar(Funcionario funcionario);
    public String deletar(String codigo);
    public Funcionario alterarDadosPorCodigo(String codigo, Funcionario funcionario);
    public void deletarTudo();

}
