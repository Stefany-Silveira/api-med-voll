package med.voll.domain.consulta.validacoes.agendamento;

import med.voll.controller.ValidacaoException;
import med.voll.domain.consulta.DadosAgendamentoConsulta;
import med.voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteIsAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteIsAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada. Paciente não está ativo");
        }
    }
}
