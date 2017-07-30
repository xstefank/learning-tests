import dummy.Dummy;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class Main {

    public static void main(String[] args) {
        GenericClass<Dummy> clazz = new GenericClass<Dummy>(Dummy.class);

        System.out.println("==================");
        System.out.println(clazz.getMyType());
    }
}
