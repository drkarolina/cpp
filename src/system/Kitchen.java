package system;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import conteiners.Command;
import conteiners.Order;
import conteiners.Pizza;
import enums.ECommand;
import enums.ECookType;
import enums.EnumStatuses;
import enums.Ingridients;


public class Kitchen{
    private static LinkedBlockingQueue<Command> queue_commands = new LinkedBlockingQueue<>();

    private static Vector<Order> orders = new Vector<>();

    private static Vector<Boolean> chillCook = new Vector<>();

    private static ReentrantLock mutex = new ReentrantLock();

    private Vector<Cook> cooks = new Vector<>();


    Kitchen(Integer _cookCount, ECookType _type){
        for (int i = 0; i != _cookCount; i++){
            cooks.add(new Cook(i, _type));
            chillCook.add(false);
            cooks.get(i).start();
        }
    }

    public Vector<Boolean> getChillCooks(){
        return chillCook;
    }

    public Vector<Order> getOrders(){
        return orders;
    }

    public void stop(){
        for (int i = 0; i != cooks.size(); i++){
            cooks.get(i).exit();
        }
    }

    public void delay(Integer time){
        for (int i = 0; i != cooks.size(); i++){
            cooks.get(i).chill(time);
        }
    }

    public void addOrder(Order _order){
        orders.add(_order);
        setOrderToCommand(_order);
    }


    public void addCommand(Command _command){
        queue_commands.add(_command);
    }

    private void setOrderToCommand(Order _order){
        ArrayList<Pizza> pizza = _order.GetPizzasList();
        for (int i = 0;i !=pizza.size();++i){
            List<Ingridients> in =  pizza.get(i).getPizzaIngridients().keySet().stream().toList();
            for (int ingradients = 0; ingradients != in.size(); ++ingradients){
                switch (in.get(ingradients)){
                    case DOUGH:
                        addCommand(new Command(ECommand.KANEAD_DOUGH, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case PICKLES:
                        addCommand(new Command(ECommand.PUT_PICKLES, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case MUSHROOMS:
                        addCommand(new Command(ECommand.PUT_MUSHROOMS, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case BASIL:
                        addCommand(new Command(ECommand.PUT_BASIL, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case TOMATOES:
                        addCommand(new Command(ECommand.PUT_TOMATOES, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case SAUSAGES:
                        addCommand(new Command(ECommand.PUT_SAUSAGE, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case OLIVES:
                        addCommand(new Command(ECommand.PUT_OLIVES, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case CORN:
                        addCommand(new Command(ECommand.PUT_CORN, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case CHICKEN:
                        addCommand(new Command(ECommand.PUT_CHICKEN, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case CHEESE:
                        addCommand(new Command(ECommand.PUT_CHEESE, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case PINEAPPLE:
                        addCommand(new Command(ECommand.PUT_PINEAPPLE, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                    case SAUCE:
                        addCommand(new Command(ECommand.PUT_SAUCE, pizza.get(i).getPizzaId(), _order.GetId()));
                        break;
                }
            }
            addCommand(new Command(ECommand.TO_BAKE, pizza.get(i).getPizzaId(), _order.GetId()));
        }
    }

    static class Cook extends Thread {
        private Integer ID;

        ECookType type;

        private final Integer time_of_work = 3000;

        private Integer cout_of_commands;

        private Boolean exit = false;

        Cook(final Integer _ID, final ECookType _type) {
            ID = _ID;
            type = _type;
            cout_of_commands = 0;
        }

        private void DoWork() {
            cout_of_commands++;
            try {
                Thread.sleep(getWorkTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void DoWork(Integer countOfwork) {
            cout_of_commands++;
            try {
                Thread.sleep(getWorkTime()*countOfwork);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private int getWorkTime() {
            return (int) ((Math.random() * (time_of_work + ((time_of_work / 100) * cout_of_commands) - time_of_work)) + time_of_work);
        }

        private void chill() {
            chillCook.set(ID, true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chillCook.set(ID, false);
            cout_of_commands--;
        }

        private void chill(Integer time) {
            chillCook.set(ID, true);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chillCook.set(ID, false);
            cout_of_commands--;
        }

        private void exit() {
            exit = true;
        }

        public void run() {
            if(type == ECookType.STANDART){
                while (!exit) {
                    mutex.lock();
                        if (!queue_commands.isEmpty()) {
                            Command command = new Command(queue_commands.remove());
                            mutex.unlock();
                            DoWork();
                            switch (command.getCommand_type()) {
                                case KANEAD_DOUGH:
                                    System.out.println(command.getPizza_ID()+ " " + command.getOrder_ID() + "kneading" + " " + orders.get(command.getOrder_ID()).toString() + " pizzaID ");
                                    orders.get(command.getOrder_ID()).GetPizzasList().get(command.getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.kneading));
                                    break;
                                case PUT_PICKLES:
                                case PUT_MUSHROOMS:
                                case PUT_BASIL:
                                case PUT_TOMATOES:
                                case PUT_SAUSAGE:
                                case PUT_OLIVES:
                                case PUT_CHEESE:
                                case PUT_PINEAPPLE:
                                case PUT_SAUCE:
                                case PUT_CORN:
                                orders.get(command.getOrder_ID()).GetPizzasList().get(command.getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.adding_ingridients));
                                    break;
                                case TO_BAKE:
                                    orders.get(command.getOrder_ID()).GetPizzasList().get(command.getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.baking));
                                    break;
                            }
                            if(!queue_commands.isEmpty()) {
                                if (queue_commands.peek().getPizza_ID() != command.getPizza_ID()) {
                                    orders.get(command.getOrder_ID()).GetPizzasList().get(command.getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.ready));
                                }
                            }else {
                                orders.get(command.getOrder_ID()).GetPizzasList().get(command.getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.ready));
                            }
                        } else {

                            mutex.unlock();
                            chill();
                        }
                    }
            }else{
                while (!exit) {
                    chill();
                    mutex.lock();
                    if (!queue_commands.isEmpty()) {
                        Vector<Command> toDo = new Vector<>();
                        Integer toDoPizzaID = queue_commands.peek().getPizza_ID();
                        while (queue_commands.peek().getPizza_ID() == toDoPizzaID) {
                            toDo.add(new Command(queue_commands.remove()));
                            if(queue_commands.isEmpty()){
                                chill(10);
                                if(queue_commands.isEmpty()){
                                    break;
                                }
                            }
                        }

                        mutex.unlock();
                        DoWork(toDo.size());
                        for (int i = 0; i < toDo.size(); ++i) {
                            switch (toDo.get(i).getCommand_type()) {
                                case KANEAD_DOUGH:
                                    orders.get(toDo.get(0).getOrder_ID()).GetPizzasList().get(toDo.get(0).getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.kneading));
                                    break;
                                case PUT_PICKLES:
                                case PUT_MUSHROOMS:
                                case PUT_BASIL:
                                case PUT_TOMATOES:
                                case PUT_SAUSAGE:
                                case PUT_OLIVES:
                                case PUT_CHEESE:
                                case PUT_PINEAPPLE:
                                case PUT_SAUCE:
                                case PUT_CORN:
                                    orders.get(toDo.get(0).getOrder_ID()).GetPizzasList().get(toDo.get(0).getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.adding_ingridients));
                                    break;
                                case TO_BAKE:
                                    orders.get(toDo.get(0).getOrder_ID()).GetPizzasList().get(toDo.get(0).getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.baking));
                                    break;
                            }
                        }
                        orders.get(toDo.get(0).getOrder_ID()).GetPizzasList().get(toDo.get(0).getPizza_ID()).setPizzaStatus(String.valueOf(EnumStatuses.ready));
                    } else {
                        mutex.unlock();
                        chill();
                    }
                }
            }
        }

    }
}