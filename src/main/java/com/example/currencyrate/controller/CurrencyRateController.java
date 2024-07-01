package com.example.currencyrate.controller;

import com.example.currencyrate.service.CurrencyRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Currency Rate", description = "Currency Rate management APIs.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencyRate")
public class CurrencyRateController {

    private final CurrencyRateService currencyService;

    @Operation(summary = "Geta all rates by date.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getCurrencyRatesList(@RequestParam String date) {
        return ResponseEntity.ok().body(currencyService.getCurrencyRatesByDate(date));
    }

    @Operation(summary = "Get ont rate by date and currency abbreviation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getCurrencyRate(@RequestParam String date, @RequestParam String currencyCode) {
        return ResponseEntity.ok().body(currencyService.getCurrencyByDateAndCurrencyCode(date, currencyCode));
    }
}
