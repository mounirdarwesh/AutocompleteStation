# Train Station Autocomplete Web Service

This project provides a RESTful web service for autocompleting train station names in Germany. It uses Spring Boot and Java to implement the autocomplete functionality based on a CSV file containing station data.

## Requirements

- Java 17 
- Maven for dependency management

## Getting Started

1. Clone the repository:


    git clone git@github.com:mounirdarwesh/AutocompleteStation.git

Build the project: **_It's recommended to run inside Intellij because of the encoding._**

    cd AutocompleteStation
    mvn clean install

Run the application:

    mvn spring-boot:run

The application will start on http://localhost:8080.

## Usage

The web service provides a single endpoint for autocomplete:

* `GET /api/v1/auto-complete/{name}`: Returns a JSON response containing a list of stations that match the given name.

Example

To perform an autocomplete search for stations with the name "FRA", make a GET request to:

    GET /api/v1/auto-complete/FRA

Example response:

    {
    "station_list": [
    "8098105 - FFT - Frankfurt Hbf (tief)",
    "8070003 - FFLF - Frankfurt(M) Flughafen Fernbf",
    "8070004 - FFLU - Frankfurt(M) Flughafen Regionalbf"
    ],
    "time_taken": "0.2 ms",
    "number_of_stations_found": 3
    }

## Error Handling

The web service handles various error scenarios and provides appropriate error responses. Possible error scenarios include:

* Alphanumeric characters in the input: Returns a 400 Bad Request response with an error code and description.
* Missing or empty input parameter: Returns a 400 Bad Request response with an error code and description.
* Input parameter length less than three characters: Returns a 400 Bad Request response with an error code and description.

