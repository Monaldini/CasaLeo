package com.leo.CasaLeo.Ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.CasaLeo.dto.RawMaterialsDto;
import com.leo.CasaLeo.service.RawMaterialService;

@RestController
@RequestMapping("api/inventario/")
public class RawMaterialsCtr {
	@Autowired
	private RawMaterialService service;

	@PostMapping
	public ResponseEntity<RawMaterialsDto> addRawMaterial(@RequestBody RawMaterialsDto dto) {
		RawMaterialsDto savedMaterial = service.addRawMaterial(dto.getName(), dto.getCategory(), dto.getQuantity(),
				dto.getUnit());

		return ResponseEntity.ok(savedMaterial);
	}

	@PutMapping("/{name}")
	public ResponseEntity<RawMaterialsDto> updateRawMaterial(@PathVariable String name, @RequestBody RawMaterialsDto dto) {
		RawMaterialsDto updatedMaterial = service.updateRawMaterial(name, dto.getCategory(), dto.getQuantity(), dto.getUnit());
		return ResponseEntity.ok(updatedMaterial);
	}

}
