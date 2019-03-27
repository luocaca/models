package me.luocaca.model.controller;

import com.alibaba.druid.support.json.JSONUtils;
import me.luocaca.model.entity.*;
import me.luocaca.model.service.BookRepository;
import me.luocaca.model.service.CompanyRepository;
import me.luocaca.model.service.PersionRepository;
import me.luocaca.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    /**
     * for  persion
     */
    @Autowired
    PersionRepository persionRepository;

    @Autowired
    CompanyRepository companyRepository;
    /**
     * for  user
     */
    @Autowired
    UserService userService;


    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookRepository BookDetailRepository;

    @GetMapping("/personList/{id}")
    @ResponseBody
    public String List(@PathVariable("id") Integer id) {
        // 用2.0这快会报错 换1.5就好了
        //  Error:(19, 35) java: 无法将接口 org.springframework.data.repository.query.QueryByExampleExecutor<T>中的方法 findOne应用到给定类型;
        //  需要: org.springframework.data.domain.Example<S>
        //  找到: java.lang.Integer
        //  原因: 无法推断类型变量 S
        //    (参数不匹配; java.lang.Integer无法转换为org.springframework.data.domain.Example<S>)

        //persionRepository.findById(id).get();
        Person person = persionRepository.findById(id).get();

        return person.toString();
    }


    @GetMapping("/addUser")
    @ResponseBody
    public Person insertUser(Person user) {
        Person save = persionRepository.save(user);
        return save;
    }

    @GetMapping("/saveUser")
    @ResponseBody
    public User saveUser() {//User user, Company company
        User user = new User();
        Company company = new Company();
        user.setAge(18);
        user.setUserName("大傻");
        user.setPassword("123456");


        company.setName("花木易购");
        company.setCreateData("1949-10-1");
//        company.setDescribe("建设于建国时期，一个古老的公司。");
        company.setLocation("厦门市，思明区，七星大厦28层");

//        company.setUser(user);
        user.setCompany(company);
        userService.save(user);
        companyRepository.save(company);
//        userService.save(company);


        return user;
    }


    /**
     * bookRepository
     *
     * @return
     */
    //,consumes = "application/json"
    @RequestMapping(value = "/saveBooks", method = RequestMethod.POST)
    @ResponseBody
    public List<Book> saveBooks(@RequestBody List<Book> books, @Param("id") String id, @RequestHeader("Content-Type") String Content_Type) {//User user, Company compa


        System.out.println("books -- >");
//        List<Book> books = new ArrayList<>();

//        for (int i = 0; i < 1000; i++) {
//            books.add(new Book("大傻学java" + i, 100f + i, new BookDetail(i*1L)));
//        }
//        books.add(new Book("大傻学java2", 100f, new BookDetail(2)));
//        books.add(new Book("大傻学java3", 100f, new BookDetail(3)));
//        books.add(new Book("大傻学java4", 100f, new BookDetail(4)));
//        books.add(new Book("大傻学java5", 100f, new BookDetail(5)));


        return bookRepository.saveAll(books);
    }


    @GetMapping(value = "/printJsonList")
    @ResponseBody
    public List<Book> printJsonList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("大傻学java1", 100f, new BookDetail(1)));
        books.add(new Book("大傻学java2", 100f, new BookDetail(2)));
//        System.out.println("json list is -> \n" + JSONUtils.toJSONString(books));

        return books;
    }


    @GetMapping(value = "/bookList")
    @ResponseBody
    public List<Book> bookList() {


        List<Book> books = bookRepository.findAll();
        return books;

    }

    @GetMapping(value = "/removeBook")
    @ResponseBody
    public String removeOneById() {
        bookRepository.deleteById(1L);
        return "删除成功";

    }

    @GetMapping(value = "/updateBook")
    @ResponseBody
    public String updateBook() {

        Book book = bookRepository.findAll().get(0);

        book.setPrice(666f);
        book.setOwerId(123);
        book.setBookName("汽车之家");
        BookDetail detail = book.getBookDetail();
        detail.setNumberOfPages(666L);
        book.setBookDetail(detail);


        return "更新成功\n" + bookRepository.save(book);
    }


    @PreAuthorize("hasAnyRole('vip1')")
    @GetMapping("/secured/all")
    @ResponseBody
    public String securedHello() {
        return "Secured Hello";
    }


    @PreAuthorize("hasAnyRole('vip2')")
    @GetMapping("/secured/vip2")
    @ResponseBody
    public String securedvip2() {
        return "Secured securedvip2";
    }


//    @GetMapping("/secured/all")
//    public String securedno() {
//        return "Secured Hello";
//    }

}
