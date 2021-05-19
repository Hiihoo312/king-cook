package cooking.validation;

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

	/**
	 * 初期化処理を実装するメソッド.
	 * @param picSize 画像サイズ。
	 */
	@Override
	public void initialize(PicSize picSize) {
		maxSize = picSize.maxSize();
	}

	/**
	 * 入力チェック処理を実装するメソッド.
	 * @param inputMultipartFile 入力されたマルチパートファイル。
	 * @param cxt オリジナルバリデータを機能させるインターフェース。
	 */
	@Override
	public boolean isValid(MultipartFile inputMultipartFile, ConstraintValidatorContext cxt) {

		if (inputMultipartFile == null || inputMultipartFile.isEmpty()) {
			return true;
		}
		if (inputMultipartFile != null && inputMultipartFile.getSize() <= maxSize) {
			return true;
		} else {
			return false;
		}
	}
}
