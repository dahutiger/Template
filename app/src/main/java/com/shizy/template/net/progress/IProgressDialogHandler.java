package com.shizy.template.net.progress;

import android.content.DialogInterface;

/**
 * Created by shizy on 2018/10/22.
 */

public interface IProgressDialogHandler {

	void showProgressDialog(DialogInterface.OnCancelListener listener);

	void dismissProgressDialog();

}
