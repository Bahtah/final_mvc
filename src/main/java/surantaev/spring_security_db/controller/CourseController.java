package surantaev.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import surantaev.spring_security_db.entity.Company;
import surantaev.spring_security_db.entity.Course;
import surantaev.spring_security_db.service.CompanyService;
import surantaev.spring_security_db.service.CourseService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @RequestMapping("/course")
    public String homeCourse(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("course", courses);
        return "coursePackage/course_page";
    }

    @RequestMapping("course/new")
    public String showNewPage(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "coursePackage/new_course";
    }

    @RequestMapping(value = "course/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course";
    }

    @RequestMapping("course/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id) {
        ModelAndView view = new ModelAndView("coursePackage/edit_course");
        Course course = courseService.getById(id);
        view.addObject("course", course);
        return view;
    }

    @RequestMapping("course/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.delete(id);
        return "redirect:/course";
    }
}
