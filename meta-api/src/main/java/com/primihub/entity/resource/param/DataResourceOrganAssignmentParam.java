package com.primihub.entity.resource.param;

import lombok.Data;


@Data
public class DataResourceOrganAssignmentParam {
    private Long id;
    private String resourceFusionId;
    // 资源所属机构
    private String resourceOrganId;
    // 资源申请机构或者叫资源授予机构
    private String organId;
    /**
     * 授权状态
     * 0.申请 1.申请通过，由所有者直接授予 2.申请拒绝
     */
    private Integer auditStatus;

}
