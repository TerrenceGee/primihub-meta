package com.primihub.controller;

import com.alibaba.fastjson.JSONObject;
import com.primihub.entity.DataSet;
import com.primihub.entity.base.BaseResultEntity;
import com.primihub.entity.base.BaseResultEnum;
import com.primihub.entity.base.PageDataEntity;
import com.primihub.entity.copy.dto.CopyResourceDto;
import com.primihub.entity.resource.param.DataResourceOrganAssignmentParam;
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

    /**
     * 协作方资源
     * @param resourceParam
     * @return
     */
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
     * 查询机构可申请的资源
     * @return
     */
    @PostMapping("getDataResourceListToApplyOfOrgan")
    BaseResultEntity getDataResourceListToApplyOfOrgan(@RequestBody ResourceParam param) {
        return resourceService.getDataResourceListToApplyOfOrgan(param);
    }

    /**
     * 查询用户可申请的资源
     * @return
     */
    @PostMapping("getDataResourceListToApplyOfUser")
    BaseResultEntity getDataResourceListToApplyOfUser(@RequestBody ResourceParam param) {
        return resourceService.getDataResourceListToApplyOfUser(param);
    }


//    @RequestMapping("getResourceListOrgan")
//    BaseResultEntity getResourceListOrgan(@RequestBody ResourceParam resourceParam) {
//        return resourceService.getResourceListOrgan(resourceParam);
//    }

    /** ----------------------------------------------------------------- */

//    @GetMapping("getDataResourceAssignmentOfOrgan")
//    BaseResultEntity<PageDataEntity> getDataResourceAssignmentOfOrgan(ResourceParam param) {
//        return resourceService.getDataResourceAssignmentOfOrgan(param);
//    }

//    @RequestMapping("getResourceListUser")
//    BaseResultEntity getResourceListUser(@RequestBody ResourceParam resourceParam) {
//        return resourceService.getResourceListUser(resourceParam);
//    }

//    /** 查询资源对机构的授权 */
//    @GetMapping("getDataResourceOrganAssignmentByResourceId")
//    BaseResultEntity<PageDataEntity> getDataResourceOrganAssignmentByResourceId(String resourceFusionId, PageParam pageParam) {
//        return resourceService.getDataResourceAssignmentOfResourceByResourceFusionId(resourceFusionId, pageParam);
//    }


    /** 协作方资源 */
    @PostMapping("getCoopResourceListOrgan")
    BaseResultEntity getCoopResourceListOrgan(@RequestBody ResourceParam resourceParam) {
        return resourceService.getCoopResourceListOrgan(resourceParam);
    }

    /** 机构已获得授权资源 */
    @PostMapping("getResourceListOfOrgan")
    BaseResultEntity getResourceListOfOrgan(@RequestBody ResourceParam resourceParam) {
        return resourceService.getResourceListOfOrgan(resourceParam);
    }

    /** 用户已获得授权资源 */
    @PostMapping("getResourceListOfUser")
    BaseResultEntity getResourceListOfUser(@RequestBody ResourceParam resourceParam) {
        return resourceService.getResourceListOfUser(resourceParam);
    }
}
