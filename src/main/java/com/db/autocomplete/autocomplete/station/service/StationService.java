package com.db.autocomplete.autocomplete.station.service;

import com.db.autocomplete.autocomplete.station.model.response.AutoCompleteResponse;

public interface StationService {
    AutoCompleteResponse getAutocompleteStations(String name);
    AutoCompleteResponse getAllStations();
}