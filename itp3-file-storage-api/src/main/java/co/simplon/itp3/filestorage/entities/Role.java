package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    @Column(name = "contact_role_code")
    private String contactRoleCode;

    @Column(name = "contact_role_name")
    private String contactRoleName;

    public Role() {
    }

    public String getContactRoleName() {
	return contactRoleName;
    }

    public void setContactRoleName(String contactRoleName) {
	this.contactRoleName = contactRoleName;
    }

    public String getContactRoleCode() {
	return contactRoleCode;
    }

    public void setContactRoleCode(String contactRoleCode) {
	this.contactRoleCode = contactRoleCode;
    }

    @Override
    public String toString() {
	return "{contactRoleCode=" + contactRoleCode + ", contactRoleName="
		+ contactRoleName + "}";
    }

}
