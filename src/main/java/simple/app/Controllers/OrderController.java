package simple.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simple.app.models.OrderAdd;
import simple.app.repo.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public String order(Model model) {
        Iterable<OrderAdd> orderAdds = orderRepository.findAll();
        model.addAttribute("orderAdds", orderAdds);
        return "order";
    }

    @PostMapping("/order")
    public String orderAdd(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address,
                           @RequestParam String country, @RequestParam String state, @RequestParam String ccName, @RequestParam int ccNumber,
                           @RequestParam int ccExpiration,@RequestParam int ccCvv, Model model){
        OrderAdd orderAdd = new OrderAdd(firstName,lastName,email,address,country,state,ccName,ccNumber,ccExpiration,ccCvv);
        orderRepository.save(orderAdd);
        return("redirect:/");
    }
}