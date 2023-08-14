package com.med.voll.domain.consulta.validacoes.agendamento;

import com.med.voll.controller.ValidacaoException;
import com.med.voll.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        //escolha médico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoIsAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoIsAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada. Médico não está ativo");
        }
    }
}