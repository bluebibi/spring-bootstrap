package com.thinkonweb.domesticConf.controller;

import com.thinkonweb.domesticConf.domain.Conference;
import com.thinkonweb.domesticConf.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Inject
    private ConferenceService conferenceService;

    // upload form get
    // Admin only
    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String conferenceUpdateForm(Model model) {
        model.addAttribute("conference", new Conference());
        return "admin/updateForm";
    }

    // upload form post
    // Admin only
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String conferenceUpdate(@ModelAttribute Conference conference, Model model,
                                   BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "admin/updateForm";
        }
        conferenceService.updateConference(conference);
        redirectAttrs.addAttribute("nameId", conference.getId())
                     .addFlashAttribute("message", "Conference Upload Complete");

        return "redirect:/conference/{nameId}";
    }

    // read one
    // Public
    @RequestMapping(value = "/{nameId}", method = RequestMethod.GET)
    public String read(@PathVariable("nameId") String nameId, Model model) {
        Conference conference = conferenceService.getConferenceByNameId(nameId);
        model.addAttribute("conference", conference);
        return "admin/conferenceDetail";
    }
}
