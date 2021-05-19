package cooking.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * オリジナルファイル拡張子入力チェック用のアノテーションクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Constraint(validatedBy = { PicFileFormatValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PicFileFormat {
	String message() default "{EMSG102}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
