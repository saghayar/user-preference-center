package com.tgtech.preferencecenter;

import com.tgtech.preferencecenter.model.MarketingPreference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MarketingPreferenceController {

    private final IMarketingPreferenceService preferenceService;

    public MarketingPreferenceController(IMarketingPreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping("/preferences")
    public ResponseEntity<Page<MarketingPreference>> retrievePreferences(Pageable pageable) {
        final Page<MarketingPreference> build = preferenceService.retrieveMarketingPreferences(pageable);
        return ResponseEntity.ok(build);
    }
}
