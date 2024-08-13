package com.searchservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.searchservice.model.IndexedTask;

@Repository
public interface TaskSearchRepository  extends ElasticsearchRepository<IndexedTask, Long>	{

}
