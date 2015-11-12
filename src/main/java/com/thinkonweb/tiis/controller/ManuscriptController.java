package com.thinkonweb.tiis.controller;

import com.thinkonweb.tiis.domain.Manuscript;
import com.thinkonweb.tiis.service.ManuscriptService;
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

@Controller
@RequestMapping("/manuscript")
public class ManuscriptController {

    private static final Logger log = LoggerFactory.getLogger(ManuscriptController.class);

    @Autowired
    private ManuscriptService manuscriptService;

    // upload form get
    // Admin only
    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String manuscriptUploadForm(Model model) {
        model.addAttribute("manuscript", new Manuscript());
        return "manuscript/form";
    }

    // upload form post
    // Admin only
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String manuscriptUpload(@ModelAttribute Manuscript manuscript, Model model,
                                   BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "manuscript/form";
        }
        manuscriptService.upload(manuscript);
        redirectAttrs.addAttribute("id", manuscript.getId()).addFlashAttribute("message", "Manuscript Upload Complete");

        return "redirect:/manuscript/{id}";
    }

    // read one
    // Public
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String read(@PathVariable("id") int id, Model model) {
        Manuscript manuscript = manuscriptService.getManuscriptById(id);
        model.addAttribute("manuscript", manuscript);
        return "/manuscript/detail";
    }

    // read list
    // Admin only

    // update
    // Admin only
    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String manuscriptUdateForm(@PathVariable("id") int id, Model model) {
        Manuscript manuscript = manuscriptService.getManuscriptById(id);
        model.addAttribute("manuscript", manuscript);
        return "manuscript/form";
    }

    @RequestMapping(value="/upload/{id}", method = RequestMethod.POST)
    public String manuscriptUpdate(@ModelAttribute Manuscript manuscript, Model model,
                                   BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "manuscript/form";
        }
        manuscriptService.update(manuscript);
        redirectAttrs.addAttribute("id", manuscript.getId()).addFlashAttribute("message", "Manuscript Update Complete");
        return "redirect:/manuscript/{id}";
    }

    // delete
    // Admin only


}
