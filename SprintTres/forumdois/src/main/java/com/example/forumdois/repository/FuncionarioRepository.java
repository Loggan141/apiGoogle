package com.example.forumdois.repository;

import com.example.forumdois.repository.entity.FuncionarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<FuncionarioEntity, String> {
}
