package io.jpress.module.ad.directive;

import com.jfinal.aop.Inject;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import io.jboot.db.model.Columns;
import io.jboot.web.directive.annotation.JFinalDirective;
import io.jboot.web.directive.base.JbootDirectiveBase;
import io.jpress.module.ad.model.Ad;
import io.jpress.module.ad.service.AdService;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @创建人 netboy
 * @创建时间 2022/9/29
 * @描述  获取当前生效的广告列表信息
 */
@JFinalDirective("validAds")
public class ValidAdsDirective extends JbootDirectiveBase {
    @Inject
    private AdService adService;

    @Override
    public void onRender(Env env, Scope scope, Writer writer) {
        int  ad_valid = getParaToInt("ad_valid", scope,1);
        String orderBy = getPara("orderBy", scope, "ad_index,id desc");
        int count = getParaToInt("count", scope, 5);

        Date nowTime = new Date();
        Columns columns = Columns.create();
        columns.le("start_time",nowTime);
        columns.ge("end_time",nowTime);
        columns.eq("ad_status",ad_valid);
        List<Ad> ads = adService.findListByColumns(columns,orderBy,count);
        if (CollectionUtils.isEmpty(ads)) {
            return;
        }

        scope.setLocal("validAds", ads);
        renderBody(env, scope, writer);
    }

    @Override
    public boolean hasEnd() {
        return true;
    }
}
