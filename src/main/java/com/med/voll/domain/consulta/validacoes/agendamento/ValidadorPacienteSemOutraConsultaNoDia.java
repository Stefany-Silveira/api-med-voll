package com.med.voll.domain.consulta.validacoes.agendamento;

import com.med.voll.controller.ValidacaoException;
import com.med.voll.domain.consulta.ConsultaRepository;
import com.med.voll.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(),
                primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Consulta não pode ser agendada. Paciente já possui uma consulta nesse mesmo dia");
        }
    }
}
