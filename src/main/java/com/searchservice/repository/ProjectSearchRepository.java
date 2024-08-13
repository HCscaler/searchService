package com.searchservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.searchservice.model.IndexedProject;

public interface ProjectSearchRepository extends ElasticsearchRepository<IndexedProject, Long> {

}
