package com.bawei.chenshuaishuaiyuekaomoni02.model.entity;

import java.util.List;

public class GridEntity {


    public String message;
    public String status;
    public List<ResultBean> result;


    public static class ResultBean {

        public String commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public String saleNum;

    }
}
