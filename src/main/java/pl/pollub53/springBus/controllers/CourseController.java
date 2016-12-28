package pl.pollub53.springBus.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Course;
import pl.pollub53.springBus.services.CourseService;

@Controller
@SessionAttributes("course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course/list")
    public String List(Model model) {
        model.addAttribute("company", courseService.getCourses());
        return "course/courses";
    }

    @GetMapping("course/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course/courseform";
    }

    @PostMapping("course/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/course/" + course.getId();
    }

    @GetMapping("course/{id}")
    public String showCourse(@PathVariable long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "course/courseform";
    }

    @GetMapping("course/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return "notExist";
        }
        model.addAttribute("course", course);
        return "course/courseform";
    }

    @GetMapping("course/delete/{id}")
    public String deleteCourse(@PathVariable long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/" + id;
    }
}
