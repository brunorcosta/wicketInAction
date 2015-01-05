package com.mycompany;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import com.mycompany.entity.Cheese;
import com.mycompany.ui.Index;

public class CheesrApplication extends WebApplication{
	private List<Cheese> cheeses = Arrays.asList(
			new Cheese("Gouda", "Gouda desc", 1.65),
			new Cheese("Edam", "Edam desc", 1.05),
			new Cheese("Maasdam", "Maasdam desc", 2.35),
			new Cheese("Brie", "Brie desc", 3.15),
			new Cheese("Buxton Blue", "Buxton Blue desc", 0.99),
			new Cheese("Parmesan", "Parmesan desc", 1.99),
			new Cheese("Cheddar", "Cheddar desc", 2.95),
			new Cheese("Roquefort", "Roquefort desc", 1.67),
			new Cheese("Boursin", "Boursin desc", 1.33),
			new Cheese("Camembert", "Camembert desc", 1.69),
			new Cheese("Emmental", "Emmental desc", 2.39),
			new Cheese("Reblochon", "Reblochon desc", 2.99)
			);
	
	public CheesrApplication(){
	}
	
	@Override
	protected void init() {
	}
	
	public static CheesrApplication get(){
		return (CheesrApplication) Application.get();
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Index.class;
	}

	public List<Cheese> getCheeses() {
		return Collections.unmodifiableList(cheeses);
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new CheesrSession(request);
	}
	
	
}
