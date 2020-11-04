package com.tgtech.preferencecenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "preferences")
public class MarketingPreference {

    @Id
    private UUID id;
    private DescriptiveData descriptiveData;
    private BehavioralData behavioralData;
    private IdentityData identityData;
    private PreferenceType preferenceType;
}
