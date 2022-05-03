package com.example.forumdois.repository;

import com.example.forumdois.model.FuncionarioDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<FuncionarioDTO, String> {
}
