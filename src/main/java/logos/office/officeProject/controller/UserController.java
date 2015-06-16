package logos.office.officeProject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.model.User;
import logos.office.officeProject.service.UserService;

@Controller
@RequestMapping("/users")
// по зразку
public class UserController {
	@Inject
	private UserService userService;

	@RequestMapping()
	public ModelAndView getUsers(ModelAndView model) {

		model.addObject("usersList", userService.getAllUsers());
		model.setViewName("users");

		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUserById(Model model, @PathVariable long id) {

		User user = userService.getUserInfo(id);

		model.addAttribute("userInfo", user);
		return "user";
	}

	@RequestMapping(value = "/email{email}", method = RequestMethod.GET)
	public String getUserByEmail(Model model, @PathVariable String email) {

		model.addAttribute("userInfo", userService.getUserInfoByEmail(email));

		return "user";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@RequestParam String email,
			@RequestParam String first_Name, @RequestParam String last_Name,
			@RequestParam Integer age, @RequestParam String password) {
		userService.saveUser(first_Name, last_Name, age, email, password);

		return "redirect:/users";
	}

}
