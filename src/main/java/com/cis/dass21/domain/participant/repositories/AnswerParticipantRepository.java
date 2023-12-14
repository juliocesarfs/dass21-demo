package com.cis.dass21.domain.participant.repositories;

import com.cis.dass21.domain.participant.models.AnswerParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerParticipantRepository extends JpaRepository<AnswerParticipant, Long> {

}
