package com.med.voll.domain.consulta.validacoes.agendamento;

import com.med.voll.controller.ValidacaoException;
import com.med.voll.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diiferencaEmMinutos = Duration.between(dataAtual, dataConsulta).toMinutes();

        if (diiferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência");
        }
    }
}
