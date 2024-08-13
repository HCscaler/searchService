package com.searchservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.searchservice.model.IndexedUser;

public interface UserSearchRepository extends ElasticsearchRepository<IndexedUser, Long> {

}
