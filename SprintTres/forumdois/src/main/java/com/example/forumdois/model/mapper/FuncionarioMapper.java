package com.example.forumdois.model.mapper;


import com.example.forumdois.model.FuncionarioDTO;
import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionarioMapper {

    public static FuncionarioDTO requestToFuncionario(FuncionarioRequest funcionarioRequest){
        return FuncionarioDTO.builder()
                .codigo(funcionarioRequest.getCodigo())
                .nome(funcionarioRequest.getNome())
                .idade(funcionarioRequest.getIdade())
                .salario(funcionarioRequest.getSalario())
                .build();
    }

    public static FuncionarioResponse funcionarioToResponse(FuncionarioDTO funcionario){
        return FuncionarioResponse.builder()
                .codigo(funcionario.getCodigo())
                .nome(funcionario.getNome())
                .idade(funcionario.getIdade())
                .salario(funcionario.getSalario())
                .build();
    }

}