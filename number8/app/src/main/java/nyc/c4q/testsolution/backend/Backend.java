package nyc.c4q.testsolution.backend;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import nyc.c4q.testsolution.MainFragment;
import nyc.c4q.testsolution.helpers.Consumer;

public class Backend {

    private final RequestQueue mRequestQueue;
    private static final String URL = "http://jsjrobotics.nyc/cgi-bin/12_21_2016_exam.pl";
    public Backend(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void downloadData(Consumer<ApiResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                buildSuccessListener(listener),
                buildErrorListener()
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };
    }

    private Response.Listener<String> buildSuccessListener(final Consumer<ApiResponse> listener) {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ApiResponse result = ApiResponse.parse(response);
                listener.accept(result);
            }
        };
    }
}
