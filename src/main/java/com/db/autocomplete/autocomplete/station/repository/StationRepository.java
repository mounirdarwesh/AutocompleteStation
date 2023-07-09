package com.db.autocomplete.autocomplete.station.repository;

import com.db.autocomplete.autocomplete.station.model.Station;

import java.util.List;

public interface StationRepository {

    List<Station> getAll();
}