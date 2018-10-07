package exception;

public class DataReaderException extends Exception {

    public DataReaderException(){
    }

    public DataReaderException(String message){
        super(message);
    }

    public DataReaderException(Exception e){
        super(e);
    }

    public DataReaderException(String message, Exception e){
        super(message, e);
    }
}
