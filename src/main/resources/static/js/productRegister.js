// 商品情報登録確認のダイアログ。
function registerConfirm() {
	// 登録ボタンの押下後、確認ダイアログウィンドウにて、”商品情報を登録しますか？”を表示。
	return window.confirm('商品情報を登録しますか？');
}

// 商品情報一覧画面への戻り確認のダイアログ。
function backConfirm() {
	// 戻るボタンの押下後、確認ダイアログウィンドウにて、”入力内容は保存されません。前画面に戻りますか？”を表示。
	return window.confirm('入力内容は保存されません。前画面に戻りますか？');
}
