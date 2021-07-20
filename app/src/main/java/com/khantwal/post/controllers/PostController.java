package com.khantwal.post.controllers;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khantwal.post.models.Employee;
import com.khantwal.post.models.FormData;
import com.khantwal.post.models.Message;
import com.khantwal.post.models.Offer;
import com.khantwal.post.models.OfferCategory;
import com.khantwal.post.models.OfferStatus;
import com.khantwal.post.models.Points;
import com.khantwal.post.services.EmployeeService;

@Controller
@MultipartConfig
public class PostController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(ModelMap map, HttpSession session) {
		LOGGER.info("Inside getHomePage() of PostController");
		if (session.getAttribute("employee") != null && !session.getAttribute("employee").equals("")) {
			
			List<OfferCategory> categories = getAllCategories();
			Employee emp = (Employee) session.getAttribute("employee");
			//Points p = employeeService.getPoints(emp);
			List<Offer> offersOfEmployee = getOfferOfEmployee(emp.getEmployeeId());
//			List<Offer> allOffers = getAllOffers();
			Points pointOfEmployee = employeeService.getPoints(emp.getEmployeeId());
			map.addAttribute("points", pointOfEmployee.getPoints());
//			map.addAttribute("allOffers", allOffers);
			map.addAttribute("offers", offersOfEmployee);
			map.addAttribute("categories", categories);
			return "home";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/getOffer", method = RequestMethod.GET)
	private String getOffer(@RequestParam("id") Long offerId, ModelMap map) {
		LOGGER.info("Inside getOffer() of PostController");
		Offer off = employeeService.getOffer(offerId);
		map.addAttribute("off", off);
		return "offer";
	}

	@RequestMapping(value = "/getOffers", method = RequestMethod.GET)
	private String getOffers(@RequestParam("sortBy") String sortBy, ModelMap map) {
		LOGGER.info("Inside getOffers() of PostController");
		System.out.println(sortBy+" "+sortBy.getClass());
		List<Offer> off = employeeService.getOffers(sortBy);
		map.addAttribute("off", off);
		return "offers";
	}
	
	@RequestMapping(value = "/getOffersPosted/{employeeId}")
	private List<Offer> getOfferOfEmployee(Long employeeId) {
		LOGGER.info("Inside getOfferOfEmployee() of PostController");
		return employeeService.getOfferOfEmployee(employeeId);

	}

//	@RequestMapping(value = "/getAllOffers")
//	private List<Offer> getAllOffers() {
//		return employeeService.getAllOffers();
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		LOGGER.info("Inside getLoginPage() of PostController");
		return "login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String getProfilePage(@RequestParam("email") String email, @RequestParam("password") String password,
		RedirectAttributes map, HttpSession session) {
		LOGGER.info("Inside getProfilePage() of PostController");
		if(email.equals("") || password.equals("")) {
			return "redirect:/";
		}
		Employee emp = employeeService.findByEmailAndPassword(email, password);
		if (emp == null) {
			System.out.println("inside null if");
			Message msg = new Message();
			msg.setMessage("Please enter correct email and password!");
			msg.setType("error");
			msg.setCssClass("alert-danger");
			map.addFlashAttribute("msg", msg);
			return "redirect:login";

		} else {
			System.out.println("password and email is correct");
			session.setAttribute("employee", emp);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfile() {
		LOGGER.info("Inside getProfile() of PostController");
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage() {
		LOGGER.info("Inside getRegisterPage() of PostController");
		return "register";
	}

	@RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
	public String registerEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("check") String check) {
		LOGGER.info("Inside registerEmployee() of PostController");
		employeeService.registerEmployee(employee);
		return "registered";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		LOGGER.info("Inside logout() of PostController");
		session.removeAttribute("employee");
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, HttpSession session) {
		LOGGER.info("Inside updateEmployee() of PostController");
		Employee emp = (Employee) session.getAttribute("employee");
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPassword(employee.getPassword());
		emp.setPh(employee.getPh());
		employeeService.updateEmployee(emp);
		return "redirect:/";
	}

	@RequestMapping(value = "/getAllCategories", method = RequestMethod.GET)
	public List<OfferCategory> getAllCategories() {
		LOGGER.info("Inside getAllCategories() of PostController");
		return employeeService.getAllCategories();
	}

	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public String savePost(@ModelAttribute("form") FormData form, HttpSession session) {
		LOGGER.info("Inside savePost() of PostController");
		if (session.getAttribute("employee") != null && !session.getAttribute("employee").equals("")) {
			System.out.println(form.getOfferCategory());
			Offer off = new Offer();
			off.setContent(form.getContent());
			off.setTitle(form.getTitle());
			Employee emp = (Employee) session.getAttribute("employee");
			off.setEmployeeId(emp.getEmployeeId());
			off.setLikes((long) 0);
			OfferStatus os = new OfferStatus();

			OfferCategory oc = new OfferCategory();
			oc.setOfferCategoryId(form.getOfferCategory());

			off.setEngage(null);
			off.setOfferCategory(oc);
			off.setOfferStatus(os);

			/*
			 * off.setContent(offer.getContent());
			 * //off.setOfferCategory(offer.getOfferCategory());
			 * off.setTitle(offer.getTitle()); //off.getOfferStatus().getLikes().add(null);
			 * //offer.getOfferStatus().setOffer(off); Employee emp = (Employee)
			 * session.getAttribute("employee"); off.setEmployeeId(emp.getEmployeeId());
			 * 
			 * OfferStatus os = new OfferStatus(); os.setOffer(off) ; off.setLikes((long)
			 * 0);
			 */
			// off.getOfferCategory().getOffer().add(off);
			/* off.getOfferStatus().setOffer(off); */
			/* off.getOfferStatus().setClosingDate(null); */
			// off.setOfferStatus(os);
			// off.setEngage(null);
			// off.getOfferCategory().setCategoryType(offer.getOfferCategory().getCategoryType());
			employeeService.savePost(off);
			return "saved";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/addEngagement", method = RequestMethod.POST)
	public String addEngagement(@RequestParam("employeeId") Long employeeId, @RequestParam("offerId") Long offerId) {
		LOGGER.info("Inside addEngagement() of PostController");
		employeeService.addEngagement(employeeId, offerId);
		return "saved";
	}

	@RequestMapping(value = "/updateLikes", method = RequestMethod.POST)
	public String updateLikes(@RequestParam("employeeId") Long employeeId, @RequestParam("offerId") Long offerId) {
		LOGGER.info("Inside updateLikes() of PostController");
		return employeeService.updateLikes(employeeId, offerId);

	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String getAdminPage() {
		LOGGER.info("Inside getAdminPage() of PostController");
		return "redirect:http://localhost:8085/admin/profile";
	}

}
