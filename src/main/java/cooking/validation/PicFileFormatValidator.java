package cooking.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

/**
 * オリジナルファイル拡張子入力チェック用のバリデータクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
public class PicFileFormatValidator implements ConstraintValidator<PicFileFormat, MultipartFile> {

	/**
	 * 初期化処理を実装するメソッド.
	 * @param picFileFormat 画像ファイルフォーマット。
	 */
	@Override
	public void initialize(PicFileFormat picFileFormat) {
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
		if (inputMultipartFile.getContentType().equals("image/jpeg")
				|| (inputMultipartFile.getContentType().equals("image/png"))) {
			return true;

		}
		return false;

	}
}
