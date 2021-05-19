package cooking.validation;

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
@Constraint(validatedBy = { FileSpellValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSpell {
	String message() default "{EMSG101}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int maxWordsNumber();

}
