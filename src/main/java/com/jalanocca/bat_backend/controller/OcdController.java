
package com.jalanocca.bat_backend.controller;

import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalanocca.bat_backend.model.dto.GenericResponseDto;
import com.jalanocca.bat_backend.model.dto.ocd.OcdBodyConfig;
import com.jalanocca.bat_backend.service.ExcelChecklistService;
import com.jalanocca.bat_backend.service.OcdService;

@RestController
@RequestMapping("/api/ocd")
public class OcdController {

    private final OcdService ocdService;
	private final ExcelChecklistService service;

    public OcdController(OcdService ocdService, ExcelChecklistService service) {
        this.ocdService = ocdService;
		this.service = service;
    }

	@PostMapping
	public ResponseEntity<GenericResponseDto> recibirOcdBody(
			@RequestBody OcdBodyConfig body,
			@RequestParam Long appId) throws Exception {
		return ResponseEntity.ok(ocdService.createOcdDelivery(appId, body));
	}

	@GetMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        InputStreamResource file =
                new InputStreamResource(service.generateExcel());

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=Checklist.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }
}
