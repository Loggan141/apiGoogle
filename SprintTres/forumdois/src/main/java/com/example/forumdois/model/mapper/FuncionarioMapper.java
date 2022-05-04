package com.example.forumdois.model.mapper;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.model.request.FuncionarioRequest;
import com.example.forumdois.model.response.FuncionarioResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionarioMapper {

    public static Funcionario requestToFuncionario(FuncionarioRequest funcionarioRequest){
        return Funcionario.builder()
                .nome(funcionarioRequest.getNome())
                .idade(funcionarioRequest.getIdade())
                .salario(funcionarioRequest.getSalario())
                .build();
    }

    public static FuncionarioResponse funcionarioToResponse(Funcionario funcionario){
        return FuncionarioResponse.builder()
                .codigo(funcionario.getCodigo())
                .nome(funcionario.getNome())
                .idade(funcionario.getIdade())
                .salario(funcionario.getSalario())
                .build();
    }

//    public static FuncionarioEntity RequestToEntity(FuncionarioRequest funcionarioRequest){
//        return FuncionarioEntity.builder()
//                .codigo(funcionarioRequest.getCodigo())
//                .nome(funcionarioRequest.getNome())
//                .idade(funcionarioRequest.getIdade())
//                .salario(funcionarioRequest.getSalario())
//                .build();
//    }
//
//    public static FuncionarioResponse RequestToEntity(FuncionarioEntity funcionarioEntity){
//        return FuncionarioRequest.builder()
//                .codigo(funcionarioRequest.getCodigo())
//                .nome(funcionarioRequest.getNome())
//                .idade(funcionarioRequest.getIdade())
//                .salario(funcionarioRequest.getSalario())
//                .build();
//    }









}