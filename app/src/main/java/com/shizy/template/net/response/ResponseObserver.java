package com.shizy.template.net.response;

import com.shizy.template.net.BaseObserver;
import com.shizy.template.net.ResponseException;

public abstract class ResponseObserver<T> extends BaseObserver<ResponseData<T>> {

	@Override
	public final void onNext(ResponseData<T> responseData) {
		if (responseData.getCode() == ResponseCode.SUCCESS) {
			onSuccess(responseData);
		} else {
			onError(new ResponseException(responseData.getCode(), responseData.getMsg()));
		}
	}

	protected abstract void onSuccess(ResponseData<T> responseData);
}
