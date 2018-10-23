package com.shizy.template.components.main.ui;

import android.content.Context;

import com.shizy.template.common.view.adapter.CommonAdapter;
import com.shizy.template.common.view.adapter.ViewHolder;

public class MainAdapter extends CommonAdapter<String> {

	public MainAdapter(Context context) {
		super(context, android.R.layout.simple_list_item_1);
	}

	@Override
	protected void convert(ViewHolder holder, String item) {
		holder.setText(android.R.id.text1, item);
	}
}
