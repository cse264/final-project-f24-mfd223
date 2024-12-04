package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

// This class acts as the controller to handle weather API requests
@RestController
@RequestMapping("/api/weather") // Base endpoint for weather-related APIs
public class WeatherController {

    // API key for OpenWeatherMap API (replace this with your own for testing)
    private final String apiKey = "0dbe257664819cb480c15490a3d5013e";

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getWeather(
            @RequestParam String username,
            @RequestParam String city) {
        try {
            //  Get user information
            User user = userService.findUserByUsername(username);
            if (user == null) {
                throw new ResourceNotFoundException("User not found");
            }

            boolean isPaidUser = user.isPaidUser();

            // Free user: limit to USA
            if (!isPaidUser) {
                if (!city.toLowerCase().endsWith(", us")) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body("Free users can only access weather data within the United States.");
                }
            }

            // call Weather API
            RestTemplate restTemplate = new RestTemplate();

            // Geocoding API
            // Step 1: Use the Geocoding API to get latitude and longitude for the city
            String geoUrl = String.format(
                    "http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s",
                    city, apiKey
            );
            Map[] geoData = restTemplate.getForObject(geoUrl, Map[].class);

            if (geoData == null || geoData.length == 0) {
                throw new ResourceNotFoundException("City not found");
            }

            // Extract latitude and longitude
            double lat = (double) geoData[0].get("lat");
            double lon = (double) geoData[0].get("lon");

            // Current Weather API
             // Step 2: Use the Current Weather API to get weather details
            String weatherUrl = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s&units=metric",
                    lat, lon, apiKey
            );
            Map<String, Object> weatherData = restTemplate.getForObject(weatherUrl, Map.class);

            // If paid user, then add 5 days
            if (isPaidUser) {
                String forecastUrl = String.format(
                        "https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&appid=%s&units=metric",
                        lat, lon, apiKey                                         // Replace `apiKey` here for testing
                );
                Map<String, Object> forecastData = restTemplate.getForObject(forecastUrl, Map.class);

                if (forecastData != null && forecastData.containsKey("list")) {
                    weatherData.put("forecast", forecastData.get("list"));
                }
            }

            return ResponseEntity.ok(weatherData);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving weather data.");
        }
    }
}
