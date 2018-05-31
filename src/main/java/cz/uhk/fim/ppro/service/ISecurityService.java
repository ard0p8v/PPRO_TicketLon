package cz.uhk.fim.ppro.service;

public interface ISecurityService {

    public String findLoggedInUsername();
    public void autologin(String username, String password);
}
