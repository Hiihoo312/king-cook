package cooking.validation;

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

	/**
	 * 初期化処理を実装するメソッド.
	 * @param fileSpell 画像ファイル名。
	 */
	@Override
	public void initialize(FileSpell fileSpell) {

		maxWordsNumber = fileSpell.maxWordsNumber();
	}

	/**
	 * 入力チェック処理を実装するメソッド.
	 * @param inputMultipartFile 入力されたマルチパートファイル。
	 * @param cxt 入力チェックインスタンスの変数名。
	 */
	@Override
	public boolean isValid(MultipartFile inputMultipartFile, ConstraintValidatorContext cxt) {

		if (inputMultipartFile == null || inputMultipartFile.isEmpty()) {
			return true;
		}
		if (inputMultipartFile.getOriginalFilename().length() <= maxWordsNumber) {
			return true;
		} else {
			return false;
		}
	}
}