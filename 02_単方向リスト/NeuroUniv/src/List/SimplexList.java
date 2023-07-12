package List;

// 単方向リストの要素
class ListElement<E> {
	E val;
	ListElement<E> next;
	
	public ListElement(E val) {
		this.val = val;
		this.next = null;
	}
}

// 単方向リスト実装
public class SimplexList<E> {
	private ListElement<E> listHead;
	
	// コンストラクタ
	public SimplexList() {
		this.listHead = null; // 先頭要素を初期化
	}
	
	// リストの末尾に要素追加
	public void add(E val) {
		ListElement<E> newElement = new ListElement<>(val); // ListElement<E> 型をインスタンス化し新たな要素を格納する
		
		if (listHead == null) {
			listHead = newElement; // Listの先頭要素を未取得の場合は取得
			
		} else {
			ListElement<E> current = listHead; // 先頭要素を 現在見ている要素として控えておく
			
			while (current.next != null) { // Listの最終要素に到達するまで継続
				current = current.next; // 次の要素が存在する場合は、現在の要素を次の要素で上書き
			}
			
			current.next = newElement; // Listの最後尾に要素を追加(最後尾の次の参照先に、追加する要素を登録)
		}
	}
	
	// リストの指定位置に値を追加する
	public void add(E val, int pos) {
		
	}
	
	// リストの要素削除
	public void delNode(int pos) {
		if (pos < 0) {
			System.out.println("[ERROR] 削除位置に負の数は指定できません");
			return;
		}
		
		if (pos == 0 && listHead != null) { // 先頭要素の削除のとき
			listHead = listHead.next; // 先頭要素を次の要素で上書き
			return;
			
		} else { // 2番目の要素以降の削除のとき
			ListElement<E> prev = listHead; // 先頭要素を控えておく
			ListElement<E> current = listHead.next; // 現在の要素として、2番目の要素を控えておく
			
			int i = 1;
			
			while (current != null && i < pos) { // 削除位置を特定
				// 確認位置を1つ進める
				prev = current; // 1つ前の要素を更新
				current = current.next; // 現在の要素を更新
				i++;
			}
			
			if (current != null) {
				prev.next = current.next; // 1つ前の要素の次の参照先を、現在の要素の次の要素で上書きする(現在の要素をスキップする)
			}
		}
	}
	
	// リストの長さを取得する
	public int getLen() {
		ListElement<E> current = listHead;
		
		if (current == null) { // リストの長さが 0 の時
			return 0;
			
		} else if (current.next == null) { // リストの長さが 1 のとき
			return 1;
		
		} else {
			int len = 1;
			
			while (current.next != null) {
				current = current.next;
				len++;
			}
			
			return len;
		}
	}
	
	// リストをクリアする
	
	// リストの内容を表示する
	public void printList() {
		ListElement<E> current = listHead;
		
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		SimplexList<Integer> simplexList = new SimplexList<>();
//		SimplexList<String> simplexList = new SimplexList<>();
		
		simplexList.add(0);
		simplexList.add(1);
		simplexList.add(2);
		simplexList.add(3);
		simplexList.add(4);
		
//		simplexList.add("A");
//		simplexList.add("B");
//		simplexList.add("C");
//		simplexList.add("D");
//		simplexList.add("E");
		
		System.out.print("◆ リストの初期状態 ◆   : ");
		simplexList.printList();
		System.out.print("◆ リストの長さ ◆       : " + simplexList.getLen());
		
		int pos = 5; // 要素の削除位置
		simplexList.delNode(pos); // 要素の削除
		
		System.out.print("◆ 要素を削除したあと ◆ : ");
		simplexList.printList();
	}
}
