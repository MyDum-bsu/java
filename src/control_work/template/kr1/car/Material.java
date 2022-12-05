package control_work.template.kr1.car;

public enum Material{
    LEATHER, COTTON;
    @Override
    public String toString(){
        switch (this){
            case LEATHER:
                return "leather";
            case COTTON:
                return "cotton";
            default:
                return "how?????";
        }
    }

    public Material toType(String s) throws EnumIncorrectException{
        Material delta;
        switch (s){
            case "cotton":
                delta = COTTON;
                break;
            case "leather":
                delta = LEATHER;
                break;
            default:
                throw new EnumIncorrectException();
        }
        return delta;
    }
}
