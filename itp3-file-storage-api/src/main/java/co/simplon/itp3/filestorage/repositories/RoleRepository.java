package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Boolean existsByContactRoleCode(String name);
}
