package validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * オリジナルファイル文字数入力チェック用のアノテーションクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Documented
@Constraint(validatedBy = { FileSpellValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface FileSpell {
	String message() default "{FileSpell.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int maxWordsNumber() default 0;

}
