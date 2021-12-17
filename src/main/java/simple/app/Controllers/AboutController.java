package simple.app.Controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simple.app.models.Post;
import simple.app.repo.PostRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AboutController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/about")
    public String about(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "about";
    }

    @GetMapping("/about/add")
    public String aboutAdd(Model model) {
        return "about-add";
    }

    @PostMapping("/about/add")
    public String aboutPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/about";
    }

    @GetMapping("/about/{id}")
    public String aboutDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/about";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "about-details";
    }

    @GetMapping("/about/{id}/edit")
    public String aboutEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/about";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "about-edit";
    }

    @PostMapping("/about/{id}/edit")
    public String aboutPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);

        return "redirect:/about";
    }
    @PostMapping("/about/{id}/remove")
    public String aboutPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/about";
    }
}