package com.Jheimison.dsvendas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Jheimison.dsvendas.dto.SaleDTO;
import com.Jheimison.dsvendas.dto.SaleSuccessDTO;
import com.Jheimison.dsvendas.dto.SaleSumDTO;
import com.Jheimison.dsvendas.entities.Sale;
import com.Jheimison.dsvendas.repositories.SaleRepository;
import com.Jheimison.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupeBySeller() {
		return repository.amountGroupeBySeller();
	}
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupeBySeller() {
		return repository.successGroupeBySeller();
	}
}
