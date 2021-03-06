package com.shizy.template.components.main.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface IDownloadService {

	@GET
	@Streaming
	Observable<ResponseBody> downloadFile(@Url String fileUrl);

}
