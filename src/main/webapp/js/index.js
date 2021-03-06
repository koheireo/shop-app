$(function(){
	$(".btn-gnavi").on("click", function(){
		// ハンバーガーメニューの位置を設定するための変数
		var rightVal = 0;
		if($(this).hasClass("open")) {
			// 「open」クラスを持つ要素はメニューを開いた状態に設定
			rightVal = -300;
			// メニューを開いたら次回クリック時は閉じた状態になるよう設定
			$(this).removeClass("open");
		} else {
			// 「open」クラスを持たない要素はメニューを閉じた状態に設定 (rightVal は0の状態 )
			// メニューを開いたら次回クリック時は閉じた状態になるよう設定
			$(this).addClass("open");
		}

		$("#global-navi").stop().animate({
			right: rightVal
		}, 200);
	});
});

// #page-topをクリックした際の設定
$('#page-top').click(function () {
    $('body,html').animate({
        scrollTop: 0//ページトップまでスクロール
    }, 500);//ページトップスクロールの速さ。数字が大きいほど遅くなる
    return false;//リンク自体の無効化
});