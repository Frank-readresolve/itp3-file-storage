package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.filestorage.entities.Role;

public interface RoleRepository
	extends JpaRepository<Role, Long> {

    Boolean existsByContactRoleCode(String name);

    boolean existsByContactRoleName(String value);
}
