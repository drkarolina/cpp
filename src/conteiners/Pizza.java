package conteiners;

import java.time.LocalTime;
import java.util.EnumMap;

import enums.Ingridients;

public class Pizza {
	
	private int id;
	private String name;
	private LocalTime time;
	private EnumMap<Ingridients,Boolean> ingridients;
	private String status;
	
	//constructors
	Pizza()
	{
		time = LocalTime.of(0, 15);
		name = "";
		ingridients = new EnumMap<Ingridients,Boolean>(Ingridients.class);
	}
	
	public Pizza(int newId, String newName, String status)
	{
		this.id = newId;
		this.name = newName;
		this.status = status;
	}
	
	//getters
	String getPizzaStatus()
	{
		return this.status;
	}
	
	public int getPizzaId()
	{
		return this.id;
	}
	
	String getPizzaName()
	{
		return this.name;
	}
	
	LocalTime getPizzaTime()
	{
		return this.time;
	}
	
	public EnumMap<Ingridients,Boolean> getPizzaIngridients()
	{
		return this.ingridients;
	}
	
	//setters
	public Pizza setDefaultPizzaIngridients(String pizzaName)
	{
		switch(pizzaName) 
		{
		case "Hawaiian":
			this.name = "Hawaiian";
			ingridients.put(Ingridients.SAUCE,true);
			ingridients.put(Ingridients.CHICKEN,true);
			ingridients.put(Ingridients.CORN,true);
			ingridients.put(Ingridients.PINEAPPLE,true);
			ingridients.put(Ingridients.CHEESE,true);
		case "Margherita":
			this.name = "Margherita";
			ingridients.put(Ingridients.TOMATOES,true);
			ingridients.put(Ingridients.BASIL,true);
			ingridients.put(Ingridients.CHEESE,true);
		case "Pepperoni":
			this.name = "Pepperoni";
			ingridients.put(Ingridients.TOMATOES,true);
			ingridients.put(Ingridients.SAUSAGES,true);
			ingridients.put(Ingridients.CHEESE,true);
		case "4 Seasons":
			this.name = "4 Seasons";
			ingridients.put(Ingridients.TOMATOES,true);
			ingridients.put(Ingridients.SAUSAGES,true);
			ingridients.put(Ingridients.CHICKEN,true);
			ingridients.put(Ingridients.MUSHROOMS,true);
			ingridients.put(Ingridients.OLIVES,true);
			ingridients.put(Ingridients.BASIL,true);
			ingridients.put(Ingridients.CHEESE,true);
		case "Pickles Pizza":
			this.name = "Pickles Pizza";
			ingridients.put(Ingridients.TOMATOES,true);
			ingridients.put(Ingridients.PICKLES,true);
			ingridients.put(Ingridients.OLIVES,true);
			ingridients.put(Ingridients.CORN,true);
			ingridients.put(Ingridients.SAUSAGES,true);
			ingridients.put(Ingridients.CHEESE,true);
		}
		return this;
	}
	
	void putIngridient(Ingridients item, boolean status)
	{
		this.ingridients.put(item, status);
	}
	
	void setPizzaId(int id)
	{
		this.id = id;
	}
	
	void setPizzaName(String name)
	{
		this.name = name;
	}
	
	void setPizzaTime(LocalTime time)
	{
		this.time = time;
	}
	
	public void setPizzaStatus(String status)
	{
		this.status = status;
	}

}
