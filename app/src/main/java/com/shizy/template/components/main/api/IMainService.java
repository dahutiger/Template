package com.shizy.template.components.main.api;

import java.util.List;

import com.shizy.template.net.response.ResponseData;
import com.shizy.template.components.main.bean.Repo;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMainService {

	@GET("api/main.json")
	Observable<ResponseData<List<Repo>>> listRepos();

	@GET("api/list.json")
	Observable<ResponseData<List<String>>> listItem();
}
