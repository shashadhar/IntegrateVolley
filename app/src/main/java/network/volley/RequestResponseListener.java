package network.volley;


import network.NetworkException;

/**
 * Created by Shashadhar on 25-05-2016.
 */
public interface RequestResponseListener {

    interface Listener{
        <T> void onResponse(T response);
    }


    interface ErrorListener{
        void onError(NetworkException error);
    }

    interface AuthErrorListener{
        void onAuthError();
    }
}
