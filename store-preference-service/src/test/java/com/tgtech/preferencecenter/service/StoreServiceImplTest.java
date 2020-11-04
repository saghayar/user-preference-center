package com.tgtech.preferencecenter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgtech.preferencecenter.dto.MarketingPreferenceDTO;
import com.tgtech.preferencecenter.model.MarketingPreference;
import com.tgtech.preferencecenter.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class StoreServiceImplTest {

    private static final String NEW_EMAIL = "myNewEmail@dmail.com";
    private static final Integer NEW_AGE = 96;
    private final StoreRepository repository = Mockito.mock(StoreRepository.class);
    private final StoreServiceImpl storeService = new StoreServiceImpl(repository);

    private final ArgumentCaptor<MarketingPreference> preferenceArgumentCaptor = ArgumentCaptor
            .forClass(MarketingPreference.class);

    private final ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor
            .forClass(UUID.class);


    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void storeMarketingPreferenceHappyFlow() throws IOException, URISyntaxException {
        //Arrange
        final MarketingPreference actualMP = createMP();
        when(repository.save(preferenceArgumentCaptor.capture())).thenReturn(actualMP);

        //Act
        final MarketingPreferenceDTO mpDto = createMPDto();
        final MarketingPreference expectedMP = storeService.storeMarketingPreference(mpDto);

        //Assert
        verify(repository, times(1)).save(preferenceArgumentCaptor.getValue());
        verifyNoMoreInteractions(repository);

        assertEquals(expectedMP.getIdentityData().getEmail(), actualMP.getIdentityData().getEmail());
        assertEquals(expectedMP.getIdentityData().getAge(), actualMP.getIdentityData().getAge());
        assertEquals(expectedMP.getIdentityData().getPostalCode(), actualMP.getIdentityData().getPostalCode());
    }

    @Test
    void shouldEditMarketingPreferenceEmailAndAgeSuccessfully() throws IOException, URISyntaxException {
        //Arrange
        final MarketingPreference actualMP = createMP();
        final Optional<MarketingPreference> optActualMP = Optional.of(actualMP);
        when(repository.findById(uuidArgumentCaptor.capture())).thenReturn(optActualMP);
        when(repository.save(preferenceArgumentCaptor.capture())).thenReturn(actualMP);

        //Act
        final MarketingPreferenceDTO updatedDto = updateEmailAndAge(createMPDto());

        final MarketingPreference expectedMP = storeService.editMarketingPreference(updatedDto, actualMP.getId());

        //Assert
        verify(repository, times(1)).save(preferenceArgumentCaptor.getValue());
        verify(repository, times(1)).findById(uuidArgumentCaptor.getValue());
        verifyNoMoreInteractions(repository);

        assertEquals(actualMP.getId(), uuidArgumentCaptor.getValue());

        assertEquals(expectedMP.getIdentityData().getEmail(), NEW_EMAIL);
        assertEquals(expectedMP.getIdentityData().getAge(), NEW_AGE);
    }

    private MarketingPreferenceDTO updateEmailAndAge(MarketingPreferenceDTO mpDto) {
        mpDto.getIdentityData().setEmail(NEW_EMAIL);
        mpDto.getIdentityData().setAge(NEW_AGE);
        return mpDto;
    }

    private MarketingPreferenceDTO createMPDto() throws IOException, URISyntaxException {
        return loadMPDto();
    }

    private MarketingPreference createMP() throws IOException, URISyntaxException {
        return loadMP();
    }

    private MarketingPreferenceDTO loadMPDto() throws IOException, URISyntaxException {
        return mapper.readValue(readJsonToString(), MarketingPreferenceDTO.class);
    }

    private MarketingPreference loadMP() throws IOException, URISyntaxException {
        return mapper.readValue(readJsonToString(), MarketingPreference.class);
    }

    private String readJsonToString() throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(requireNonNull(getClass().getClassLoader()
                .getResource("mock-data.json")).toURI())));
    }
}