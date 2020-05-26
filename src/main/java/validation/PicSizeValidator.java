package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;
/**
 * オリジナルファイルサイズ入力チェック用のバリデータクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
public class PicSizeValidator implements ConstraintValidator<PicSize, MultipartFile> {
    /** ファイル最大サイズ.*/
	long maxSize;

	@Override
	public void initialize(PicSize picSize) {
		maxSize = picSize.maxSize();
	}

	@Override
	public boolean isValid(MultipartFile input, ConstraintValidatorContext cxt) {

		long picfileSize = input.getSize();
		if (picfileSize < maxSize) {
			return true;

		} else {
			return false;
		}
	}
}
