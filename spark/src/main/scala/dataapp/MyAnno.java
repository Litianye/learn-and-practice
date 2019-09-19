package dataapp;
/**
 * Created by litianye on 2019-06-20
 */


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @program: spark
 *
 * @description: test user annotation
 *
 * @author: litianye
 *
 * @create: 2019-06-20
 **/

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value() default "test";
}