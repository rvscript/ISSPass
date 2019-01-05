
package com.example.ga_mlsdiscovery.isspass.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssResponse {

    @SerializedName("duration")
    private Integer duration;
    @SerializedName("risetime")
    private Integer risetime;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRisetime() {
        return risetime;
    }

    public void setRisetime(Integer risetime) {
        this.risetime = risetime;
    }

}
