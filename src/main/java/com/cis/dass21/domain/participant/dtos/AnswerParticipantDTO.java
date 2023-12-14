package com.cis.dass21.domain.participant.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AnswerParticipantDTO implements Serializable {

    private Long id;

    @NotNull(message = "Os dados do participante são obrigatórios")
    @Valid
    private ParticipantDTO participant;

    @NotNull(message = "A pontuação de depressão é obrigatória")
    @Min(value = 0, message = "A pontuação de depressão precisa ser maior ou igual a 0")
    @Valid
    private Integer depressionTotalScore;

    private String depressionScale;

    @NotNull(message = "A pontuação de ansiedade é obrigatória")
    @Min(value = 0, message = "A pontuação de ansiedade precisa ser maior ou igual a 0")
    @Valid
    private Integer anxietyTotalScore;

    private String anxietyScale;

    @NotNull(message = "A pontuação de estress é obrigatória")
    @Min(value = 0, message = "A pontuação de estress precisa ser maior ou igual a 0")
    @Valid
    private Integer stressTotalScore;

    private String stressScale;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime answerDate;
}
