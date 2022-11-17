package control_work.template.car;

public class EnumIncorrectException extends Exception{
    public EnumIncorrectException()
    {
        super("Incorrect enum in input file!");
    }
}
