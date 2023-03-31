package it.softx.northwind.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.softx.northwind.app.dao.CustomerDao;
import it.softx.northwind.app.dao.OrderDao;
import it.softx.northwind.app.dao.OrderDetailDao;
import it.softx.northwind.app.dao.ProductDao;
import it.softx.northwind.app.dao.PurchaseOrderDao;
import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.app.entity.Order;
import it.softx.northwind.app.entity.OrderDetail;
import it.softx.northwind.app.entity.OrderStatus;
import it.softx.northwind.app.entity.Product;
import it.softx.northwind.app.entity.PurchaseOrder;
import it.softx.northwind.model.dto.OrderDetailPostPatchDto;
import it.softx.northwind.model.dto.OrderPostPatchDto;
import it.softx.northwind.model.service.OrderDetailsMapperService;
import it.softx.northwind.model.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PurchaseOrderDao purDao;
	@Autowired
	private OrderDetailDao odDao;
	@Autowired
	private CustomerDao cusDao;
	@Autowired
	private OrderDetailsMapperService odMap;
	@Autowired
	private ProductDao prodDao;

	@Override
	public Order readOrderById(Long id) {
		return orderDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void createOrder(OrderPostPatchDto o) {

		Order order = new Order();
		List<OrderDetailPostPatchDto> od = o.getOrderDetails();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		Product prod;

		// creazione order
		long id = 1;
		List<Customer> cu = cusDao.findByEmailAddress(o.getUsername());
		order.setShipAddress(o.getAddress());
		order.setOrderStatus(new OrderStatus(id, "New"));
		for (Customer customer : cu) {
			order.setCustomer(customer);
			order = orderDao.save(order);
		}

		// creazione purchase
		purchaseOrder.setPaymentAmount(o.getPayment());
		purDao.save(purchaseOrder);

		// creazione order details

		for (OrderDetailPostPatchDto orderDetail : od) {
			OrderDetail orderDetailEntity = odMap.mapToEntity(orderDetail);
			prod = prodDao.findById(orderDetail.getProductId()).orElse(null);
			orderDetailEntity.setProduct(prod);
			orderDetailEntity.setOrder(order);
			odDao.save(orderDetailEntity);
		}
	}
}
