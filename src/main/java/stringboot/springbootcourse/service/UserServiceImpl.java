package stringboot.springbootcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stringboot.springbootcourse.model.UserDTO;
import stringboot.springbootcourse.persistence.model.User;
import stringboot.springbootcourse.persistence.repository.UserRepo;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepo> implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserRepo getRepository() { return userRepo; }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        System.out.println("createUser");
        User u = save(Mapper.dtoToUser(userDTO));
        return Mapper.userToDTO(u);
    }

    @Override
    public UserDTO editUser(UserDTO userDTO){
        System.out.println("editeUser");
        User u = save(Mapper.dtoToUser(userDTO));
        return Mapper.userToDTO(u);
    }

}
