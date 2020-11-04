package com.tgtech.preferencecenter.service;

import com.tgtech.preferencecenter.dto.MarketingPreferenceDTO;
import com.tgtech.preferencecenter.error.PreferenceNotFoundException;
import com.tgtech.preferencecenter.model.MarketingPreference;
import com.tgtech.preferencecenter.repository.StoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StoreServiceImpl implements IStoreService {

    private final StoreRepository preferenceRepository;
    private ModelMapper modelMapper;

    public StoreServiceImpl(StoreRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
        this.modelMapper = new ModelMapper();

        modelMapper.typeMap(MarketingPreferenceDTO.class, MarketingPreference.class)
                .addMappings(mapper -> mapper.skip(MarketingPreference::setId));
    }

    @Override
    public MarketingPreference storeMarketingPreference(MarketingPreferenceDTO preferenceDTO) {
        final MarketingPreference marketingPreference = toEntity(preferenceDTO);
        return preferenceRepository.save(marketingPreference);
    }

    private MarketingPreference toEntity(MarketingPreferenceDTO preferenceDTO) {
        return modelMapper.map(preferenceDTO, MarketingPreference.class);
    }

    @Override
    public MarketingPreference editMarketingPreference(MarketingPreferenceDTO dto, UUID preferenceId) {
        final MarketingPreference marketingPreference = preferenceRepository.findById(preferenceId)
                .orElseThrow(PreferenceNotFoundException::new);
        marketingPreference.setBehavioralData(dto.getBehavioralData());
        marketingPreference.setDescriptiveData(dto.getDescriptiveData());
        marketingPreference.setIdentityData(dto.getIdentityData());
        marketingPreference.setPreferenceType(dto.getPreferenceType());
        return preferenceRepository.save(marketingPreference);
    }

}
