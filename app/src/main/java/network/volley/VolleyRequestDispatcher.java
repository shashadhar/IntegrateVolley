package network.volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import java.util.HashMap;
import java.util.Map;

import network.NetworkException;

/**
 * Created by Shashadhar on 25-05-2016.
 */
public class VolleyRequestDispatcher {

    public static<T> void doNetworkOperation(VolleyRequest request, final RequestResponseListener.Listener listener,
                                             final RequestResponseListener.ErrorListener errorListener, Class<T> clazz) {
        try {
            Map<String, String> headers = new HashMap<>();
            if (request.contentType != null) {
                headers.put("Content-Type", request.contentType);
            }
            GsonRequest<T> gsonRequest = new GsonRequest<>(request.method, request.url, clazz, headers,
                    new Response.Listener<T>() {
                        @Override
                        public void onResponse(T response) {
                            try {
                                listener.onResponse(response);
                            } catch (Exception e) {
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                      errorListener.onError(new NetworkException(error.getMessage()));
                    } catch (Exception e) {

                    }
                }
            });
            VolleyLog.e("Request url %s", request.url);
            if (request.method == Request.Method.POST) {
                gsonRequest.setRequestBody(request.data);
                if (request.data != null) {
                    VolleyLog.e("Request body %s", request.data);
                }
            }
            if (request.tag != null) {
                gsonRequest.setTag(request.tag);
            }
            VolleyRequestQueue.getInstance(request.context).addToRequestQueue(gsonRequest);
            VolleyLog.e("Request time", "Request");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
