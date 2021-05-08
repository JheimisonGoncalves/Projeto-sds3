package com.Jheimison.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jheimison.dsvendas.Services.SaleService;
import com.Jheimison.dsvendas.dto.SaleDTO;
import com.Jheimison.dsvendas.dto.SaleSuccessDTO;
import com.Jheimison.dsvendas.dto.SaleSumDTO;

@RestController
@RequestMapping(value = "/sales")
public class SaleControler {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupeBySeller() {
		List<SaleSumDTO> list = service.amountGroupeBySeller();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupeBySeller() {
		List<SaleSuccessDTO> list = service.successGroupeBySeller();
		return ResponseEntity.ok(list);
	}
}
