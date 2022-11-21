package conteiners;

import java.util.ArrayList;

public class Menu {
	
	public ArrayList<Pizza> pizzaMenu = new ArrayList<Pizza>();
	
	public Menu(){}
	
	public ArrayList<Pizza> getPizzaMenu(String name)
	{
		return this.pizzaMenu;
	}

	public Pizza findPizzaInMenu(String name)
	{
		Pizza result = new Pizza();
		for(Pizza item:pizzaMenu)
		{
			if(item.getPizzaName().equals(name))
			{
				result = item;
			}
		}
		return result;
	}
}
