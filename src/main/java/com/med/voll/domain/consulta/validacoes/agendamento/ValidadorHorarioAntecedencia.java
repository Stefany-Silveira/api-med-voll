package com.med.voll.domain.consulta.validacoes.agendamento;

import com.med.voll.controller.ValidacaoException;
import com.med.voll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diiferencaEmMinutos = Duration.between(dataAtual, dataConsulta).toMinutes();

        if (diiferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência");
        }
    }
}
