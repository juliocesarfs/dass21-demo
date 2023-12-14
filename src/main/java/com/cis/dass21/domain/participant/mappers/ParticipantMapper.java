package com.cis.dass21.domain.participant.mappers;

import com.cis.dass21.domain.participant.dtos.ParticipantDTO;
import com.cis.dass21.domain.participant.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    public ParticipantDTO toDTO(Participant participant);

    public Participant toEntity(ParticipantDTO participantDTO);
}
