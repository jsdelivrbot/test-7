package com.scjn.gitlabauthapp.domain.model.gitlab.mapper;

import org.mapstruct.Mapper;

import com.scjn.gitlabauthapp.domain.model.gitlab.dto.GitlabInfoDTO;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabInfoResponse;
/**
 * Mapper for the entity gitlabInfoDTO and its GitlabInfoResponse.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GitlabInfoMapper {
	GitlabInfoResponse gitlabInfoDTOToGitlabInfoResponse(GitlabInfoDTO gitlabInfoDTO);
	
}
