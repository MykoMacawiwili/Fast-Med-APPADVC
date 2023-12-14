package com.csb.appadvcmidterms.services;

import com.csb.appadvcmidterms.dto.UserDTO;


import java.util.List;


public interface UserService {

    List<UserDTO> list();

    void add(UserDTO user);

    UserDTO get(Integer id);

    void update(UserDTO updatedUser);

    void delete(Integer id);

    UserDTO validateUser(String emailAddress, String password);
}

