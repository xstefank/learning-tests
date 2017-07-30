/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class GenericClass<T> {

    private final Class<T> type;

    public GenericClass(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }

}
