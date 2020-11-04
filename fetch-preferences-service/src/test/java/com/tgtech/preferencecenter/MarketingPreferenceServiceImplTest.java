package com.tgtech.preferencecenter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgtech.preferencecenter.model.MarketingPreference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MarketingPreferenceServiceImplTest {

    private final MarketingPreferenceRepository repository = Mockito.mock(MarketingPreferenceRepository.class);

    private final MarketingPreferenceServiceImpl preferenceService = new MarketingPreferenceServiceImpl(repository);

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void retrieveMarketingPreferencesTest() throws IOException, URISyntaxException {
        //Arrange
        final List<MarketingPreference> actualPreferences = loadMarketingPreferences();
        final Page<MarketingPreference> marketingPreferencePage = new PageImpl<>(actualPreferences);
        when(repository.findAll(any(Pageable.class))).thenReturn(marketingPreferencePage);

        //Act
        final Pageable pageable = Pageable.unpaged();
        final Page<MarketingPreference> expectedMarketingPreferencesPage = preferenceService.retrieveMarketingPreferences(pageable);
        final List<MarketingPreference> expectedMarketingPreferences = expectedMarketingPreferencesPage.getContent();

        //Assert
        assertEquals(expectedMarketingPreferences.size(), actualPreferences.size());
    }

    private List<MarketingPreference> loadMarketingPreferences() throws IOException, URISyntaxException {
        return mapper.readValue(readJsonToString(), new TypeReference<>() {
        });
    }

    private String readJsonToString() throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(requireNonNull(getClass().getClassLoader()
                .getResource("mock-data.json")).toURI())));
    }

}
