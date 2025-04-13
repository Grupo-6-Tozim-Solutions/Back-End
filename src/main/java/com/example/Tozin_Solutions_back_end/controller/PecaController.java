package com.example.Tozin_Solutions_back_end.controller;

import com.example.Tozin_Solutions_back_end.dto.PecaDTO.AtualizarPecaDTO;
import com.example.Tozin_Solutions_back_end.dto.PecaDTO.CadastrarPecaDTO;
import com.example.Tozin_Solutions_back_end.model.Peca;
import com.example.Tozin_Solutions_back_end.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peca")
public class PecaController {

    @Autowired
    private PecaService service;

    @PostMapping
    public ResponseEntity cadastrarPeca(@RequestBody CadastrarPecaDTO dadosCadastroPeca){
        return ResponseEntity.ok(service.salvarPeca(dadosCadastroPeca));
    }

    @GetMapping("/listarTodas")
    public ResponseEntity listarPecas(){
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizarQuantidade/{id}/{quantidadeAdicional}")
    public ResponseEntity<Peca> atualizarEstoque(@PathVariable Long id, @PathVariable Integer quantidadeAdicional){
        return service.atualizarEstoque(id, quantidadeAdicional)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pecasComValorCritico")
    public ResponseEntity verificarPecasComValorCritico(){
        return ResponseEntity.ok(service.verificarPecasComValorCritico());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> atualizarPecas(@PathVariable Long id, @RequestBody AtualizarPecaDTO novosDados){
        return service.atualizarPeca(id, novosDados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPeca(@PathVariable Long id){
        return service.deletarPeca(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
