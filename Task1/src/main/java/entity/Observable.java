package entity;


public interface Observable {

    void notifyObserver();

    void registerObserver(Observer obsrver);

    void unregisterObserver(Observer observer);


}
