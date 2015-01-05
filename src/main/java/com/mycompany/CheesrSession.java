package com.mycompany;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.mycompany.entity.Cart;

public class CheesrSession extends WebSession {
	private Cart cart = new Cart();
	
	protected CheesrSession(Request request) {
		super(request);
	}

	public Cart getCart() {
		return cart;
	}

}
