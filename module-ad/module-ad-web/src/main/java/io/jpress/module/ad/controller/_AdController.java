/**
 * Copyright (c) 2016-2020, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.module.ad.controller;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.validate.EmptyValidate;
import io.jboot.web.validate.Form;
import io.jpress.JPressConsts;
import io.jpress.core.menu.annotation.AdminMenu;
import io.jpress.module.ad.model.Ad;
import io.jpress.module.ad.service.AdService;
import io.jpress.web.base.AdminControllerBase;
import java.util.Date;


@RequestMapping(value = "/admin/ad/ad", viewPath = JPressConsts.DEFAULT_ADMIN_VIEW)
public class _AdController extends AdminControllerBase {

    @Inject
    private AdService service;

    @AdminMenu(text = "管理", groupId = "ad")
    public void index() {
        Page<Ad> entries=service.paginate(getPagePara(), 20);
        setAttr("page", entries);
        render("ad/ad_list.html");
    }


    public void edit() {
        long entryId = getParaToLong(0, 0L);

        Ad entry = entryId > 0 ? service.findById(entryId) : null;
        setAttr("ad", entry);
        set("now",new Date());
        render("ad/ad_edit.html");
    }

    public void doSave() {
        Ad entry = getModel(Ad.class,"ad");
        service.saveOrUpdate(entry);
        renderJson(Ret.ok().set("id", entry.getId()));
    }


    public void doDel() {
        Long id = getIdPara();
        render(service.deleteById(id) ? Ret.ok() : Ret.fail());
    }

    @EmptyValidate(@Form(name = "ids"))
    public void doDelByIds() {
        service.batchDeleteByIds(getParaSet("ids").toArray());
        renderOkJson();
    }

}
