package conteiners;

import enums.ECommand;

public class Command{
    private ECommand command_type;
    private Integer pizza_ID;

    private Integer order_ID;
    public Command(ECommand _command, Integer _pizzaID, Integer _orderId){ command_type = _command; pizza_ID = _pizzaID; order_ID = _orderId; }

    public Command(Command _command){
        command_type = _command.command_type;
        pizza_ID = _command.pizza_ID;
        order_ID = _command.order_ID;
    }

    public ECommand getCommand_type() {
        return command_type;
    }

    public Integer getPizza_ID() {
        return pizza_ID;
    }
    public Integer getOrder_ID() { return order_ID; }
}
