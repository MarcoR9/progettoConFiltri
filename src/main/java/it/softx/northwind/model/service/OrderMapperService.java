package it.softx.northwind.model.service;

import java.util.List;

import org.springframework.lang.NonNull;

import it.softx.northwind.app.entity.Order;
import it.softx.northwind.model.dto.OrderResourceDto;

public interface OrderMapperService {

	List<OrderResourceDto> mapToResourceList(@NonNull List<Order> ordList);

	OrderResourceDto mapToResource(Order order);

}