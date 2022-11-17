package control_work.template.car;

public class IncorrectIntException extends Exception{
    IncorrectIntException()
    {
        super("You can't enter negative number of doors or seats!");
    }
}
