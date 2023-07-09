package com.db.autocomplete.autocomplete.station.repository;

import com.db.autocomplete.autocomplete.station.model.Station;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * read CSV file and map it to List of Station Objects
 */
@Repository
public class StationRepositoryImpl implements StationRepository {
    private static final String CSV_FILE_PATH = "src/main/resources/D_Bahnhof_2016_01_alle.csv";

    @Override
    public List<Station> getAll() {
        List<Station> stations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                // skip first line in the csv file
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                // read file part and map it to Station Object
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
