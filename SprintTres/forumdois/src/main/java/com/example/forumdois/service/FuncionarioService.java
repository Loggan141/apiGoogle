package com.example.forumdois.service;

import com.example.forumdois.model.FuncionarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FuncionarioService {

    public List<FuncionarioDTO> obterTodos();
    public ResponseEntity<FuncionarioDTO> obterPorCodigo(String codigo);
    public FuncionarioDTO criar(FuncionarioDTO funcionarioDTO);
    public ResponseEntity<Object> deletar(String codigo);
    public FuncionarioDTO alterarDadosPorCodigo(String codigo, FuncionarioDTO funcionarioDTO);
    public void deletarTudo();

}
