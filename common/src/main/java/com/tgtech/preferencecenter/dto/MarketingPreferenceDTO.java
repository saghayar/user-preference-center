package com.tgtech.preferencecenter.dto;

import com.tgtech.preferencecenter.model.BehavioralData;
import com.tgtech.preferencecenter.model.DescriptiveData;
import com.tgtech.preferencecenter.model.IdentityData;
import com.tgtech.preferencecenter.model.PreferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MarketingPreferenceDTO {

    private UUID id;
    private DescriptiveData descriptiveData;
    private BehavioralData behavioralData;
    private IdentityData identityData;
    private PreferenceType preferenceType;
}
