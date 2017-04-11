package edu.infsci2560;

import edu.infsci2560.models.Recipe;
import edu.infsci2560.models.Recipe.RecipeType;
import edu.infsci2560.models.User;
import edu.infsci2560.repositories.RecipeRepository;

import edu.infsci2560.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        RecipeRepository repository = ctx.getBean(RecipeRepository.class);
        repository.save(new Recipe(1L, "Creamy Mushroom Pasta", RecipeType.Pasta,"380 kcal","15 min"));
        repository.save(new Recipe(2L, "Tuna Salad", RecipeType.Salad,"400 kcal", "10 min"));
        repository.save(new Recipe(3L, "Spicy Tomato Soup", RecipeType.Soup, "250 kcal", "20 min"));
        repository.save(new Recipe(4L, "BBQ Style Burger", RecipeType.Meat, "600 kcal", "20 min"));

        UserRepository  userRepository = ctx.getBean(UserRepository.class);
        userRepository.save(new User(1L,"magician","123","magician@gmail.com","Pittsburgh"));
        userRepository.save(new User(2L,"walker","123","walker@gmail.com","New York"));
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//    @Bean
//    public CommandLineRunner databaseDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//            repository.save(new Customer("Billy", "Bean"));
//
//            // fetch all customers
//            log.info("[Database Demo] Customers found with findAll():");
//            log.info("[Database Demo] -------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info("[Database Demo] " + customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("[Database Demo] Customer found with findOne(1L):");
//            log.info("[Database Demo] --------------------------------");
//            log.info("[Database Demo] " + customer.toString());
//
//            // fetch customers by last name
//            log.info("[Database Demo] Customer found with findByLastName('Bauer'):");
//            log.info("[Database Demo] --------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info("[Database Demo] " + bauer.toString());
//            }
//        };
//    }
}
