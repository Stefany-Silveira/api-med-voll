package com.med.voll.domain.consulta.validacoes.agendamento;

import com.med.voll.controller.ValidacaoException;
import com.med.voll.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteIsAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteIsAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada. Paciente não está ativo");
        }
    }
}
