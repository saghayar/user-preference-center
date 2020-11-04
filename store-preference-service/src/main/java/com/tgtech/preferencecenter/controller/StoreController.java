package com.tgtech.preferencecenter.controller;

import com.tgtech.preferencecenter.dto.MarketingPreferenceDTO;
import com.tgtech.preferencecenter.model.MarketingPreference;
import com.tgtech.preferencecenter.service.IStoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.tgtech.preferencecenter.repository.Helper.fromString;

@RestController
@CrossOrigin
public class StoreController {

    private final IStoreService preferenceService;

    public StoreController(IStoreService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PostMapping("/preference/create")
    public ResponseEntity<MarketingPreference> createMarketingPreference(@RequestBody MarketingPreferenceDTO preferenceDTO) {
        final MarketingPreference preference = preferenceService.storeMarketingPreference(preferenceDTO);
        return ResponseEntity.ok(preference);
    }

    @PutMapping("/preference/edit")
    public ResponseEntity<MarketingPreference> editMarketingPreference(@RequestBody MarketingPreferenceDTO preferenceDTO,
                                                                       @RequestParam String preferenceId) {
        final MarketingPreference preference = preferenceService.editMarketingPreference(preferenceDTO,
                fromString(preferenceId));
        return ResponseEntity.ok(preference);
    }
}
