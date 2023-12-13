package com.primihub.entity.resource.po;

import com.primihub.entity.resource.param.DataResourceVisibilityAuthReq;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class FusionResourceVisibilityAuth {
    private Long id;
    private String resourceId;
    private String organGlobalId;
    private Integer isDel;
    private Date cTime;
    private Date uTime;
    private Integer auditStatus;
    private Date applyTime;
    private Date assignTime;

    public FusionResourceVisibilityAuth(String resourceId,DataResourceVisibilityAuthReq authReq) {
        this.resourceId = resourceId;
        this.organGlobalId = authReq.getOrganGlobalId();
        this.isDel = 0;
        this.auditStatus = authReq.getAuditStatus();
        this.applyTime = authReq.getApplyTime();
        this.assignTime = authReq.getAssignTime();
    }
}
