package com.example.Catalog.Questionnaire.repository;

import com.example.Catalog.Questionnaire.models.CatalogModels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<CatalogModels, Long> {
}
