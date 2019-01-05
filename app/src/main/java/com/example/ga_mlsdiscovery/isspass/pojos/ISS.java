
package com.example.ga_mlsdiscovery.isspass.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ISS {

    @SerializedName("message")
    private String message;
    @SerializedName("request")
    private Request request;
    @SerializedName("response")
    private List<IssResponse> response = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<IssResponse> getResponse() {
        return response;
    }

    public void setResponse(List<IssResponse> response) {
        this.response = response;
    }

}
