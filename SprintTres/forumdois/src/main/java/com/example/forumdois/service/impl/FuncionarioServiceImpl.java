package com.example.forumdois.service.impl;

import com.example.forumdois.error.ResourceNotFoundException;
import com.example.forumdois.model.Funcionario;
import com.example.forumdois.model.mapper.FuncionarioMapper;
import com.example.forumdois.model.response.FuncionarioResponse;
import com.example.forumdois.repository.FuncionarioRepository;
import com.example.forumdois.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioResponse> obterTodos() {
       List<Funcionario> funcionariosLista = new ArrayList<>(this.funcionarioRepository.findAll());

       return funcionariosLista.stream()
               .map((Funcionario value)->FuncionarioMapper.funcionarioToResponse(value))
               .toList();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse obterPorCodigo(String codigo) {

        return FuncionarioMapper.
                funcionarioToResponse(this.funcionarioRepository.findById(codigo)
                        .orElseThrow(() -> new ResourceNotFoundException("Student not found by ID")));

    }
    @Override
    public Funcionario criar(@Validated Funcionario funcionario) {
       return funcionarioRepository.save(funcionario);
    }

    @Override
    public String deletar(String codigo) {
        Optional<Funcionario> funcionarioExiste = this.funcionarioRepository.findById(codigo);
         if(funcionarioExiste.isPresent()) {
            this.funcionarioRepository.deleteById(codigo);
            return "Usuário deletado.";
        }
        else
            return "Usuario não encontrado";
    }

    @Override
    public Funcionario alterarDadosPorCodigo(String codigo, Funcionario funcionario) {
         Funcionario funcionarioASalvar = this.funcionarioRepository.findById(codigo)
                         .orElseThrow(()->new RuntimeException("Não existente"));
         funcionario.setCodigo(funcionarioASalvar.getCodigo());
         return funcionarioRepository.save(funcionario);
   }
    @Override
    public void deletarTudo() {
        this.funcionarioRepository.deleteAll();
    }

}
