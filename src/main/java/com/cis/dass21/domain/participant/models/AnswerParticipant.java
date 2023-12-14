package com.cis.dass21.domain.participant.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Respostas")
public class AnswerParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data_resposta", nullable = false)
    private LocalDateTime date;

    @Column(name = "pontuacao_total_depressao", nullable = false)
    private Integer depressionTotalScore;

    @Column(name = "pontuacao_total_ansiedade", nullable = false)
    private Integer anxietyTotalScore;

    @Column(name = "pontuacao_total_estresse", nullable = false)
    private Integer stressTotalScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participante_id", referencedColumnName = "id", nullable = false)
    private Participant participant;
}
