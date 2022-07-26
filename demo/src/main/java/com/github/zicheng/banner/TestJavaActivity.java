package com.github.zicheng.banner;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.zicheng.banner.databinding.ActivityTestJavaBinding;
import com.github.zicheng.banner.databinding.ItemBannerImageBinding;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class TestJavaActivity extends AppCompatActivity {

    private ActivityTestJavaBinding viewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityTestJavaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        List<Integer> dataList = new ArrayList<>();
        dataList.add(R.drawable.ic_test1);
        dataList.add(R.drawable.ic_test2);
        dataList.add(R.drawable.ic_test3);
        viewBinding.bannerView1.setData(dataList, new Function2<ItemBannerImageBinding, Integer, Unit>() {
            @Override
            public Unit invoke(ItemBannerImageBinding itemBannerImageBinding, Integer integer) {
                itemBannerImageBinding.getRoot().setBackgroundResource(integer);
                return Unit.INSTANCE;
            }
        });
        List<String> textList = new ArrayList<>();
        textList.add("我是图片test1");
        textList.add("我是图片test2");
        textList.add("我是图片test3");
        viewBinding.bannerView2.setData(dataList, textList, ItemBannerImageBinding.class,
                new Function2<ItemBannerImageBinding, Integer, Unit>() {
            @Override
            public Unit invoke(ItemBannerImageBinding itemBannerImageBinding, Integer integer) {
                itemBannerImageBinding.getRoot().setBackgroundResource(integer);
                return Unit.INSTANCE;
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
