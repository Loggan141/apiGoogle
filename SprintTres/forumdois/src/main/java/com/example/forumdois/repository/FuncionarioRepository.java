package com.example.forumdois.repository;

import com.example.forumdois.repository.entity.FuncionarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<FuncionarioEntity, String> {
    List<FuncionarioEntity> findAllByCodigoIn(List<String> codigos);
}
