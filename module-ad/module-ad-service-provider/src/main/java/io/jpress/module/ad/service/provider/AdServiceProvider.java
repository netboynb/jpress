package io.jpress.module.ad.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jpress.module.ad.service.AdService;
import io.jpress.module.ad.model.Ad;
import io.jpress.commons.service.JPressServiceBase;

@Bean
public class AdServiceProvider extends JPressServiceBase<Ad> implements AdService {

}