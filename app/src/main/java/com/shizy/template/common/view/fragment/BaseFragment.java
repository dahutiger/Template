package com.shizy.template.common.view.fragment;

import android.support.v4.app.Fragment;

import com.uber.autodispose.AutoDisposeConverter;

import com.shizy.template.common.utils.RxJavaUtil;

/**
 * Created by shizy on 2018/10/22.
 */

public class BaseFragment extends Fragment {

	protected <T> AutoDisposeConverter<T> bindLifecycle() {
		return RxJavaUtil.bindLifecycle(this);
	}

}
