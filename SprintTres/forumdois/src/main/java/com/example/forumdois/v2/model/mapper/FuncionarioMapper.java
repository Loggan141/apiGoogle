package com.example.forumdois.v2.model.mapper;

import com.example.forumdois.v2.model.request.FuncionarioRequest;
import com.example.forumdois.v2.model.response.FuncionarioResponse;
import com.example.forumdois.v2.repository.entity.FuncionarioEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionarioMapper {

    public static FuncionarioEntity requestToEntity(FuncionarioRequest funcionarioRequest){
        return FuncionarioEntity.builder()
                .codigo(funcionarioRequest.getCodigo())
                .nome(funcionarioRequest.getNome())
                .idade(funcionarioRequest.getIdade())
                .salario(funcionarioRequest.getSalario())
                .cpf(funcionarioRequest.getCpf())
                .build();
    }

    public static FuncionarioResponse entityToResponse(FuncionarioEntity funcionarioEntity){
        return FuncionarioResponse.builder()
                .codigo(funcionarioEntity.getCodigo())
                .nome(funcionarioEntity.getNome())
                .idade(funcionarioEntity.getIdade())
                .salario(funcionarioEntity.getSalario())
                .cpf(funcionarioEntity.getCpf())
                .datacriacao(funcionarioEntity.getDatacriacao())
                .build();
    }

    public static FuncionarioResponse requestToReponse(FuncionarioRequest funcionarioRequest){
        return FuncionarioResponse.builder()
                .codigo(funcionarioRequest.getCodigo())
                .nome(funcionarioRequest.getNome())
                .idade(funcionarioRequest.getIdade())
                .salario(funcionarioRequest.getSalario())
                .cpf(funcionarioRequest.getCpf())
                .datacriacao(funcionarioRequest.getDatacriacao())
                .build();
    }

}