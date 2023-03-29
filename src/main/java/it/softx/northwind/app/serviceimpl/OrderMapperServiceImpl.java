package it.softx.northwind.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.entity.Order;
import it.softx.northwind.model.dto.OrderResourceDto;
import it.softx.northwind.model.service.OrderMapperService;

@Service
public class OrderMapperServiceImpl implements OrderMapperService {

	@Override
	public OrderResourceDto mapToResource(Order order) {
		if (order == null) {
			return null;
		}
		OrderResourceDto ord = new OrderResourceDto();
		ord.setId(order.getId());
		ord.setShipAddress(order.getShipAddress());
		ord.setOrderStatus(order.getOrderStatus());
		ord.setCustomer(order.getCustomer());

		return ord;
	}

	@Override
	@NonNull
	public List<OrderResourceDto> mapToResourceList(@NonNull List<Order> ordList) {
		List<OrderResourceDto> orde = new ArrayList<>();
		for (Order o : ordList) {
			orde.add(mapToResource(o));
		}
		return orde;
	}

}
