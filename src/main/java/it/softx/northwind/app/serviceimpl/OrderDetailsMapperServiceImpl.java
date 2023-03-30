package it.softx.northwind.app.serviceimpl;

import org.springframework.stereotype.Service;

import it.softx.northwind.app.entity.OrderDetail;
import it.softx.northwind.model.dto.OrderDetailPostPatchDto;
import it.softx.northwind.model.service.OrderDetailsMapperService;

@Service
public class OrderDetailsMapperServiceImpl implements OrderDetailsMapperService {
	
	
	@Override
	public OrderDetail mapToEntity(OrderDetailPostPatchDto o) {
		OrderDetail od=new OrderDetail();
		od.setQuantity(o.getQuantity());
		
		return od;
	}
	
}
