package com.tgtech.preferencecenter;

import com.tgtech.preferencecenter.model.MarketingPreference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMarketingPreferenceService {

    Page<MarketingPreference> retrieveMarketingPreferences(Pageable pageRequest);
}
