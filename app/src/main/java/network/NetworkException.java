package network;

/**
 * Created by Shashadhar on 08-09-2015.
 */
public class NetworkException extends Exception {

    public String errorCode;

    public NetworkException(){

    }

    public NetworkException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public NetworkException(String message){
        super(message);
    }
}
