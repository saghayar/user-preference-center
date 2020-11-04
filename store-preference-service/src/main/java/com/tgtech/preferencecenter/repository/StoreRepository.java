package com.tgtech.preferencecenter.repository;

import com.tgtech.preferencecenter.model.MarketingPreference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends MongoRepository<MarketingPreference, UUID> {
}
