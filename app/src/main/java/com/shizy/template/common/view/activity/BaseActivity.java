package com.shizy.template.common.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.uber.autodispose.AutoDisposeConverter;

import butterknife.ButterKnife;
import com.shizy.template.common.utils.RxJavaUtil;

/**
 * Created by shizy on 2018/10/22.
 */
public abstract class BaseActivity extends AppCompatActivity {

	protected <T> AutoDisposeConverter<T> bindLifecycle() {
		return RxJavaUtil.bindLifecycle(this);
	}

	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		ButterKnife.bind(this);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.bind(this);
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		super.setContentView(view, params);
		ButterKnife.bind(this);
	}
}
