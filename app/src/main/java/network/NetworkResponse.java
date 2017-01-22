package network;

/**
 * Created by Shashadhar on 25-05-2016.
 */
public interface NetworkResponse {

    interface Listener{
        void onResponse(Object result);
    }
    interface ErrorListener{
        void onError(NetworkException error);
    }
}
