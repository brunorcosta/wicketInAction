package com.mycompany.ui;

import java.io.Serializable;
import java.text.NumberFormat;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.mycompany.entity.Cheese;
import com.mycompany.ui.components.ShoppingCartPanel;

public class Index extends CheesrPage {
	public Index() {
		PageableListView cheeses = new PageableListView<Cheese>("cheeses",
				getCheeses(), 5) {
			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("description", cheese.getDescription()));
				item.add(new Label("price", "$" + cheese.getPrice()));
				item.add(new Link<Cheese>("add", item.getModel()) {

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						Cheese selected = getModelObject();
						getCart().getCheeses().add(selected);
					}
				});
			}
		};

		add(cheeses);
		add(new PagingNavigator("navigator", cheeses));
		add(new ShoppingCartPanel("shoppingcart", getCart()));
		add(new Link("checkout") {
			@Override
			public void onClick() {
				setResponsePage(new CheckOut());
			}

			@Override
			public boolean isVisible() {
				return !getCart().getCheeses().isEmpty();
			}
		});
	}
}
