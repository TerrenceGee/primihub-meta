package com.primihub.repository;


import com.primihub.entity.resource.param.ResourceParam;
import com.primihub.entity.resource.po.FusionResource;
import com.primihub.entity.resource.po.FusionResourceField;
import com.primihub.entity.resource.po.FusionResourceOrganAssignment;
import com.primihub.entity.resource.po.FusionResourceVisibilityAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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

    List<FusionResource> selectFusionResourceOrgan(ResourceParam param);

    Integer selectFusionResourceOrganCount(ResourceParam param);

    FusionResourceOrganAssignment selectFusionResourceOrganAssignment(Map<String, Object> paramMap);

    void updateFusionResourceOrganAssignment(FusionResourceOrganAssignment assignmentPo);

    void saveBatchResourceOrganAssignment(@Param("collection")List<FusionResourceOrganAssignment> list);
}
