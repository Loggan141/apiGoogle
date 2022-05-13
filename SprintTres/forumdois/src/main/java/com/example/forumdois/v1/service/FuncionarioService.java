package com.example.forumdois.v1.service;

import com.example.forumdois.v1.exception.ResourceNotFoundException;
import com.example.forumdois.v1.model.mapper.FuncionarioMapper;
import com.example.forumdois.v1.model.request.FuncionarioRequest;
import com.example.forumdois.v1.model.response.FuncionarioResponse;
import com.example.forumdois.v1.repository.FuncionarioRepository;
import com.example.forumdois.v1.repository.entity.FuncionarioEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioResponse> obterTodos(List<String> codigos) {
       if(codigos.isEmpty()){
         return this.funcionarioRepository.findAll()
                                          .stream()
                                          .map(FuncionarioMapper::entityToResponse)
                                          .collect(Collectors.toList());
       }else
           return this.funcionarioRepository.findAllByCodigoIn(codigos)
                               .stream()
                               .map(FuncionarioMapper::entityToResponse)
                               .collect(Collectors.toList());
    }

    public FuncionarioResponse obterPorCodigo(String codigo) {
        return FuncionarioMapper.
                entityToResponse(this.funcionarioRepository.findById(codigo)
                                     .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found by ID")));
    }

    public FuncionarioResponse criar(FuncionarioRequest funcionarioRequest) {

        return FuncionarioMapper.entityToResponse(this.funcionarioRepository
                                                      .save(FuncionarioMapper
                                                      .requestToEntity(funcionarioRequest)));
    }

    public void deletar(List<String> codigos) {

        if (codigos.isEmpty()) {
            this.funcionarioRepository.deleteAll();
        } else {
            this.funcionarioRepository.findAllByCodigoIn(codigos)
                    .stream()
                    .map(FuncionarioEntity::getCodigo)
                    .toList()
                    .forEach(value -> funcionarioRepository.deleteById(value));                                              ;
        }

    }
    public FuncionarioResponse alterarDadosPorCodigo(String codigo, FuncionarioRequest funcionarioRequest) {
        FuncionarioEntity funcionarioASalvar = this.funcionarioRepository.findById(codigo)
                         .orElseThrow(()->new ResourceNotFoundException("Funcionario not found by ID"));

        funcionarioRequest.setCodigo(funcionarioASalvar.getCodigo());
        funcionarioRepository.save(FuncionarioMapper.requestToEntity(funcionarioRequest));
        return FuncionarioMapper.requestToReponse(funcionarioRequest);

   }
}
