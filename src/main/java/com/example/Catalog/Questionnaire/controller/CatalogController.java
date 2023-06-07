package com.example.Catalog.Questionnaire.controller;

import com.example.Catalog.Questionnaire.models.CatalogModels;
import com.example.Catalog.Questionnaire.repository.CatalogRepository;
import com.example.Catalog.Questionnaire.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;




@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/catalog")
    public String catalog() {
        return "catalog";
    }

    @GetMapping("/catalogAll")
    public String catalogAll(Model model) {
        Iterable<CatalogModels> catalog = catalogRepository.findAll();
        model.addAttribute("catalog", catalog);
        return "catalog_main";
    }

    @GetMapping("/catalog/add")
    public String catalogAdd() {
        return "catalog_add";
    }

    @PostMapping("/catalog/add")
    public String catalogPostAdd(@RequestParam String lastName,
                                 @RequestParam String firstName,
                                 @RequestParam String middleName,
                                 @RequestParam String gender,
                                 @RequestParam String occupation,
                                 @RequestParam String customOccupation,
                                 @RequestParam ("birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birth, Model model) {
        catalogService.catalogPostAdd(lastName, firstName, middleName, gender, birth, occupation, customOccupation, model);
        return "redirect:/catalogAll";
    }
    @GetMapping("/catalog/{id}")
    public String catalogDetails(@PathVariable("id") long id, Model model) {
        catalogService.catalogEdit(id, model);
        return "catalog_details";
    }

    @GetMapping("/catalog/{id}/edit")
    public String catalogEdit(@PathVariable(value = "id") long id, Model model) {
        catalogService.catalogEdit(id, model);
        return "catalog-edit";
    }

    @PostMapping("/catalog/{id}/edit")
    public String catalogUpdate(@PathVariable("id") long id,
                                @RequestParam String lastName,
                                @RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String gender,
                                @RequestParam String occupation,
                                @RequestParam String customOccupation,
                                @RequestParam ("birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birth) {
        catalogService.catalogUpdate(id, lastName, firstName, middleName, gender, birth, occupation, customOccupation);
        return "redirect:/catalog/{id}";
    }

    @PostMapping("/catalog/{id}/delete")
    public String catalogDelete(@PathVariable("id") long id) {
        catalogService.catalogDelete(id);
        return "redirect:/catalogAll";
    }
}
