package com.iriras.gmaillikeinbox.api.service;

import com.iriras.gmaillikeinbox.api.dao.MessageDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irfan on 28/02/17.
 */

public interface ApiService {
    @GET("inbox.json")
    Call<List<MessageDao>> getInbox();
}
