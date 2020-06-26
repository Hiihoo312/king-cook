package cooking.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * オリジナルファイルサイズ入力チェック用のアノテーションクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Documented
@Constraint(validatedBy = { PicSizeValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PicSize {
	String message() default "{EMSG103}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	long maxSize();

}
