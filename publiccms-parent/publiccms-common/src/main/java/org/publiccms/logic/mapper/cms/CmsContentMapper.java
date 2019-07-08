package org.publiccms.logic.mapper.cms;

import org.apache.ibatis.annotations.Param;
import org.publiccms.entities.cms.CmsContent;

/**
 * 内容模块
 *
 * @author buyi
 * @date 2019年07月08日 16:59:57
 * @since 1.0.0
 */
public interface CmsContentMapper {
    CmsContent query(@Param("id") Long id);
}
