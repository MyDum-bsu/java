package control_work.template.kr1.car;

public class EnumIncorrectException extends Exception{
    public EnumIncorrectException()
    {
        super("Incorrect enum in input file!");
    }
}
