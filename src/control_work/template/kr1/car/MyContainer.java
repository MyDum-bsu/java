package control_work.template.kr1.car;

import java.util.ArrayList;
import java.util.Collections;

public class MyContainer<T extends Automobile> extends ArrayList<T>{

    public void printAllElements(){
        System.out.println("=======================================================================================================");
        System.out.println("Your container:");
        for (int i = 0 ; i < this.size() ; i++){
            this.get(i).print();
        }
        System.out.println("=======================================================================================================");
    }

    public T max() throws EmptyException{
        if (this.isEmpty())
            throw new EmptyException();
        return Collections.max(this);
    }

    public int frequency(T o) throws EmptyException{
        if (this.isEmpty())
            throw new EmptyException();
        return Collections.frequency(this, o);
    }

    public T binarySearch(T o) throws EmptyException{
        if (this.isEmpty())
            throw new EmptyException();
        MyContainer<T> temporaryContainer = (MyContainer<T>) this.clone();
        Collections.sort(temporaryContainer);
        int index = Collections.binarySearch(temporaryContainer, o);
        if (index < 0)
            return null;
        final T t = temporaryContainer.get(index);
        return t;
    }
}
