package com.cis.dass21.domain.participant.utils;

import com.cis.dass21.domain.participant.dtos.AnswerParticipantDTO;
import lombok.Data;
import lombok.Getter;

import java.util.List;

// Classe de wrapper para encapsular a lista
@Getter
@Data
public class AnswerListWrapper {
    private List<AnswerParticipantDTO> answerParticipantList;

    public AnswerListWrapper(List<AnswerParticipantDTO> answerParticipantList) {
        this.answerParticipantList = answerParticipantList;
    }

}
