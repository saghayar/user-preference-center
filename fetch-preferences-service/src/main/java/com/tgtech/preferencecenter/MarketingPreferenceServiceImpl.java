package com.tgtech.preferencecenter;

import com.tgtech.preferencecenter.model.MarketingPreference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MarketingPreferenceServiceImpl implements IMarketingPreferenceService {

    private MarketingPreferenceRepository preferenceRepository;

    public MarketingPreferenceServiceImpl(MarketingPreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Page<MarketingPreference> retrieveMarketingPreferences(Pageable pageRequest) {
        return preferenceRepository.findAll(pageRequest);
    }
}
