package com.renren.breadtravel.ui;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseActivity;
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


public class DragItemActivity extends BaseActivity {

    private EasyTipDragView easyTipDragView;
    private List<HotCity> mHotCities = new ArrayList<>();
    private List<String> mTips = new ArrayList<>();
    private List<HotCity> mLastHotCities = new ArrayList<>();
    private boolean isFirstDrag = false;


    @Override
    protected int getResultId() {
        return R.layout.activity_drag_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        String json = PreferencesUtils.getString(this, Constants.HOT_CITY_ITEM_DRAG);
        Type type = new TypeToken<List<HotCity>>() {
        }.getType();
        mHotCities = new Gson().fromJson(json, type);
        mLastHotCities = new Gson().fromJson(
                PreferencesUtils.getString(this, Constants.HOT_CITY_CANCEL_ITEM),
                new TypeToken<List<HotCity>>() {
                }.getType()
        );
        easyTipDragView = (EasyTipDragView) findViewById(R.id.easy_tip_drag_view);

        if (mHotCities != null)
            //设置已包含的标签数据
            easyTipDragView.setDragData(getDragTips(mHotCities));
        if (mLastHotCities != null)
            easyTipDragView.setAddData(getAddTips(mLastHotCities));
            //设置可以添加的标签数据
        else
            easyTipDragView.setAddData(null);
        //在easyTipDragView处于非编辑模式下点击item的回调（编辑模式下点击item作用为删除item）
        easyTipDragView.setSelectedListener(new TipItemView.OnSelectedListener() {
            @Override
            public void onTileSelected(Tip entity, int position, View view) {
                Intent intent = new Intent();
                PreferencesUtils.putInt(DragItemActivity.this, Constants.CURRENT_INDEX, position);
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
                Toast.makeText(DragItemActivity.this, tips.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        //设置点击“确定”按钮后最终数据的回调
        easyTipDragView.setOnCompleteCallback(new EasyTipDragView.OnCompleteCallback() {
            @Override
            public void onComplete(ArrayList<Tip> tips) {

                if (!isFirstDrag) { //因为有些逻辑的原因,这个地方,如果是首次,而且没有进行排序,那么也就代表没有动item
                    //那么就是原先的数据不变
                } else {
                    String jsonResult = new Gson().toJson(tips);
                    //这个时候数据有变化,拿到的也是变化后的数据
                    PreferencesUtils.putString(DragItemActivity.this, Constants.HOT_CITY_ITEM_DRAG, jsonResult);
                }
                Intent intent = new Intent();
                setResult(BreadOrderFragment.RESULT_CODE, intent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 500);

            }
        });

        /**
         * 按下确定或者其他返回  也就是finish()之后回调，用于返回剩余的数据(没有被添加用于显示的数据)
         */
        easyTipDragView.setLastDataCallback(new EasyTipDragView.OnCompleteLastDataCallback() {
            @Override
            public void lastDataComplete(List<Tip> tips) {
                String jsonResult = new Gson().toJson(tips);
                //保存到本地
                PreferencesUtils.putString(DragItemActivity.this, Constants.HOT_CITY_CANCEL_ITEM, jsonResult);
            }
        });


        easyTipDragView.open();
    }

    /**
     * 获取到拖拽数据
     *
     * @param dragTips 拖拽数据集合
     * @return 拖拽数据集合
     */
    public static List<Tip> getDragTips(List<HotCity> dragTips) {
        List<Tip> result = new ArrayList<>();
        for (int i = 0; i < dragTips.size(); i++) {
            String city_id = dragTips.get(i).cityId;
            String city_name = dragTips.get(i).ciryName;
            SimpleTitleTip tip = new SimpleTitleTip();
            tip.setId(city_id);
            tip.setTip(city_name);
            result.add(tip);
        }
        return result;
    }

    /**
     * 获取到添加数据集合
     *
     * @param addTips 添加数据集合
     * @return 返回添加数据集合
     */
    public static List<Tip> getAddTips(List<HotCity> addTips) {
        List<Tip> result = new ArrayList<>();
        for (int i = 0; i < addTips.size(); i++) {
            String city_id = addTips.get(i).cityId;
            String city_name = addTips.get(i).ciryName;
            SimpleTitleTip tip = new SimpleTitleTip();
            tip.setTip(city_name);
            tip.setId(city_id);
            result.add(tip);
        }
        return result;
    }
}
