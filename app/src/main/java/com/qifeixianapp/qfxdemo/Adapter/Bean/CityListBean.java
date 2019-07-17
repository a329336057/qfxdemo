package com.qifeixianapp.qfxdemo.Adapter.Bean;

import java.util.List;

public class CityListBean {
    private String citytitle;

    public String getCitytitle() {
        return citytitle;
    }

    public void setCitytitle(String citytitle) {
        this.citytitle = citytitle;
    }

    public List<String> getCityname() {
        return cityname;
    }

    public void setCityname(List<String> cityname) {
        this.cityname = cityname;
    }

    private List<String> cityname;
}
