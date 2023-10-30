# SpringDataJPAWithRestfulApi

1. add dependency
   
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
2. configurate datasource in application.property file 
   
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.username=
  spring.datasource.password=
//must have a database first
  spring.datasource.url=jdbc:mysql://localhost/myHibernate
//if table do not exist, create one, if exists, update
  spring.jpa.hibernate.ddl-auto=update
//show sql on console
  spring.jpa.show-sql=true

3. create pojo class User

@Entity     // must be jakarta
@Table(name="SpringDataJPAUser")   // auto create a table with this name
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

5. create repository interface and extends CrudRepository interface 

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}

6. restful api

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired                                              //injection with consturctor
    private UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping                                            // only use get post put delete request
    public List<User> getAll(){
        return userService.getAll();
    }
    
    @GetMapping("/{id}")                                    // specific get request
    public User getUserById(@PathVariable int id){
       return userService.getUser(id);
    }


    @ResponseStatus(HttpStatus.CREATED)                    // response status code
    @PostMapping                                          
    public void create(@RequestBody User user){
        userService.createUser(user);
    }

}




