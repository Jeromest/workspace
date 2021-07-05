import com.song.pojo.Books;
import com.song.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("BookServiceImpl");

        for (Books books : bookService.queryAllBook()) {
            System.out.println(books);
        }
    }
}
