package com.luxevision.backend.entity.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ROLE_ADMINISTRATOR(Arrays.asList(
            RolePermission.CREATE_ONE_STUDIO,
            RolePermission.READ_ALL_STUDIOS,
            RolePermission.READ_ONE_STUDIO,
            RolePermission.READ_RANDOM_STUDIOS,
            RolePermission.UPDATE_ONE_STUDIO,
            RolePermission.DELETE_ONE_STUDIO,
            RolePermission.CREATE_ONE_SPECIALTY,
            RolePermission.READ_ALL_SPECIALTIES,
            RolePermission.READ_ONE_SPECIALTY,
            RolePermission.UPDATE_ONE_SPECIALTY,
            RolePermission.DELETE_ONE_SPECIALTY,
            RolePermission.CREATE_ONE_FEATURE,
            RolePermission.READ_ALL_FEATURES,
            RolePermission.READ_ONE_FEATURE,
            RolePermission.UPDATE_ONE_FEATURE,
            RolePermission.DELETE_ONE_FEATURE,
            RolePermission.READ_ALL_USERS,
            RolePermission.READ_ONE_USER,
            RolePermission.READ_MY_PROFILE,
            RolePermission.UPDATE_MY_PROFILE,
            RolePermission.CREATE_ONE_USER,
            RolePermission.UPDATE_ONE_USER,
            RolePermission.DELETE_ONE_USER,
            RolePermission.ASSIGN_ROLE_ADMINISTRATOR,
            RolePermission.REVOKE_ROLE_ADMINISTRATOR
    )),

    ROLE_CUSTOMER(Arrays.asList(
            RolePermission.READ_ALL_STUDIOS,
            RolePermission.READ_ONE_STUDIO,
            RolePermission.READ_RANDOM_STUDIOS,
            RolePermission.READ_ALL_SPECIALTIES,
            RolePermission.READ_ONE_SPECIALTY,
            RolePermission.READ_ALL_FEATURES,
            RolePermission.READ_ONE_FEATURE,
            RolePermission.READ_MY_PROFILE,
            RolePermission.UPDATE_MY_PROFILE
    ));

    private List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}