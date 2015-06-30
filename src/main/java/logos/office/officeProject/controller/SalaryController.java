package logos.office.officeProject.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.dto.SalaryDTO;
import logos.office.officeProject.model.Salary;
import logos.office.officeProject.service.SalaryService;

@Controller
@RequestMapping("/salary")
public class SalaryController {
	@Inject
	private SalaryService salaryService;

	@RequestMapping()
	public ModelAndView getSalarys(ModelAndView model) {
		model.addObject("salarysList", salaryService.getAllSalarys());
		model.setViewName("salary");
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSalaryByUserId(Model model, @PathVariable long id) {
		List<SalaryDTO> salary = salaryService.findSalaryByUserId(id);

		model.addAttribute("SalaryById", salary);
		return "salary";
	}

	@RequestMapping(value = "/find?dateFrom={from}&dateTo={to}&userId={userId}", method = RequestMethod.GET)
	// оепеохрюрх!!!!
	public String getSalaryByDuration(Model model,
			@PathVariable(value = "userId") long id,
			@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to) {
		System.err.println(id + " " + from + " " + to);
		model.addAttribute("byDuration",
				salaryService.findSalaryByUserByTimeDuration(id, from, to));
		return "salary";
	}

	// оепеохрюрх!!!!
		//@RequestMapping(value = "/create?dateFrom={from}&dateTo={to}&userId={userId}", method = RequestMethod.POST)
		// оепеохрюрх!!!!
//		public String createSalary(Model model,
//				@PathVariable(value = "userId") long id,
//				@PathVariable(value = "from") Date from,
//				@PathVariable(value = "to") Date to) {
//			System.err.println(id + " " + from + " " + to);
//			model.addAttribute("CreateSalary",
//					salaryService.createSalary(id, from, to));
//			return "salary";
//		}
}