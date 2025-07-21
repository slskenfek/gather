package com.qather.distributed.event.log.out.repository;

import com.qather.distributed.event.log.out.entity.AccessLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogElasticRepository extends ElasticsearchRepository<AccessLogDocument, String> {
}
