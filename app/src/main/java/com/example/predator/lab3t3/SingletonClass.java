package com.example.predator.lab3t3;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonClass {
    private static SingletonClass instance;
    private RequestQueue requestQueue;
    private static Context context;


    private SingletonClass(Context con){
        context = con;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized SingletonClass getInstance(Context con){
        if(instance == null){
            instance = new SingletonClass(context);
        }
        return instance;
    }

    public void addRequestToQueue(Request request){
        requestQueue.add(request);
    }
}
