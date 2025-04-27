package com.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/25 13:55
 * @description
 * @since 3.0.0
 */
public class MetaManager {
    private static volatile Meta meta;

    // 私有构造函数，防止外部实例化
    private MetaManager() {}

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        // todo 校验和处理默认值
        return newMeta;
    }
}
