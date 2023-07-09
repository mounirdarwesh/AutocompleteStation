package com.db.autocomplete.autocomplete.station.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Autocomplete Class
 */
@Data
@Builder
public class AutoCompleteResponse {
    /**
     * list of Stations
     */
    private List<String> station_list;
    /**
     * taken Time of the HTTP Request
     */
    private String time_taken;
    /**
     * Number of Stations
     */
    private int number_of_stations_found;

}
