package it.softx.northwind.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.dao.PurchaseOrderDao;
import it.softx.northwind.app.entity.PurchaseOrder;
import it.softx.northwind.model.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
     
	@Autowired
	private PurchaseOrderDao poDao;
	
	@Override
	public PurchaseOrder readPurchaseOrderById(Long id) {
		return poDao.findById(id).orElse(null);
	}
	
}
