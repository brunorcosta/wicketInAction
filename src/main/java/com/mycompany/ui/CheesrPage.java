package com.mycompany.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;

import com.mycompany.CheesrApplication;
import com.mycompany.CheesrSession;
import com.mycompany.entity.Cart;
import com.mycompany.entity.Cheese;

public abstract class CheesrPage extends WebPage {

	public CheesrSession getCheesrSession(){
		return (CheesrSession) getSession();
	}
	
	public Cart getCart(){
		return getCheesrSession().getCart();
	}
	
	public List<Cheese> getCheeses() {
		return CheesrApplication.get().getCheeses();
	}
}
