package logos.office.officeProject.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.dto.SalaryDTO;
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

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String getSalaryByDuration(Model model, HttpServletRequest request) {
		long id = Long.parseLong(request.getParameter("userId"));
		String from = request.getParameter("dateFrom");
		String to = request.getParameter("dateTo");
		model.addAttribute("byDuration",
				salaryService.findSalaryByUserByTimeDuration(id, from, to));
		
		System.out.println(salaryService.findSalaryByUserByTimeDuration(id, from, to).size());
		return "salary";
	}

	// ����������!!!!
	@RequestMapping(value = "/create?dateFrom={from}&dateTo={to}&userId={userId}", method = RequestMethod.POST)
	// ����������!!!!
	public String createSalary(Model model,
			@PathVariable(value = "userId") long id,
			@PathVariable(value = "from") Date from,
			@PathVariable(value = "to") Date to) {
		System.err.println(id + " " + from + " " + to);
		model.addAttribute("createSalary",
				salaryService.createSalary(id, from, to));
		return "salary";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public @ResponseBody List<SalaryDTO> showSalaries() {

		List<SalaryDTO> salaries = salaryService.getAllSalarys();

		return salaries;
	}

}