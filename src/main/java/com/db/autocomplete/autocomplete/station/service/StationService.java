package com.db.autocomplete.autocomplete.station.service;

import com.db.autocomplete.autocomplete.station.repository.StationRepository;
import com.db.autocomplete.autocomplete.station.model.Station;
import com.db.autocomplete.autocomplete.station.response.AutoCompleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    private final List<Station> stations;

    /**
     * load all Data from CSV file to List of Station Objects at init.
     * @param repository repo to read the CSV file.
     */
    public StationService(StationRepository repository) {
        this.stations = repository.loadDataFromCSV("src/main/resources/D_Bahnhof_2016_01_alle.csv");
    }

    /**
     * get Stations the contains the name
     * @param name the searched Name to be autocompleted
     * @return list of Station that contains the name
     */
    public AutoCompleteResponse autocompleteStation(String name){
        // for measuring the taken time to process the Request
        long startTime = System.currentTimeMillis();

        // filter the name after the Condition and create the right String Format.
        List<String> stationList = stations.stream()
                .filter(station -> station.getName().toLowerCase().contains(name.toLowerCase()))
                .map(station -> String.format("%s - %s - %s", station.getEvaNr(), station.getDs100(), station.getName()))
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return AutoCompleteResponse.builder()
                .station_list(stationList)
                .time_taken(timeTaken + " ms")
                .number_of_stations_found(stationList.size())
                .build();
    }

    /**
     * get all Stations
     * @return list of all Stations.
     */
    public AutoCompleteResponse getAllStations() {
        long startTime = System.currentTimeMillis();

        List<String> stationList = stations.stream()
                .map(station -> String.format("%s - %s - %s", station.getEvaNr(), station.getDs100(), station.getName()))
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return AutoCompleteResponse.builder()
                .station_list(stationList)
                .time_taken(timeTaken + " ms")
                .number_of_stations_found(stationList.size())
                .build();
    }
}
