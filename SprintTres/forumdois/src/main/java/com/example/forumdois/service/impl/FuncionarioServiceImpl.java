package com.example.forumdois.service.impl;

import com.example.forumdois.error.ResourceNotFoundException;
import com.example.forumdois.model.mapper.FuncionarioMapper;
import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import com.example.forumdois.repository.FuncionarioRepository;
import com.example.forumdois.repository.entity.FuncionarioEntity;
import com.example.forumdois.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioResponse> obterTodos() {
       List<FuncionarioEntity> funcionariosLista = new ArrayList<>(this.funcionarioRepository.findAll());

       return funcionariosLista.stream()
               .map((FuncionarioEntity value)->FuncionarioMapper.entityToResponse(value))
               .toList();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse obterPorCodigo(String codigo) {

        return FuncionarioMapper.
                entityToResponse(this.funcionarioRepository.findById(codigo)
                        .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found by ID")));

    }
    @Override
    public FuncionarioResponse criar(@Validated FuncionarioRequest funcionarioRequest) {
        funcionarioRepository.save(FuncionarioMapper.requestToEntity(funcionarioRequest));

        return FuncionarioMapper.requestToReponse(funcionarioRequest);
    }

    @Override
    public void deletar(String codigo) {
        Optional<FuncionarioEntity> funcionarioExiste = this.funcionarioRepository.findById(codigo);
         if(funcionarioExiste.isPresent()) {
             this.funcionarioRepository.deleteById(codigo);
         }else{
             funcionarioExiste.orElseThrow(()->new ResourceNotFoundException("Funcionario not found"));
         }
    }

    @Override
    public FuncionarioResponse alterarDadosPorCodigo(String codigo, FuncionarioRequest funcionarioRequest) {
        FuncionarioEntity funcionarioASalvar = this.funcionarioRepository.findById(codigo)
                         .orElseThrow(()->new ResourceNotFoundException("Funcionario not found by ID"));

        funcionarioRequest.setCodigo(funcionarioASalvar.getCodigo());
        funcionarioRepository.save(FuncionarioMapper.requestToEntity(funcionarioRequest));
        return FuncionarioMapper.requestToReponse(funcionarioRequest);

   }
    @Override
    public void deletarTudo() {
        this.funcionarioRepository.deleteAll();
    }

}
