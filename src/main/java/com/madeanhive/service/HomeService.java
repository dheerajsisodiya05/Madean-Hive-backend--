package com.madeanhive.service;

import com.madeanhive.model.Home;
import com.madeanhive.model.HomeCategory;

import java.util.List;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}
