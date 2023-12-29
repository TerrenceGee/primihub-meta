package com.primihub.repository;


import com.primihub.entity.resource.param.PageParam;
import com.primihub.entity.resource.param.ResourceParam;
import com.primihub.entity.resource.po.FusionResource;
import com.primihub.entity.resource.po.FusionResourceField;
import com.primihub.entity.resource.po.FusionResourceVisibilityAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface FusionResourceRepository {
    List<FusionResource> selectFusionResourceById(@Param("resourceIds") Set<String> resourceIds);
    List<FusionResource> selectFusionResource(ResourceParam param);

    FusionResource selectFusionResourceByResourceId(@Param("resourceId") String resourceId);

    List<FusionResource> selectFusionResourceByResourceIds(@Param("resourceIds") Set<String> resourceIds);
    List<String> selectFusionResourceTag();

    Integer selectFusionResourceCount(ResourceParam param);

    List<FusionResourceField> selectFusionResourceFieldById(@Param("resourceId") Long resourceId);

    List<FusionResourceField> selectFusionResourceFieldByIds(@Param("resourceIds") Set<Long> resourceIds);

    void saveFusionResource(FusionResource fusionResource);

    void updateFusionResource(FusionResource fusionResource);

    void deleteResourceFieldByResourceId(Long resourceId);

    void updateResourceField(FusionResourceField fusionResourceField);

    void saveBatchResourceTag(@Param("tags") Set<String> tags);

    void saveResourceField(FusionResourceField field);

    void saveBatchResourceField(@Param("fields") List<FusionResourceField> fields);

    void saveBatchResourceAuthOrgan(@Param("authOrganList")List<FusionResourceVisibilityAuth> authOrganList);

    void deleteResourceAuthOrgan(@Param("resourceId")String resourceId);

    List<FusionResource> selectFusionResourceUser(ResourceParam param);

    Integer selectFusionResourceCountUser(ResourceParam param);
    /** 查询可用 */
    List<FusionResource> selectFusionResourceOrgan(ResourceParam param);

    Integer selectFusionResourceOrganCount(ResourceParam param);
    /** 查询已授权 */
    List<FusionResource> selectFusionResourceOrganAssignment(ResourceParam param);
    Integer selectFusionResourceOrganAssignmentCount(ResourceParam param);

    List<FusionResource> selectFusionResourceUserAssignment(ResourceParam param);

    Integer selectFusionResourceUserAssignmentCount(ResourceParam param);

    List<FusionResourceVisibilityAuth> selectFusionResourceVisibilityAuth(Map<String, Object> paramMap);

    Integer selectFusionResourceVisibilityAuthCount(Map<String, Object> paramMap);
    List<FusionResourceVisibilityAuth> selectFusionResourceVisibilityAuthByResourceIds(@Param("resourceIds") Set<String> resourceIdArray);

    List<FusionResource> selectCoopFusionResourceOrgan(ResourceParam param);

    Integer selectCoopFusionResourceOrganCount(ResourceParam param);

    List<FusionResource> selectFusionResourceToApplyOfOrgan(ResourceParam param);

    Integer selectFusionResourceToApplyOfOrganCount(ResourceParam param);

    List<FusionResource> selectFusionResourceToApplyOfUser(ResourceParam param);

    Integer selectFusionResourceToApplyOfUserCount(ResourceParam param);
}
