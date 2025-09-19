package steven.maven.example.Base;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 运行时保留，可通过反射访问
@Target({ElementType.TYPE,ElementType.METHOD}) // 仅用于类、接口等
public @interface TestInterface {
    String value() default "default";

    int age() default 18;

    String name() default "name";

    String sex() default "male";
}
