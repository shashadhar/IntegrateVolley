package network;

import android.content.Context;
import com.android.volley.Request;

import model.User;
import network.volley.VolleyRequest;
import network.volley.RequestResponseListener;
import network.volley.VolleyRequestDispatcher;

/**
 * Created by Shashadhar on 19-07-2016.
 */
public class NetworkCommunicator {

    private final Context mCtx;


    public NetworkCommunicator(Context context) {
        this.mCtx = context;
    }
    public void getUser(final NetworkResponse.Listener listener, final NetworkResponse.ErrorListener errorListener, String tag) {
        try {
            String url = "https://example.com/getUser";//replace with your url

            final VolleyRequest volleyRequest = new VolleyRequest();
            volleyRequest.url = url;
            volleyRequest.method = Request.Method.GET;
            volleyRequest.context = mCtx;
            volleyRequest.tag = tag;
            volleyRequest.contentType = "application/json";

            VolleyRequestDispatcher.doNetworkOperation(volleyRequest, new RequestResponseListener.Listener() {
                @Override
                public <T> void onResponse(T response) {
                    try {
                        listener.onResponse(response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new RequestResponseListener.ErrorListener() {
                @Override
                public void onError(NetworkException error) {
                    try {
                        errorListener.onError(error);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },  User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
