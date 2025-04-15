package com.example.Tozin_Solutions_back_end.service;

import com.example.Tozin_Solutions_back_end.dto.quantidadePecaEmSofaDTO.RegistroQuantidadePecaEmSofaDTO;
import com.example.Tozin_Solutions_back_end.model.QuantidadePecaEmSofa;
import com.example.Tozin_Solutions_back_end.repository.QuantidadePecaEmSofaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuantidadePecaEmSofaService {

    @Autowired
    private QuantidadePecaEmSofaRepository repository;

    public QuantidadePecaEmSofa salvarConfiguracao(RegistroQuantidadePecaEmSofaDTO dados){
        QuantidadePecaEmSofa quantidadePecaEmSofa = new QuantidadePecaEmSofa();

        quantidadePecaEmSofa.setIdSofa(dados.getIdSofa());
        quantidadePecaEmSofa.setIdPeca(dados.getIdPeca());
        quantidadePecaEmSofa.setQuantidadePeca(dados.getQuantidade());

        return repository.save(quantidadePecaEmSofa);
    }

    public Optional<QuantidadePecaEmSofa> encontrarPorIdSofaEPeca(Long idSofa, Long idPeca){
        return repository.findByIdSofaAndIdPeca(idSofa, idPeca);
    }
}
