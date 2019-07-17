package com.qifeixianapp.qfxdemo.Bean;

import java.util.List;

public class CityBeans {

    private List<CityBean> city;

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public static class CityBean {
        /**
         * title : A
         * lists : ["阿坝","阿拉善","阿里","安康","安庆","鞍山","安顺","安阳","澳门"]
         */

        private String title;
        private List<String> lists;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getLists() {
            return lists;
        }

        public void setLists(List<String> lists) {
            this.lists = lists;
        }
    }
}
