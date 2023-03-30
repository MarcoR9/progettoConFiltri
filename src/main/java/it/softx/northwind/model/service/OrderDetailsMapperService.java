package it.softx.northwind.model.service;

import it.softx.northwind.app.entity.OrderDetail;
import it.softx.northwind.model.dto.OrderDetailPostPatchDto;

public interface OrderDetailsMapperService {

	OrderDetail mapToEntity(OrderDetailPostPatchDto o);

}