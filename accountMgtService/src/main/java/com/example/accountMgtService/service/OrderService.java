package com.example.accountMgtService.service;

import javax.validation.Valid;


import com.example.accountMgtService.model.Sorder;
import com.sun.istack.NotNull;

public interface OrderService {
	
	@NotNull Iterable<Sorder> getAllOrders();

	Sorder create(@NotNull @Valid Sorder sorder);

    void update(@NotNull @Valid Sorder sorder);
}
