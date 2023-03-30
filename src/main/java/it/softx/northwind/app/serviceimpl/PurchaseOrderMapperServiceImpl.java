package it.softx.northwind.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.entity.PurchaseOrder;
import it.softx.northwind.model.dto.PurchaseOrderResourceDto;
import it.softx.northwind.model.service.PurchaseOrderMapperService;


@Service
public class PurchaseOrderMapperServiceImpl implements PurchaseOrderMapperService {
	
	@Override
	public PurchaseOrderResourceDto mapToResource(PurchaseOrder purch) {
		if(purch == null) {
			return null;
		}
		PurchaseOrderResourceDto dto = new PurchaseOrderResourceDto();
		dto.setId(purch.getId());
		dto.setAmount(purch.getPaymentAmount());
		
		return dto;
	}
	
	
	@Override
	@NonNull
	public List<PurchaseOrderResourceDto> mapToResourceList(@NonNull List<PurchaseOrder> purchList){
		List<PurchaseOrderResourceDto> purch = new ArrayList<>();
		for(PurchaseOrder p : purchList) {
			purch.add(mapToResource(p));
		}
	  return purch;
	}


}
