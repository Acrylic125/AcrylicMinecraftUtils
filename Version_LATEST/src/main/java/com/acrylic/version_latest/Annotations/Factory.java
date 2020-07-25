package com.acrylic.version_latest.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target(value={METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Factory {

    Class<?> value();

}
