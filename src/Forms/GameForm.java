package Forms;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import conteiners.*;
import enums.ECookType;
import system.PizzaSystem;
import system.Kitchen.Cook;

public class GameForm {
	int cookCount;
	private JFrame frame;
	private PizzaSystem system;
	private JPanel contentPane;
	private JTable tablePizza;
	private JTable tableOrder;
	private JTable tableCustomer;
	private JLabel lblNewLabel;
	private JLabel lblCustomer;
	private JLabel lblPizzas;
	private JTable tableChefs;
	private JLabel lblChefs;
	private JButton buttonStop;
	private JButton buttonBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameForm window = new GameForm(ECookType.STANDART,1,1,1,60000);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameForm(ECookType cooktype,int registersCount,int cookCount,int pizzaCount,int orderPeriod) {
		system = PizzaSystem.getInstance(cooktype, registersCount, cookCount, pizzaCount,orderPeriod);
		initialize();
		this.frame.setVisible(true);
	}
	Timer updateInfo = new Timer(2, e->{		
		var orders = system.kitchen.getOrders();
		for (var order  : orders) {
			DefaultTableModel model = (DefaultTableModel) tablePizza.getModel();
			if(orders.size() == model.getRowCount())
			{
				model.insertRow(order.GetId(),new Object[]{Log.GetCustommers().get(order.GetId()).GetName(),order.GetPizzasList().get(0).getPizzaStatus(),"0","0"});
				model.removeRow(order.GetId()+1);
			}else
			{
				model.addRow(new Object[]{Log.GetCustommers().get(order.GetId()).GetName(),order.GetPizzasList().get(0).getPizzaStatus(),"0","0"});
			}
			tablePizza.setModel(model);
		}
		var cooks = system.kitchen.getCooks();
		Iterator it = cooks.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair=(Map.Entry)it.next();
			DefaultTableModel model = (DefaultTableModel) tableChefs.getModel();
			if(cooks.size() == model.getRowCount()-1)
			{
				model.insertRow((int)pair.getKey(),new Object[]{(int)pair.getKey(),(Boolean)pair.getValue() == true?"Chilling":"Working"});
				model.removeRow((int)pair.getKey());
			}else
			{
				model.addRow(new Object[]{(int)pair.getKey(),(Boolean)pair.getValue() == true?"Chilling":"Working"});
			}
			tableChefs.setModel(model);
		}
		var customers = system.customers;
		for (Customer customer : customers) {
			DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
			if(customers.size() == model.getRowCount())
			{
				model.insertRow(customer.GetId(),new Object[]{customer.GetName(),customer.GetLine(),customer.GetOrder().GetId(),"0","0"});
				model.removeRow(customer.GetId()+1);
			}else
			{
				model.addRow(new Object[]{customer.GetName(),customer.GetLine(),customer.GetOrder().GetId(),"0","0"});
			}
			tableCustomer.setModel(model);
		}
		
		for(var order  : orders )
		{
			DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
			if(orders.size() == model.getRowCount())
			{
				model.insertRow(order.GetId(),new Object[]{customers.get(order.GetId()).GetName(),order.GetPizzasList().get(0).getPizzaName(),"0","0"});
				model.removeRow(order.GetId()+1);
			}else
			{
				model.addRow(new Object[]{customers.get(order.GetId()).GetName(),order.GetPizzasList().get(0).getPizzaName(),"0","0"});
			}
			tableOrder.setModel(model);
		}
	});
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nasti\\Downloads\\pizza-slice.png"));
		frame.setTitle("Pizzeria");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 893, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 252, 154));
		contentPane.setBorder(null);

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tablePizza = new JTable();
		tablePizza.setModel(new DefaultTableModel(
			new Object[][] {
				{"Customer", "Status", "Start time", "End time"},
			},
			new String[] {
				"Customer", "Status", "Start time", "End time"
			}
		));
		tablePizza.setBounds(469, 43, 366, 200);
		contentPane.add(tablePizza);
		
		tableOrder = new JTable();
		tableOrder.setModel(new DefaultTableModel(
			new Object[][] {
				{"Customer", "Pizzas", "Status", "Queue", "Start time", "End time"},
			},
			new String[] {
				"Customer", "Pizzas", "Status", "Queue", "Start time", "End time"
			}
		));
		tableOrder.setBounds(22, 43, 366, 200);
		contentPane.add(tableOrder);
		
		tableCustomer = new JTable();
		tableCustomer.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Queue", "Order ID"},
			},
			new String[] {
				"Name", "QueueCustomer", "OrderID"
			}
		));
		tableCustomer.setBounds(22, 276, 366, 200);
		contentPane.add(tableCustomer);
		
		lblNewLabel = new JLabel("Orders");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(174, 20, 58, 13);
		contentPane.add(lblNewLabel);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCustomer.setBounds(162, 253, 81, 13);
		contentPane.add(lblCustomer);
		
		lblPizzas = new JLabel("Pizzas");
		lblPizzas.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPizzas.setBounds(625, 20, 58, 13);
		contentPane.add(lblPizzas);
		
		tableChefs = new JTable();
		tableChefs.setModel(new DefaultTableModel(
			new Object[][] {
				{"Chef", "Status"},
			},
			new String[] {
				"Chef", "Status"
			}
		));
		tableChefs.setBounds(469, 276, 366, 100);
		contentPane.add(tableChefs);
		
		lblChefs = new JLabel("Chefs");
		lblChefs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChefs.setBounds(625, 253, 58, 13);
		contentPane.add(lblChefs);
		
		buttonStop = new JButton("Stop");
		buttonStop.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		buttonStop.setBounds(710, 422, 134, 56);
		contentPane.add(buttonStop);
		
		buttonBack = new JButton("Back");
		buttonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				StartForm form = new StartForm();
			}
		});
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		buttonBack.setBounds(553, 422, 134, 56);
		contentPane.add(buttonBack);
		updateInfo.start();
	}




}
