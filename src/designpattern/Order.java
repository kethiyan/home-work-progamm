package designpattern;

import java.util.ArrayList;
import java.util.List;




public class Order implements Subject 
{
    private List<Observer> observers = new ArrayList<>();
    private String status;
    
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    @Override
    public void notifyObserver(){
        for(Observer observer:observers){
                    observer.update(status);
        }
    }

    public void setStatus(String status){
        this.status = status;
        notifyObserver();
    }
}