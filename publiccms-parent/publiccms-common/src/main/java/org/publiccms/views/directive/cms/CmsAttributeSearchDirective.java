package org.publiccms.views.directive.cms;

import com.publiccms.common.handler.RenderHandler;
import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.logic.mapper.cms.CmsContentMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

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
    private CmsContentMapper cmsContentMapper;

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {

    }
}
