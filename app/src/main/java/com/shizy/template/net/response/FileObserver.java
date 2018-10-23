package com.shizy.template.net.response;

import com.shizy.template.common.utils.FileIOUtil;
import com.shizy.template.net.BaseObserver;
import com.shizy.template.net.ResponseException;
import okhttp3.ResponseBody;

public abstract class FileObserver extends BaseObserver<ResponseBody> {

	private String mLocalPath;

	public FileObserver(String path) {
		mLocalPath = path;
	}

	@Override
	public final void onNext(ResponseBody body) {
		boolean success = FileIOUtil.writeFileFromIS(mLocalPath, body.byteStream());
		if (success) {
			onSuccess();
		} else {
			onError(new ResponseException(-1, "保存文件出错！"));
		}
	}

	protected abstract void onSuccess();
}
