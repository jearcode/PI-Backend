package com.luxevision.backend.entity.util;

import org.springframework.http.HttpMethod;

public enum RolePermission {

    READ_ALL_STUDIOS,
    READ_ONE_STUDIO,
    READ_RANDOM_STUDIOS,
    CREATE_ONE_STUDIO,
    UPDATE_ONE_STUDIO,
    DELETE_ONE_STUDIO,

    READ_ALL_SPECIALTIES,
    READ_ONE_SPECIALTY,
    CREATE_ONE_SPECIALTY,
    UPDATE_ONE_SPECIALTY,
    DELETE_ONE_SPECIALTY,

    READ_ALL_FEATURES,
    READ_ONE_FEATURE,
    CREATE_ONE_FEATURE,
    UPDATE_ONE_FEATURE,
    DELETE_ONE_FEATURE,

    READ_ALL_USERS,
    READ_ONE_USER,
    READ_MY_PROFILE,
    CREATE_ONE_USER,
    UPDATE_ONE_USER,
    UPDATE_MY_PROFILE,
    DELETE_ONE_USER,
    ASSIGN_ROLE_ADMINISTRATOR,
    REVOKE_ROLE_ADMINISTRATOR,
    READ_FAVORITES,


    FULL_ACCESS_BOOKING,
    MAKE_BOOKING,
    CANCEL_MY_BOOKING,
    VIEW_MY_RESERVATIONS

}
