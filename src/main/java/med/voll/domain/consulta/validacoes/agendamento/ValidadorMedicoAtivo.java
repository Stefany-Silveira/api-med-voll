package med.voll.domain.consulta.validacoes.agendamento;

import med.voll.controller.ValidacaoException;
import med.voll.domain.consulta.DadosAgendamentoConsulta;
import med.voll.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
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
