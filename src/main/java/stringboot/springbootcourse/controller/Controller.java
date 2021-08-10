package stringboot.springbootcourse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stringboot.springbootcourse.model.UserDTO;

@RestController
@RequestMapping(value = "/")
public class Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        UserDTO userDTO = new UserDTO(0L,"", "", "", "", false, false);
        userDTO.setFirstName("Marcin");

        return "Hello End UserDTO " + userDTO.getFirstName();
    }
}
