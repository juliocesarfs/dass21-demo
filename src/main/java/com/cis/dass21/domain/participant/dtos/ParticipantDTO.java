package com.cis.dass21.domain.participant.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;

@Data
public class ParticipantDTO implements Serializable {

    private Long id;

    @NotBlank(message = "O nome do participante é obrigatório")
    @NotNull(message = "O nome do participante é obrigatório")
    @Valid
    private String name;

    @NotNull(message = "a idade do participante é obrigatória")
    @Positive(message = "Preencha uma idade válida")
    @Valid
    private Integer age;

    @NotNull(message = "o genêro do participante é obrigatório")
    @NotBlank(message = "o genêro do participante é obrigatório")
    @Valid
    private String gender;
}
