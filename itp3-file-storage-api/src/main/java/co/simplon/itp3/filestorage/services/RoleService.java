package co.simplon.itp3.filestorage.services;

public interface RoleService {

    void create(RoleData inputs);

    boolean existsByContactRoleCode(String value);
}
