package com.ruppyrup.annotations;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RuppyRup {
    String name() default "RuppyRup";
}
