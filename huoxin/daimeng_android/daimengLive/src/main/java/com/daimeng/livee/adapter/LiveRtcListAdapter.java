package com.daimeng.livee.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daimeng.livee.AppContext;
import com.daimeng.livee.R;
import com.daimeng.livee.bean.LiveRtcListBean;
import com.daimeng.livee.utils.LiveUtils;
import com.daimeng.livee.utils.SimpleUtils;
import com.daimeng.livee.utils.StringUtils;

import java.util.List;

public class LiveRtcListAdapter extends BaseQuickAdapter<LiveRtcListBean,BaseViewHolder>{
    public LiveRtcListAdapter(List<LiveRtcListBean> data) {
        super(R.layout.item_live_rtc_list,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveRtcListBean item) {
        SimpleUtils.loadImageForView(AppContext.getInstance(), (ImageView) helper.getView(R.id.item_iv_avatar),LiveUtils.getHttpUrl(item.getAvatar()),0);
        helper.setText(R.id.item_tv_user_name,item.getUser_nicename());

        if(StringUtils.toInt(item.getStatus()) == 1){
            helper.setText(R.id.item_tv_status,"连麦中...");
        }else if(StringUtils.toInt(item.getStatus()) == 2){
            helper.setText(R.id.item_tv_status,"已拒绝");
        }else if(StringUtils.toInt(item.getStatus()) == 2){
            helper.setText(R.id.item_tv_status,"请求中");
        }else if(StringUtils.toInt(item.getStatus()) == 3){
            helper.setText(R.id.item_tv_status,"已结束");
        }
    }
}