package Tree;

public class TreeSearch2 {
	public void order(int searchBase) {
		int tree[][] = new int[][] {{2, 3}, {4, 5}, {6, 7}, 
			{8, 9}, {10, 11}, {12, 13},
			{14}, {}, {}, {}, {}, {}, {}, {}};
		
		if (tree[searchBase -1].length == 2) {
			order(tree[searchBase - 1][0]);
			System.out.print(searchBase + " ");
			order(tree[searchBase - 1][1]);
			
		} else if (tree[searchBase -1].length == 1) {
			order(tree[searchBase - 1][0]);
			System.out.print(searchBase + " ");
			
		} else {
			System.out.print(searchBase + " ");
		}
	}
	
	public static void main(String[] args) {
		TreeSearch2 tree = new TreeSearch2();
		tree.order(1);
	}
}
