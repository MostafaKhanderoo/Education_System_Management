package app.service;

import app.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin save(Admin admin);

    void delete(Long id);
    List<Admin> selectAllAdmin();




}
