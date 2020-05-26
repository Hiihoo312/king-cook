package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;
/**
 * オリジナルファイル文字数入力チェック用のバリデータクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
public class FileSpellValidator implements ConstraintValidator<FileSpell, MultipartFile> {
    /** 最大文字数.*/
	private int maxWordsNumber;

	@Override
	public void initialize(FileSpell fileSpell) {
		maxWordsNumber = fileSpell.maxWordsNumber();
	}

	@Override
	public boolean isValid(MultipartFile input, ConstraintValidatorContext cxt) {

		String PicName = input.getOriginalFilename();
		if (PicName.length() < maxWordsNumber) {
			return true;
		}
		return false;
	}

}
