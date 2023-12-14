package com.cis.dass21.domain.participant.controllers;


import com.cis.dass21.domain.participant.business.AnswerParticipantBusiness;
import com.cis.dass21.domain.participant.dtos.AnswerParticipantDTO;
import com.cis.dass21.domain.participant.mappers.AnswerParticipantMapper;
import com.cis.dass21.domain.participant.models.AnswerParticipant;
import com.cis.dass21.domain.participant.utils.AnswerListWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/participant")
public class AnswerParticipantController {

    @Autowired
    private AnswerParticipantMapper answerParticipantMapper;

    @Autowired
    private AnswerParticipantBusiness answerParticipantBusiness;

    @PostMapping
    public ResponseEntity<?> include(@RequestBody @Valid AnswerParticipantDTO answerParticipantDTO) {
        try {

            AnswerParticipant answerParticipant = answerParticipantMapper.toEntity(answerParticipantDTO);
            answerParticipant = answerParticipantBusiness.save(answerParticipant);
            answerParticipantDTO = answerParticipantMapper.toDTO(answerParticipant);

            return ResponseEntity.ok(answerParticipantDTO);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<AnswerParticipant> answerParticipantList = answerParticipantBusiness.getAll();
            List<AnswerParticipantDTO> answerParticipantDTOS = new ArrayList<>();

            if(!answerParticipantList.isEmpty()){
                for (AnswerParticipant g: answerParticipantList) {
                    AnswerParticipantDTO answerParticipantDTO = answerParticipantMapper.toDTO(g);

                    answerParticipantDTOS.add(answerParticipantDTO);
                }
            }

            AnswerListWrapper answerListWrapper = new AnswerListWrapper(answerParticipantDTOS);

            return ResponseEntity.ok(answerListWrapper);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id:[\\d]+}")
    public ResponseEntity<?> getById(@PathVariable final BigDecimal id) {
        try {
            AnswerParticipant answerParticipant = answerParticipantBusiness.getById(id.longValue());
            AnswerParticipantDTO answerParticipantDTO = answerParticipantMapper.toDTO(answerParticipant);

            return ResponseEntity.ok(answerParticipantDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody AnswerParticipantDTO answerParticipantDTO) {
        try {
            AnswerParticipant answerParticipant = answerParticipantMapper.toEntity(answerParticipantDTO);
            AnswerParticipant answerParticipantSaved = answerParticipantBusiness.save(answerParticipant);

            return ResponseEntity.ok(answerParticipantMapper.toDTO(answerParticipantSaved));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

