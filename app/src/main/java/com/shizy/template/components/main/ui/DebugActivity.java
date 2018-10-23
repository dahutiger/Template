package com.shizy.template.components.main.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import com.shizy.template.R;
import com.shizy.template.common.constant.SPConstant;
import com.shizy.template.common.constant.ServerHost;
import com.shizy.template.common.utils.ActivityManager;
import com.shizy.template.common.utils.AppUtil;
import com.shizy.template.common.utils.SPUtil;
import com.shizy.template.common.utils.UIUtil;
import com.shizy.template.common.view.activity.BaseTitleActivity;
import com.shizy.template.service.RebootService;

public class DebugActivity extends BaseTitleActivity {

	@BindView(R.id.edit_text)
	protected EditText mEditText;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug);
		initView();
	}

	private void initView() {
		setTitle(AppUtil.getVersionName());
		setRightText(R.string.ok);

		updateServer(ServerHost.getServerAddress());
	}

	@Override
	protected void onClickTitleLeft() {
		UIUtil.hideSoftInput(mEditText);
		super.onClickTitleLeft();
	}

	@Override
	protected void onClickTitleRight() {
		UIUtil.hideSoftInput(mEditText);
		new AlertDialog.Builder(this)
				.setMessage(R.string.modify_server_address)
				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String address = mEditText.getText().toString().trim();
						SPUtil.putString(SPConstant.SERVER_ADDRESS, address);
						SPUtil.commit();
						restartApp();
					}
				})
				.setNegativeButton(R.string.no, null)
				.create()
				.show();
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_dev:
				updateServer(ServerHost.SERVER_DEV);
				break;
			case R.id.btn_master:
				updateServer(ServerHost.SERVER_MASTER);
				break;
			case R.id.btn_stable:
				updateServer(ServerHost.SERVER_STABLE);
				break;
			default:
				break;
		}
	}

	private void updateServer(String address) {
		mEditText.setText(address);
		mEditText.setSelection(mEditText.length());
	}

	private void restartApp() {
		RebootService.launch(this, Process.myPid());
		ActivityManager.getInstance().finishAllActivity();
	}

}
