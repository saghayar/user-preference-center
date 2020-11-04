package com.tgtech.preferencecenter.service;

import com.tgtech.preferencecenter.dto.MarketingPreferenceDTO;
import com.tgtech.preferencecenter.model.MarketingPreference;

import java.util.UUID;

public interface IStoreService {
    MarketingPreference storeMarketingPreference(MarketingPreferenceDTO preferenceDTO);

    MarketingPreference editMarketingPreference(MarketingPreferenceDTO preferenceDTO, UUID preferenceId);
}
