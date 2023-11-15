package com.primihub.controller;

import com.alibaba.fastjson.JSONObject;
import com.primihub.entity.DataSet;
import com.primihub.entity.base.BaseResultEntity;
import com.primihub.entity.base.BaseResultEnum;
import com.primihub.entity.copy.dto.CopyResourceDto;
import com.primihub.entity.resource.param.PageParam;
import com.primihub.entity.resource.param.ResourceAssignmentParam;
import com.primihub.entity.resource.param.ResourceParam;
import com.primihub.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("fusionResource")
@RestController
@Slf4j
public class FusionResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("getResourceList")
    public BaseResultEntity getResourceList(@RequestBody ResourceParam resourceParam){
        return resourceService.getResourceList(resourceParam);
    }

    @RequestMapping("getResourceListById")
    public BaseResultEntity getResourceListById(String[] resourceIdArray,String globalId){
        if(resourceIdArray==null||resourceIdArray.length==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"resourceIdArray");
        }
        return resourceService.getResourceListById(resourceIdArray,globalId);
    }
    @RequestMapping("getCopyResource")
    public BaseResultEntity getCopyResource(String[] resourceIds){
        if(resourceIds==null||resourceIds.length==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"resourceIds");
        }
        log.info(JSONObject.toJSONString(resourceIds));
        BaseResultEntity copyResource = resourceService.getCopyResource(resourceIds);
        log.info(JSONObject.toJSONString(copyResource));
        return copyResource;
    }

    @RequestMapping("getResourceTagList")
    public BaseResultEntity getResourceTagList(){
        return resourceService.getResourceTagList();
    }

    @RequestMapping("getDataResource")
    public BaseResultEntity getDataResource(String resourceId,String globalId){
        if (StringUtils.isEmpty(resourceId)) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"resourceId");
        }
        return resourceService.getDataResource(resourceId,globalId);
    }
    @PostMapping("saveResource")
    public BaseResultEntity saveResource(String globalId, @RequestBody List<CopyResourceDto> copyResourceDtoList){
        if (StringUtils.isEmpty(globalId)) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"globalId");
        }
        if (copyResourceDtoList==null || copyResourceDtoList.size()==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"copyResourceDtoList");
        }
        return resourceService.batchSaveResource(globalId,copyResourceDtoList);
    }

    @RequestMapping("getTestDataSet")
    public BaseResultEntity getTestDataSet(String id){
        return resourceService.getTestDataSet(id);
    }

    @RequestMapping("getDataSets")
    public BaseResultEntity getDataSets(@RequestBody Set<String> ids){
        return resourceService.getDataSets(ids);
    }

    @PostMapping("batchSaveTestDataSet")
    public BaseResultEntity batchSaveTestDataSet(@RequestBody List<DataSet> dataSets){
        if (dataSets == null || dataSets.size()==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"shareData - dataSets");
        }
        return resourceService.batchSaveTestDataSet(dataSets);
    }

    /**
     * 查询机构已授权的资源
     * @return
     */
    @GetMapping("getDataResourceOrganAssignment")
    BaseResultEntity getDataResourceOrganAssignment(ResourceAssignmentParam param) {
        if (param.getOrganGlobalId()==null||param.getOrganGlobalId().length()==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"organGlobalId");
        }
        return resourceService.getDataResourceOrganAssignment(param);
    }

    /**
     * 查询机构可申请的资源
     * @return
     */
    @GetMapping("getDataResourceToApply")
    BaseResultEntity getDataResourceToApply(ResourceAssignmentParam param) {
        if (param.getOrganGlobalId()==null||param.getOrganGlobalId().length()==0) {
            return BaseResultEntity.failure(BaseResultEnum.LACK_OF_PARAM,"organGlobalId");
        }
        return resourceService.getDataResourceToApply(param);
    }

    @RequestMapping("/fusionResource/getResourceListUser")
    BaseResultEntity getResourceListUser(@RequestBody ResourceParam resourceParam) {
        return resourceService.getResourceListUser(resourceParam);
    }

    @RequestMapping("/fusionResource/getResourceListOrgan")
    BaseResultEntity getResourceListOrgan(@RequestBody ResourceParam resourceParam) {
        return resourceService.getResourceListOrgan(resourceParam);
    }

}
