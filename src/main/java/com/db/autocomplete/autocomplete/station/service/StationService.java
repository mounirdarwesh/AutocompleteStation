package com.db.autocomplete.autocomplete.station.service;

import com.db.autocomplete.autocomplete.station.response.AutoCompleteResponse;

import java.util.List;

public interface StationService {
    AutoCompleteResponse getAutocompleteStations(String name);
    AutoCompleteResponse getAllStations();
}