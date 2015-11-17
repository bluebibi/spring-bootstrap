package com.thinkonweb.domesticConf.controller;

import com.thinkonweb.domesticConf.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Inject
    private ConferenceService conferenceService;

    @RequestMapping("/{nameId}")
    public String greeting(@PathVariable(value="nameId") String nameId, Model model) {
        model.addAttribute("conference", conferenceService.getConferenceByNameId(nameId));
        return "greeting";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
