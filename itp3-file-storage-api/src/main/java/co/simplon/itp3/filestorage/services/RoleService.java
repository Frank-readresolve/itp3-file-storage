package co.simplon.itp3.filestorage.services;

import co.simplon.itp3.filestorage.dtos.RoleData;

public interface RoleService {

    void create(RoleData inputs);

    boolean existsByContactRoleCode(String value);
}
