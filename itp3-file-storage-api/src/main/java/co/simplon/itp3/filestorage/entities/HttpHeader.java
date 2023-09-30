package co.simplon.itp3.filestorage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "http_headers")
public class HttpHeader extends AbstractEntity {

    @Column(name = "header_name")
    private String headerName;

    @Column(name = "header_value")
    private String headerValue;

    public HttpHeader() {
    }

    public String getHeaderName() {
	return headerName;
    }

    public void setHeaderName(String headerName) {
	this.headerName = headerName;
    }

    public String getHeaderValue() {
	return headerValue;
    }

    public void setHeaderValue(String headerValue) {
	this.headerValue = headerValue;
    }

    @Override
    public String toString() {
	return "{headerName=" + headerName
		+ ", headerValue=" + headerValue + "}";
    }

}
