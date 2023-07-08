package com.db.autocomplete.autocomplete.station.repository;

import com.db.autocomplete.autocomplete.station.model.Station;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StationRepository {
    public List<Station> loadDataFromCSV(String csvFilePath) {
        List<Station> stations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    Station station = Station.builder()
                            .evaNr(parts[0])
                            .ds100(parts[1])
                            .name(parts[2])
                            .traffic(parts[3])
                            .length(Double.parseDouble(parts[4]))
                            .width((Double.parseDouble(parts[5])))
                            .build();

                    stations.add(station);
                }
            }
        } catch (IOException e) {
            // Handle file reading exception
            e.printStackTrace();
        }

        return stations;
    }
}
