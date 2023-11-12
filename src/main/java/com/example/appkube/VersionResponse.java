package com.example.appkube;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VersionResponse {
    String message;
    int version;
}
