package it.softx.northwind.model.service;

import java.util.List;

import org.springframework.lang.NonNull;

import it.softx.northwind.app.entity.PurchaseOrder;
import it.softx.northwind.model.dto.PurchaseOrderResourceDto;

public interface PurchaseOrderMapperService {

	List<PurchaseOrderResourceDto> mapToResourceList(@NonNull List<PurchaseOrder> purchList);

	PurchaseOrderResourceDto mapToResource(PurchaseOrder purch);


}