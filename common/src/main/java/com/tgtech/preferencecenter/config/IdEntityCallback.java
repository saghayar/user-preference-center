package com.tgtech.preferencecenter.config;

import com.tgtech.preferencecenter.model.MarketingPreference;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class IdEntityCallback implements BeforeConvertCallback<MarketingPreference>, Ordered {
    @Override
    public MarketingPreference onBeforeConvert(MarketingPreference mp, String collection) {
        if (isNull(mp.getId())) {
            mp.setId(UUID.randomUUID());
        }
        return mp;
    }

    @Override
    public int getOrder() {
        return 101;
    }
}