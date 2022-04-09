package com.zuhlke.bg.camp.api;

import com.zuhlke.bg.camp.data.AnimalDto;
import com.zuhlke.bg.camp.service.AnimalDetails;
import com.zuhlke.bg.camp.service.ZooManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class ZooManagerController {

    private final ZooManagerService zooManagerService;

    public ZooManagerController(ZooManagerService zooManagerService) {
        this.zooManagerService = zooManagerService;
    }

    @Operation(summary = "Get general data for all animals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Animals found",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AnimalDto.class))
                    )})
    })
    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {
        return ResponseEntity.ok(zooManagerService.getAnimals());
    }

    @Operation(summary = "Get details for an animal by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Animal details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AnimalDetails.class))}),
            @ApiResponse(responseCode = "404", description = "Animal not found",
                    content = @Content)
    })
    @GetMapping("{name}")
    public ResponseEntity<AnimalDetails> getAnimalDetails(@PathVariable String name) {
        return ResponseEntity.ok(zooManagerService.getAnimalDetails(name));
    }
}
