
package tree;

import java.util.*;

//�ڵ����ݽṹ
class TreeNode {

	String value = null;
	TreeNode leftchildren = null;
	TreeNode middlechildren = null;
	TreeNode rightchildre = null;

	public TreeNode(String value, TreeNode leftchildren, TreeNode middlechildren, TreeNode rightchildre) {
		this.value = value;
		this.leftchildren = leftchildren;
		this.middlechildren = middlechildren;
		this.rightchildre = rightchildre;
	}

	public TreeNode(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setLeftchildren(TreeNode leftchildren) {
		this.leftchildren = leftchildren;
	}

	public void setMiddlechildren(TreeNode middlechildren) {
		this.middlechildren = middlechildren;
	}

	public void setRightchildre(TreeNode rightchildre) {
		this.rightchildre = rightchildre;
	}

	public String getValue() {
		return value;
	}

	public TreeNode getLeftchildren() {
		return leftchildren;
	}

	public TreeNode getMiddlechildren() {
		return middlechildren;
	}

	public TreeNode getRightchildre() {
		return rightchildre;
	}
}

public class TreeSearch2 {

	// ����һ��������
	public TreeNode getTargetTree() {
		// Ҷ�ӽڵ�
	
		TreeNode G= new TreeNode("G");
		TreeNode F= new TreeNode("F");
		TreeNode E = new TreeNode("E");
		TreeNode D = new TreeNode("D", null,null, G);
		TreeNode C = new TreeNode("C", E, null,F);
		TreeNode B= new TreeNode("B", D, null, null);
		// ������ڵ�
		TreeNode root = new TreeNode("A", B,null, C);
		return root;
	}

	/**
	 * ǰ�����
	 */
	public void preorderVistTreeNode(TreeNode node) {
		if (null != node) {

			System.out.print(node.value);

			if (null != node.leftchildren) {
				preorderVistTreeNode(node.leftchildren);
			}
			if (null != node.middlechildren) {
				preorderVistTreeNode(node.middlechildren);
			}
			if (null != node.rightchildre) {
				preorderVistTreeNode(node.rightchildre);
			}
		}
	}

	/**
	 * �������
	 */
	public void postorderVistTreeNode(TreeNode node) {
		if (null != node) {
			if (null != node.leftchildren) {
				postorderVistTreeNode(node.leftchildren);
			}
			if (null != node.middlechildren) {
				preorderVistTreeNode(node.middlechildren);
			}
			if (null != node.rightchildre) {
				postorderVistTreeNode(node.rightchildre);
			}

			System.out.print(node.value);

		}
	}

	/**
	 * ��α���
	 */
	public void levelorderVistTreeNode(TreeNode node) {
		if (null != node) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(node);
			TreeNode currentNode;

			while (!list.isEmpty()) {
				currentNode = list.poll(); // ��ȡ���Ƴ����б��ͷ

				System.out.print(currentNode.value);

				if (null != currentNode.leftchildren) {
					list.add(currentNode.leftchildren);
				}

				if (null != currentNode.middlechildren) {
					list.add(currentNode.middlechildren);
				}

				if (null != currentNode.rightchildre) {
					list.add(currentNode.rightchildre);
				}
			}
		}
	}

	public static void main(String[] args) {

		TreeSearch2 treeSearch = new TreeSearch2();
		TreeNode tree = treeSearch.getTargetTree();

		System.out.print("ǰ�����:");
		treeSearch.preorderVistTreeNode(tree);
		System.out.println("");

		System.out.print("�������:");
		treeSearch.postorderVistTreeNode(tree);
		System.out.println("");

		System.out.print("��α���:");
		treeSearch.levelorderVistTreeNode(tree);
		System.out.println("");
	}
}
