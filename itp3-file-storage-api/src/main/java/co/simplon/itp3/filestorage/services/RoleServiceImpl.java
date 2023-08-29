package co.simplon.itp3.filestorage.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.RoleData;
import co.simplon.itp3.filestorage.entities.Role;
import co.simplon.itp3.filestorage.repositories.RoleRepository;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private RoleRepository roles;

    public RoleServiceImpl(RoleRepository roles) {
	this.roles = roles;
    }

    @Override
    @Transactional
    public void create(RoleData inputs) {
	Role role = new Role();
	role.setContactRoleName(inputs.getContactRoleName());
	roles.save(role);
    }

}
