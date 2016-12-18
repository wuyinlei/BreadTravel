package com.renren.breadtravel.utils;

import android.content.Context;

import com.renren.breadtravel.R;
import com.renren.breadtravel.cn.sharesdk.onekeyshare.OnekeyShare;
import com.renren.breadtravel.constant.Constants;

/**
 * Created by wuyinlei on 2016/12/18.
 */

public class ShareUtils {

    public static void showShare(Context context,String title,String shareUrl){
            OnekeyShare oks = new OnekeyShare();
            //关闭sso授权
            oks.disableSSOWhenAuthorize();
            // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
            oks.setTitle(context.getResources().getString(R.string.tip));
            // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
            oks.setTitleUrl(shareUrl);
            // text是分享文本，所有平台都需要这个字段
            //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
            // oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
            // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
            //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
            // url仅在微信（包括好友和朋友圈）中使用
            oks.setUrl(shareUrl);
            // comment是我对这条分享的评论，仅在人人网和QQ空间使用
            oks.setComment(context.getResources().getString(R.string.notification_content));
            // site是分享此内容的网站名称，仅在QQ空间使用
            oks.setSite("Welcome To My Home!");
            // siteUrl是分享此内容的网站地址，仅在QQ空间使用
            oks.setSiteUrl(shareUrl);
            // 启动分享GUI
            oks.show(context);

    }
}
