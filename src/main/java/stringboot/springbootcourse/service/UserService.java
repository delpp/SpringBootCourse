package stringboot.springbootcourse.service;

import stringboot.springbootcourse.model.UserDTO;
import stringboot.springbootcourse.persistence.model.User;
import stringboot.springbootcourse.persistence.repository.UserRepo;

public interface UserService extends BaseService<User, Long, UserRepo> {

    UserDTO createUser(UserDTO userDTO);

    UserDTO editUser(UserDTO userDTO);
}
