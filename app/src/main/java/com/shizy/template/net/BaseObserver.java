package com.shizy.template.net;

import com.shizy.template.BuildConfig;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by shizy on 2018/10/22.
 * Response结果订阅
 */

public abstract class BaseObserver<T> extends DisposableObserver<T> {

	@Override
	public final void onComplete() {
		onFinally();
		if (!isDisposed()) {
			dispose();
		}
	}

	@Override
	public final void onError(Throwable e) {
		if (BuildConfig.DEBUG) {
			e.printStackTrace();
		}
		if (!(e instanceof ResponseException)) {
			e = new ResponseException();
		}
		onFailure((ResponseException) e);
		onFinally();
		if (!isDisposed()) {
			dispose();
		}
	}

	protected void onFailure(ResponseException e) {

	}

	protected void onFinally() {

	}

}
