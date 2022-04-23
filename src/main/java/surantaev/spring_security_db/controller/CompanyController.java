package surantaev.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import surantaev.spring_security_db.entity.Company;
import surantaev.spring_security_db.service.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @RequestMapping("/")
    public String homeCompany(Model model) {
        List<Company> company = companyService.getAllCompany();
        model.addAttribute("company", company);
        return "company/company_page";
    }

    @RequestMapping("/new")
    public String showNewPage(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/new_company";
    }

    @RequestMapping(value = "company/save", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id) {
        ModelAndView view = new ModelAndView("company/edit_company");
        Company company = companyService.getById(id);
        view.addObject("company", company);
        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable(name = "id") Long id) {
        companyService.delete(id);
        return "redirect:/";
    }
}
