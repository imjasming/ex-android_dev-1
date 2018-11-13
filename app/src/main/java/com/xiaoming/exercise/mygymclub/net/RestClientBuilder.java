package com.xiaoming.exercise.mygymclub.net;

import com.xiaoming.exercise.mygymclub.net.callback.IError;
import com.xiaoming.exercise.mygymclub.net.callback.IFailure;
import com.xiaoming.exercise.mygymclub.net.callback.IRequest;
import com.xiaoming.exercise.mygymclub.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String mUrl;
    private Map<String, Object> mParams = RestCreator.getParams();
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private IRequest mRequest;
    private RequestBody mBody;

    RestClientBuilder(){
    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){
        this.mParams.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
        this.mParams.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/jason;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request){
        this.mRequest = request;
        return this;
    }

    public final RestClientBuilder success(ISuccess success){
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure){
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder error(IError error){
        this.mError = error;
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl,mParams,mSuccess,mFailure, mError,mRequest,mBody);
    }
}
