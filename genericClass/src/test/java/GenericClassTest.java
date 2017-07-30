import dummy.Dummy;
import dummy.ExtraDummy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class GenericClassTest {

    @Test
    public void validDummyGenericTest() {
        GenericClass<Dummy> clazz = new GenericClass<Dummy>(Dummy.class);

        Assert.assertEquals(clazz.getMyType(), Dummy.class);
    }

    @Test
    public void untypedGenericTest() {
        GenericClass<?> clazz = new GenericClass<>(Dummy.class);

        Assert.assertEquals(clazz.getMyType(), Dummy.class);
    }

//    @Test
//    public void invalidGenericTest() {
//        GenericClass<Dummy> clazz = new GenericClass<Dummy>(ExtraDummy.class);
//
//        Assert.assertEquals(clazz.getMyType(), ExtraDummy.class);
//    }
}
