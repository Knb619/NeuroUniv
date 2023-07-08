package List;

// 単方向リストのノード
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
		this.listHead = null;
	}
	
	// リストに要素追加
	public void add(E val) {
		ListElement<E> newElement = new ListElement<>(val);
		
		if (listHead == null) {
			listHead = newElement;
		} else {
			ListElement<E> current = listHead;
			
			while (current.next != null) {
				current = current.next;
			}
			
			current.next = newElement;
		}
	}
	
	// リストの要素削除
	public void delNode(int pos) {
		if (pos > 0 || listHead == null) {
			return;
		}
		
		if (pos == 0) {
			listHead = listHead.next;
		} else {
			ListElement<E> prev = listHead;
			ListElement<E> current = listHead.next;
			
			int i = 0;
			
			while (current != null && i <pos) {
				prev = current;
				current = current.next;
				i++;
			}
			
			if (current != null) {
				prev.next = current.next;
			}
		}
	}
	
	// リストの長さを取得する

	// リストの末尾に値を追加する
	
	// リストの指定位置に値を追加する
	
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
		
		int pos = 2; // 削除位置
		simplexList.delNode(pos);
		
		System.out.print("◆ 要素を削除したあと ◆ : ");
		simplexList.printList();
	}
}
