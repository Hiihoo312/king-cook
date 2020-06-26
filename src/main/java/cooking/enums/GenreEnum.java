package cooking.enums;

/**
* 商品ジャンルを現すenum.
* @author ris.h.hen
* @version 1.0.0
*/
public enum GenreEnum {
	/** 「商品ジャンル」指定なし、コード値は0です.*/
	ALL("0", "指定なし"),
	/** 「商品ジャンル」家電、コード値は1です.*/
	APPLIANCE("1", "家電"),
	/** 「商品ジャンル」家具、コード値は2です.*/
	FURNITURE("2", "家具"),
	/** 「商品ジャンル」食品、コード値は3です.*/
	FOOD("3", "食品"),
	/** 「商品ジャンル」ファッション、コード値は4です.*/
	FASHION("4", "ファッション"),
	/** 「商品ジャンル」書籍、コード値は5です.*/
	BOOK("5", "書籍");

	/** 商品ジャンルコード.*/
	private String genreCode;
	/** 商品ジャンル名.*/
	private String genreName;

	/**
	 * 商品ジャンルコードと商品ジャンル名を基に商品ジャンルを生成します.
	 * @param genreCode 商品ジャンルコード。
	 * @param genreName 商品ジャンル名。
	 */
	private GenreEnum(String genreCode, String genreName) {
		this.genreCode = genreCode;
		this.genreName = genreName;
	}

	/**
	 * 商品ジャンルコードを取得します.
	 * @return 商品ジャンルコード。
	 */
	public String getGenreCode() {
		return this.genreCode;
	}

	/**
	 * 商品ジャンル名を取得します.
	 * @return 商品ジャンル名。
	 */
	public String getGenreName() {
		return this.genreName;
	}

	/**
	 * genreCodeを基にGenreNameを取得するメソッド.
	 * @param genreCode ジャンルコード。
	 * @return ジャンルコードを取得した時はジャンル名を返す。<br>
	 * その他の場合はヌルを返す。
	 */
	public static String getValueByCode(String genreCode) {
		for (GenreEnum genreEnum : GenreEnum.values()) {
			if (genreEnum.getGenreCode().equals(genreCode)) {
				return genreEnum.getGenreName();
			}
		}
		return null;
	}

}