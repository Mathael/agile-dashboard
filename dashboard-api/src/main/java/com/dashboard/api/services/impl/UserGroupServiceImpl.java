package com.dashboard.api.services.impl;

import com.dashboard.api.services.UserGroupService;
import com.dashboard.core.model.user.UserGroup;
import com.dashboard.core.repository.UserGroupRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class UserGroupServiceImpl extends DefaultServiceImpl<UserGroup, Integer, UserGroupRepository> implements UserGroupService {
}
