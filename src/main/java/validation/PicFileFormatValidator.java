package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;
/**
 * オリジナルファイル拡張子入力チェック用のバリデータクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
public class PicFileFormatValidator implements ConstraintValidator<PicFileFormat, MultipartFile> {

	@Override
	public void initialize(PicFileFormat picFileFormat) {
	}

	@Override
	public boolean isValid(MultipartFile input, ConstraintValidatorContext cxt) {

		if (input.isEmpty()) {
			return true;
		}
		if ((input.getContentType().toLowerCase().equals("image/jpg")
				|| input.getContentType().toLowerCase().equals("image/jpeg")
				|| input.getContentType().toLowerCase().equals("image/jpe")
				|| input.getContentType().toLowerCase().equals("image/png"))) {
			return true;
		} else {
			return false;

		}
	}
}
