package com.codingbox.planner.service;

import com.codingbox.planner.domain.DTO.PartyDTO;
import com.codingbox.planner.domain.Party;
import com.codingbox.planner.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    public Party createParty(Party party) {
        return partyRepository.save(party);
    }

    public List<Party> findUserSchedule(String UserId){
        return partyRepository.findUserSchedule(UserId);
    }
}
