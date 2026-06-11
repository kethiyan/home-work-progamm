import java.lang.reflect.Field;

public class Injector {

    public static void injectDependencies(Object object)
            throws Exception {

        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields) {

            if(field.isAnnotationPresent(Inject.class)) {

                Object dependency =
                        field.getType()
                             .getDeclaredConstructor()
                             .newInstance();

                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }
}