import controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PostController controller = ctx.getBean(PostController.class);
        // use the controller here or pass it where needed
    }
}
