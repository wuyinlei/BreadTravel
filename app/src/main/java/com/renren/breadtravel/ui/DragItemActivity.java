package com.renren.breadtravel.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.renren.breadtravel.R;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.entity.HotCity;
import com.renren.breadtravel.fragment.BreadOrderFragment;
import com.renren.breadtravel.utils.PreferencesUtils;
import com.renren.breadtravel.widget.easytagdragview.EasyTipDragView;
import com.renren.breadtravel.widget.easytagdragview.bean.SimpleTitleTip;
import com.renren.breadtravel.widget.easytagdragview.bean.Tip;
import com.renren.breadtravel.widget.easytagdragview.widget.TipItemView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DragItemActivity extends AppCompatActivity {

    private EasyTipDragView easyTipDragView;
    private List<HotCity> mHotCities = new ArrayList<>();
    private List<String> mTips = new ArrayList<>();
    private boolean isFirstDrag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_item);

        String json = PreferencesUtils.getString(this, Constants.HOT_CITY_ITEM_DRAG);
        Type type = new TypeToken<List<HotCity>>(){}.getType();
        mHotCities = new Gson().fromJson(json,type);

        easyTipDragView =(EasyTipDragView)findViewById(R.id.easy_tip_drag_view);

        if (mHotCities!=null){
            for (int i = 0; i < mHotCities.size(); i++) {
                mTips.add(mHotCities.get(i).ciryName);
            }
        }
        //设置已包含的标签数据
        easyTipDragView.setDragData(getDragTips(mTips));
        //设置可以添加的标签数据
        easyTipDragView.setAddData(null);
        //在easyTipDragView处于非编辑模式下点击item的回调（编辑模式下点击item作用为删除item）
        easyTipDragView.setSelectedListener(new TipItemView.OnSelectedListener() {
            @Override
            public void onTileSelected(Tip entity, int position, View view) {
               // toast(((SimpleTitleTip) entity).getTip());
             //   Toast.makeText(DragItemActivity.this, ((SimpleTitleTip) entity).getTip(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
               // intent.putExtra("position",position);
                PreferencesUtils.putInt(DragItemActivity.this,Constants.CURRENT_INDEX,position);
                setResult(BreadOrderFragment.RESULT_CODE_INDEX, intent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 500);
            }
        });
        //设置每次数据改变后的回调（例如每次拖拽排序了标签或者增删了标签都会回调）
        easyTipDragView.setDataResultCallback(new EasyTipDragView.OnDataChangeResultCallback() {
            @Override
            public void onDataChangeResult(ArrayList<Tip> tips) {
               // Log.i("heheda", tips.toString());
                isFirstDrag = true;
                //Toast.makeText(DragItemActivity.this, tips.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        //设置点击“确定”按钮后最终数据的回调
        easyTipDragView.setOnCompleteCallback(new EasyTipDragView.OnCompleteCallback() {
            @Override
            public void onComplete(ArrayList<Tip> tips) {

                if (!isFirstDrag){ //因为有些逻辑的原因,这个地方,如果是首次,而且没有进行排序,那么也就代表没有动item
                    //那么就是原先的数据不变

                } else {
                    String jsonResult = new Gson().toJson(tips);
                    //这个时候数据有变化,拿到的也是变化后的数据
                    PreferencesUtils.putString(DragItemActivity.this,Constants.HOT_CITY_ITEM_DRAG,jsonResult);

                }

                Intent intent = new Intent();
                setResult(BreadOrderFragment.RESULT_CODE, intent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 500);
                //toast("最终数据：" + tips.toString());
                //   btn.setVisibility(View.VISIBLE);
//


                Toast.makeText(DragItemActivity.this, "tips:" + tips.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        easyTipDragView.open();

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode){
//            //点击返回键
//            case KeyEvent.KEYCODE_BACK:
//                //判断easyTipDragView是否已经显示出来
//                if(easyTipDragView.isOpen()){
//                    if(!easyTipDragView.onKeyBackDown()){
//                        //  btn.setVisibility(View.VISIBLE);
//                    }
//                    return true;
//                }
//                //....自己的业务逻辑
//
//                break;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//

 //   private static String[] dragTips ={"头条","热点","娱乐","体育","财经","科技","段子","轻松一刻","军事","历史","游戏","时尚","NBA"
   //         ,"漫画","社会","中国足球","手机"};
  //  private static String[] addTips ={"数码","移动互联","云课堂","家居","旅游","健康","读书","跑步","情感","政务","艺术","博客"};
    public static List<Tip>  getDragTips(List<String> dragTips){
        List<Tip> result = new ArrayList<>();
        for(int i=0;i<dragTips.size();i++){
            String temp =dragTips.get(i);
            SimpleTitleTip tip = new SimpleTitleTip();
            tip.setTip(temp);
            tip.setId(i);
            result.add(tip);
        }
        return result;
    }
    public static List<Tip> getAddTips(List<String> addTips){
        List<Tip> result = new ArrayList<>();
        for(int i=0;i<addTips.size();i++){
            String temp =addTips.get(i);
            SimpleTitleTip tip = new SimpleTitleTip();
            tip.setTip(temp);
            tip.setId(i+addTips.size());
            result.add(tip);
        }
        return result;
    }
}
