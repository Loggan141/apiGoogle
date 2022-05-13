package com.example.forumdois.v2.repository;

import com.example.forumdois.v2.repository.entity.FuncionarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<FuncionarioEntity, String> {
    List<FuncionarioEntity> findAllByCodigoIn(List<String> codigos);
}
