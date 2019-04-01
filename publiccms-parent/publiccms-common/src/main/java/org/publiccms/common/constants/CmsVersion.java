package org.publiccms.common.constants;

import com.publiccms.common.base.Copyright;

import java.util.UUID;

import static org.publiccms.common.constants.CommonConstants.CMS_FILEPATH;

/**
 * CmsVersion
 */
public class CmsVersion {
    private static final String clusterId = UUID.randomUUID().toString();
    private static boolean master = false;
    private static boolean initialized = false;
    private static Copyright copyright;

    /**
     * @return
     */
    public static final String getVersion() {
        return "V1.0.0";
    }

    /**
     * @return
     */
    public static boolean isPreview() {
        return false;
    }

    /**
     * @return
     */
    public static boolean isBusinessEdition() {
        return null != copyright && copyright.verify();
    }

    /**
     * @return
     */
    public static final String getClusterId() {
        return clusterId;
    }

    /**
     * @return
     */
    public static boolean isMaster() {
        return master;
    }

    /**
     * @param master
     */
    public static void setMaster(boolean master) {
        CmsVersion.master = master;
    }

    /**
     * @return
     */
    public static boolean isInitialized() {
        return initialized;
    }

    /**
     * @param initialized
     */
    public static void setInitialized(boolean initialized) {
        CmsVersion.initialized = initialized;
        if (initialized && null == copyright) {
            try {
                Class<?> clazz = Class.forName("com.publiccms.improve.CmsCopyright");
                if (Copyright.class.isAssignableFrom(clazz)) {
                    copyright = (Copyright) clazz.newInstance();
                    copyright.init(CMS_FILEPATH);
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            }
        }
    }
}