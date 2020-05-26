package validation;

import java.lang.annotation.Documented;
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
@Documented
@Constraint(validatedBy = { PicFileFormatValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface PicFileFormat {
	String message() default "{PicFileFormat.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		PicFileFormat[] value();
	}
}