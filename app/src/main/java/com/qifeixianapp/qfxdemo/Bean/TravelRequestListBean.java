package com.qifeixianapp.qfxdemo.Bean;

import java.util.List;

public class TravelRequestListBean {

    /**
     * code : 1
     * data : {"list":[{"id":"748","name":"普通线路4","tourist_type":"1","start_city":"广安,重庆","end_city":"","integral_deductible":null,"end_time":null,"city_name":"重庆","price":"180.00","departure_time":"2019-09-03 08:00:00","stock":"33","price_id":"690","img":""},{"id":"900","name":"旅游线路","tourist_type":"1","start_city":"成都","end_city":"重庆","integral_deductible":"[\"\",0,0,0,0,0,0,0,0]","end_time":null,"city_name":"成都","price":"80.00","departure_time":"2019-10-11 00:00:00","stock":"55","price_id":"662","img":""},{"id":"745","name":"普通线路1","tourist_type":"1","start_city":"广安,重庆","end_city":"重庆","integral_deductible":null,"end_time":null,"city_name":"广安","price":"80.00","departure_time":"2019-10-12 00:00:00","stock":"55","price_id":"664","img":""},{"id":"746","name":"普通线路2","tourist_type":"1","start_city":"成都","end_city":"重庆","integral_deductible":null,"end_time":null,"city_name":"成都","price":"80.00","departure_time":"2019-10-15 00:00:00","stock":"55","price_id":"659","img":""}],"nums":"4"}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":"748","name":"普通线路4","tourist_type":"1","start_city":"广安,重庆","end_city":"","integral_deductible":null,"end_time":null,"city_name":"重庆","price":"180.00","departure_time":"2019-09-03 08:00:00","stock":"33","price_id":"690","img":""},{"id":"900","name":"旅游线路","tourist_type":"1","start_city":"成都","end_city":"重庆","integral_deductible":"[\"\",0,0,0,0,0,0,0,0]","end_time":null,"city_name":"成都","price":"80.00","departure_time":"2019-10-11 00:00:00","stock":"55","price_id":"662","img":""},{"id":"745","name":"普通线路1","tourist_type":"1","start_city":"广安,重庆","end_city":"重庆","integral_deductible":null,"end_time":null,"city_name":"广安","price":"80.00","departure_time":"2019-10-12 00:00:00","stock":"55","price_id":"664","img":""},{"id":"746","name":"普通线路2","tourist_type":"1","start_city":"成都","end_city":"重庆","integral_deductible":null,"end_time":null,"city_name":"成都","price":"80.00","departure_time":"2019-10-15 00:00:00","stock":"55","price_id":"659","img":""}]
         * nums : 4
         */

        private String nums;
        private List<ListBean> list;

        public String getNums() {
            return nums;
        }

        public void setNums(String nums) {
            this.nums = nums;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 748
             * name : 普通线路4
             * tourist_type : 1
             * start_city : 广安,重庆
             * end_city :
             * integral_deductible : null
             * end_time : null
             * city_name : 重庆
             * price : 180.00
             * departure_time : 2019-09-03 08:00:00
             * stock : 33
             * price_id : 690
             * img :
             */

            private String id;
            private String name;
            private String tourist_type;
            private String start_city;
            private String end_city;
            private Object integral_deductible;
            private Object end_time;
            private String city_name;
            private String price;
            private String departure_time;
            private String stock;
            private String price_id;
            private String img;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTourist_type() {
                return tourist_type;
            }

            public void setTourist_type(String tourist_type) {
                this.tourist_type = tourist_type;
            }

            public String getStart_city() {
                return start_city;
            }

            public void setStart_city(String start_city) {
                this.start_city = start_city;
            }

            public String getEnd_city() {
                return end_city;
            }

            public void setEnd_city(String end_city) {
                this.end_city = end_city;
            }

            public Object getIntegral_deductible() {
                return integral_deductible;
            }

            public void setIntegral_deductible(Object integral_deductible) {
                this.integral_deductible = integral_deductible;
            }

            public Object getEnd_time() {
                return end_time;
            }

            public void setEnd_time(Object end_time) {
                this.end_time = end_time;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDeparture_time() {
                return departure_time;
            }

            public void setDeparture_time(String departure_time) {
                this.departure_time = departure_time;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getPrice_id() {
                return price_id;
            }

            public void setPrice_id(String price_id) {
                this.price_id = price_id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
