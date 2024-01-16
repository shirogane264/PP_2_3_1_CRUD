package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("Qwerty", "Uiop", "user1@mail.ru", new Car("Testa", 11111)));
      userService.add(new User("Asd", "Fghj", "user2@mail.ru", new Car("Benzedes", 22222)));
      userService.add(new User("Zxc", "Vbnm", "user3@mail.ru", new Car("BMX", 33333)));
      userService.add(new User("Йцукен", "Ячсмить", "user4@mail.ru", new Car("Shrevmolet", 44444)));

      List<User> users = userService.listUsers();

      System.out.println("\nList of all users:");
      for (User user : users) {
         System.out.println(user.toString());
      }

      System.out.println("\n" + carService.getUser("BMX", 33333) + "\n");

      context.close();
   }
}
