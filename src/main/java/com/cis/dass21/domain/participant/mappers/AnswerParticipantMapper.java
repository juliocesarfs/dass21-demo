package com.cis.dass21.domain.participant.mappers;

import com.cis.dass21.domain.participant.dtos.AnswerParticipantDTO;
import com.cis.dass21.domain.participant.models.AnswerParticipant;
import com.cis.dass21.domain.participant.models.Participant;
import com.cis.dass21.domain.participant.utils.DASS21Classification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ParticipantMapper.class })
public interface AnswerParticipantMapper {

    DASS21Classification dass21Classification = new DASS21Classification();

    @Mapping(source = "date", target = "answerDate")
    @Mapping(target = "depressionScale", expression = "java(dass21Classification.getDepressionScale(answerParticipantDTO.getDepressionTotalScore()))")
    @Mapping(target = "anxietyScale", expression = "java(dass21Classification.getDepressionScale(answerParticipantDTO.getAnxietyTotalScore()))")
    @Mapping(target = "stressScale", expression = "java(dass21Classification.getDepressionScale(answerParticipantDTO.getStressTotalScore()))")
    public AnswerParticipantDTO toDTO(AnswerParticipant answer);

    @Mapping(source = "answerDate", target = "date")
    public AnswerParticipant toEntity(AnswerParticipantDTO answerParticipantDTO);
}
