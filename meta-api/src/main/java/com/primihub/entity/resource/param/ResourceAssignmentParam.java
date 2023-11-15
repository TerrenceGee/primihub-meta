package com.primihub.entity.resource.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceAssignmentParam extends PageParam{
    private String organGlobalId;

}
