package com.db.autocomplete.autocomplete.station.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String error_code;
    private String error_description;
}
