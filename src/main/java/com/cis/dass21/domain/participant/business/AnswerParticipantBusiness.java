package com.cis.dass21.domain.participant.business;

import com.cis.dass21.domain.participant.dtos.AnswerParticipantDTO;
import com.cis.dass21.domain.participant.models.AnswerParticipant;
import com.cis.dass21.domain.participant.repositories.AnswerParticipantRepository;
import com.cis.dass21.domain.participant.repositories.ParticipantRepository;
import com.cis.dass21.domain.participant.utils.DASS21Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnswerParticipantBusiness {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private AnswerParticipantRepository answerParticipantRepository;

    public AnswerParticipant save(AnswerParticipant answerParticipant) throws Exception {

        this.validRequiredFields(answerParticipant);
        answerParticipant.setDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        participantRepository.save(answerParticipant.getParticipant());

        answerParticipant = answerParticipantRepository.save(answerParticipant);

        return answerParticipant;
    }

    public List<AnswerParticipant> getAll() {
        List<AnswerParticipant> answerParticipantList = answerParticipantRepository.findAll();

        for (AnswerParticipant answerParticipant: answerParticipantList) {
            answerParticipant.getParticipant().setName("");
        }

        return answerParticipantList;
    }

    public AnswerParticipant getById(Long id) throws Exception {
        Optional<AnswerParticipant> answerParticipantOptional = answerParticipantRepository.findById(id);



        if (!answerParticipantOptional.isPresent()) {
            throw new Exception("Nenhum registro encontrado");
        }

        answerParticipantOptional.get().getParticipant().setName("");

        return answerParticipantOptional.get();
    }


    private void validRequiredFields(final AnswerParticipant answerParticipant) throws Exception {
        boolean invalid = Boolean.FALSE;
        String errorMessage = "campos obrigatorios nao preenchidos";

        if (answerParticipant.getParticipant() == null) {
            invalid = Boolean.TRUE;
        } else if (!(Objects.equals(answerParticipant.getParticipant().getGender(), "Masculino") || Objects.equals(answerParticipant.getParticipant().getGender(), "Feminino"))) {
            invalid = Boolean.TRUE;
            errorMessage = "O genêro precisa ser ou 'Masculino' ou 'Feminino'";
        }

        if (answerParticipant.getAnxietyTotalScore() == null) {
            invalid = Boolean.TRUE;
        }

        if (answerParticipant.getStressTotalScore() == null) {
            invalid = Boolean.TRUE;
        }

        if (answerParticipant.getDepressionTotalScore() == null) {
            invalid = Boolean.TRUE;
        }

        if (invalid) {
            throw new Exception(errorMessage);
        }
    }
}
