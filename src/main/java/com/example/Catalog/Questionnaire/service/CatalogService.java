package com.example.Catalog.Questionnaire.service;

import com.example.Catalog.Questionnaire.models.CatalogModels;
import com.example.Catalog.Questionnaire.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Optional;


@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public void catalogPostAdd(String lastName, String firstName, String middleName, String gender, LocalDate birth, String occupation, String customOccupation, Model model) {
        CatalogModels catalogModels = new CatalogModels(lastName, firstName, middleName, gender, birth, occupation, customOccupation);
        model.addAttribute("catalog", new CatalogModels());
        model.addAttribute("gender", gender);
        model.addAttribute("birth", birth);
        model.addAttribute("occupation", occupation);
        model.addAttribute("customOccupation", customOccupation);
        catalogRepository.save(catalogModels);
    }

    public void catalogEdit(long id, Model model) {
        Optional<CatalogModels> catalogModels = catalogRepository.findById(id);
        ArrayList<CatalogModels> listModels = new ArrayList<>();
        catalogModels.ifPresent(listModels::add);
        model.addAttribute("catalog", listModels);
    }

    public void catalogUpdate(long id, String lastName, String firstName, String middleName, String gender, LocalDate birth, String occupation, String customOccupation) {
        CatalogModels catalogModels = catalogRepository.findById(id).orElseThrow();
        catalogModels.setLastName(lastName);
        catalogModels.setFirstName(firstName);
        catalogModels.setMiddleName(middleName);
        catalogModels.setGender(gender);
        catalogModels.setBirth(birth);
        catalogModels.setOccupation(occupation);
        catalogModels.setCustomOccupation(customOccupation);
        catalogRepository.save(catalogModels);
    }

    public void catalogDelete(long id) {
        CatalogModels catalogModels = catalogRepository.findById(id).orElseThrow();
        catalogRepository.delete(catalogModels);
    }
}
