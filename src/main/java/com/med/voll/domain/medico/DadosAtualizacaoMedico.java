package com.med.voll.domain.medico;

import jakarta.validation.constraints.NotNull;
import com.med.voll.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco
) {
}
