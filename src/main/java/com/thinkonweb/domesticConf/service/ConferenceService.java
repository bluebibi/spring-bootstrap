package com.thinkonweb.domesticConf.service;

import com.thinkonweb.domesticConf.domain.Conference;
import com.thinkonweb.domesticConf.repository.ConferenceMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ConferenceService {
    @Inject
    private ConferenceMapper conferenceMapper;

    public Conference getConference(int id) {
        return null;
    }

    public void updateConference(Conference conference) {

    }

    public Conference getConferenceByNameId(String nameId) {
        return conferenceMapper.getConferenceByNameId(nameId);
    }
}
