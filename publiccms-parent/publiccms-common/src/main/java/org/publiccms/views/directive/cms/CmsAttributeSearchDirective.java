package org.publiccms.views.directive.cms;

import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.RenderHandler;
import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.entities.sys.SysSite;
import org.publiccms.logic.mapper.cms.CmsContentMapper;
import org.publiccms.logic.service.cms.CmsContentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

import static com.publiccms.common.tools.CommonUtils.notEmpty;

/**
 * 内容扩展信息查询
 *
 * @author buyi
 * @date 2019年07月08日 19:27:02
 * @since 1.0.0
 */
@Component
public class CmsAttributeSearchDirective extends AbstractTemplateDirective {

    @Resource
    private CmsContentService cmsContentService;

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        //城市
        String city = handler.getString("city");
        //职业类型
        String position = handler.getString("position");
        //公司行业
        String industry = handler.getString("industry");

        if (notEmpty(city) || notEmpty(position) || notEmpty(industry)) {
            SysSite site = getSite(handler);

            //step1.搜索记录统计

            //step2.分页查询
            PageHandler page;
            Integer pageIndex = handler.getInteger("pageIndex", 1);
            Integer count = handler.getInteger("count", 30);
            try {
                page = cmsContentService.query(site.getId(), city, position, industry, pageIndex, count);
            } catch (Exception e) {
                page = new PageHandler(pageIndex, count, 0, null);
            }
            handler.put("page", page).render();

        }

    }
}
