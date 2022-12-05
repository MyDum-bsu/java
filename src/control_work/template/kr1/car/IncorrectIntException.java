package control_work.template.kr1.car;

public class IncorrectIntException extends Exception{
    IncorrectIntException()
    {
        super("You can't enter negative number of doors or seats!");
    }
}
