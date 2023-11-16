package com.primihub.entity.resource.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.primihub.entity.resource.param.DataResourceOrganAssignmentParam;
import lombok.Data;

import java.util.Date;

/**
 * 中心资源机构授权
 */
@Data
public class FusionResourceOrganAssignment {
    private Long id;
    private String resourceId;
    /**
     * 资源所属机构Id
     */
    private String resourceOrganId;
    private String organId;
    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;
    /**
     * 授权通过时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assignTime;
    /**
     * 授权状态
     * 0.申请 1.申请通过，由所有者直接授予 2.申请拒绝
     */
    private Integer assignStatus;
    private Date cTime;
    private Date uTime;

    public FusionResourceOrganAssignment() {
    }

    public FusionResourceOrganAssignment(DataResourceOrganAssignmentParam param){
        this.resourceId = param.getResourceFusionId();
        this.organId = param.getResourceOrganId();
        this.resourceOrganId = param.getResourceOrganId();
    }
}
