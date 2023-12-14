package com.cis.dass21.domain.participant.repositories;

import com.cis.dass21.domain.participant.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
