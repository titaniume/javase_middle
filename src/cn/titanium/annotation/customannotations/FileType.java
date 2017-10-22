package cn.titanium.annotation.customannotations;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( METHOD )
@Retention( RetentionPolicy.RUNTIME )
@Repeatable(FileTypes.class)
public @interface FileType {

	String value();

}
