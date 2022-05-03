package com.example.forumdois.service.impl;

import com.example.forumdois.model.FuncionarioDTO;
import com.example.forumdois.repository.FuncionarioRepository;
import com.example.forumdois.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioDTO> obterTodos() {

        return this.funcionarioRepository.findAll();
    }

    @Override
    public ResponseEntity<FuncionarioDTO> obterPorCodigo(String codigo) {
        Optional<FuncionarioDTO> funcionario=this.funcionarioRepository.findById(codigo);
        if (funcionario.isPresent()){
            return new ResponseEntity<FuncionarioDTO>(funcionario.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public FuncionarioDTO criar(@Validated FuncionarioDTO funcionarioDTO) {
       return funcionarioRepository.save(funcionarioDTO);
    }
    @Override
    public ResponseEntity<Object> deletar(String codigo) {
        Optional<FuncionarioDTO> funcionarioExiste = this.funcionarioRepository.findById(codigo);
        if(funcionarioExiste.isPresent()) {
            this.funcionarioRepository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public FuncionarioDTO alterarDadosPorCodigo(String codigo, FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioDTO> funcionarioAnterior= this.funcionarioRepository.findById(codigo);
        if(funcionarioAnterior.isPresent()){
            FuncionarioDTO funcionarioDTOAlterar =funcionarioAnterior.get();
            funcionarioDTOAlterar.setNome(funcionarioDTO.getNome());
            funcionarioDTOAlterar.setIdade(funcionarioDTO.getIdade());
            funcionarioDTOAlterar.setSalario(funcionarioDTO.getSalario());
            this.funcionarioRepository.save(funcionarioDTOAlterar);

            return new ResponseEntity<FuncionarioDTO>(funcionarioDTOAlterar, HttpStatus.OK).getBody();
        }
        else{
            return null;}
    }
    @Override
    public void deletarTudo() {
        this.funcionarioRepository.deleteAll();
    }

}
