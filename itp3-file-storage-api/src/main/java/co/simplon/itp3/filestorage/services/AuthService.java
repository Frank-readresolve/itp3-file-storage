package co.simplon.itp3.filestorage.services;

public interface AuthService {

    void authenticate(String customerNumber, String rawKey);
}
