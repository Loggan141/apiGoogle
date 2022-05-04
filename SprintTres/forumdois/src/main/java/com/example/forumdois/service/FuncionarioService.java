package com.example.forumdois.service;

import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncionarioService {

    public List<FuncionarioResponse> obterTodos();
    public FuncionarioResponse obterPorCodigo(String codigo);
    public FuncionarioResponse criar(FuncionarioRequest funcionarioRequest);
    public void deletar(String codigo);
    public FuncionarioResponse alterarDadosPorCodigo(String codigo, FuncionarioRequest funcionarioRequest);
    public void deletarTudo();

}
