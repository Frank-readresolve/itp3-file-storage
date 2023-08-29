package co.simplon.itp3.filestorage.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RoleData {

    @Pattern(regexp = "^[A-Z]{1-5}")
    private String contactRoleCode;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{1-100}")
    private String contactRoleName;

    public RoleData() {

    }

    public String getContactRoleCode() {
	return contactRoleCode;
    }

    public void setContactRoleCode(String contactRoleCode) {
	this.contactRoleCode = contactRoleCode;
    }

    public String getContactRoleName() {
	return contactRoleName;
    }

    public void setContactRoleName(String contactRoleName) {
	this.contactRoleName = contactRoleName;
    }

    @Override
    public String toString() {
	return "{contactRoleCode=" + contactRoleCode
		+ ", contactRoleName=" + contactRoleName
		+ "}";
    }

}
