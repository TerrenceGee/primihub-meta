package com.primihub.entity.resource.param;

import lombok.Data;

import java.util.List;

@Data
public class ResourceParam extends PageParam {
    private String resourceId;
    private String resourceName;
    private Integer resourceType;
    /** 资源所属机构 */
    private String organId;
    private List<String> organIds;
    private String tagName;
    private Integer fileContainsY;
    /** 发起方机构 */
    private String globalId;
    private List<String> resourceFusionIds;
}
