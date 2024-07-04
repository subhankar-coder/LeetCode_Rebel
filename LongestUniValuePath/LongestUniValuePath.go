package main

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

var result int = 1

func main() {

	root := &TreeNode{
		val:   1,
		left:  &TreeNode{val: 4, left: &TreeNode{val: 4, left: nil, right: nil}, right: &TreeNode{val: 4, left: &TreeNode{val: 7}, right: nil}},
		right: &TreeNode{val: 5, left: nil, right: &TreeNode{val: 5, left: nil, right: nil}},
		// left:  &TreeNode{val: 2},
		// right: nil,
	}
	longestUnivaluePath(root)
	println(result - 1)
}

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}

	if (*root).left == nil && (*root).right == nil {
		return 1
	}

	left := longestUnivaluePath((*root).left)
	right := longestUnivaluePath((*root).right)

	halfMax := 1
	fullMax := 0

	if (*root).right != nil && (*root).left != nil && (*root).left.val == (*root).val && (*root).right.val == (*root).val {
		halfMax = 1 + max(right, left)
		fullMax = 1 + left + right

	} else if (*root).right != nil && (*root).right.val == (*root).val {
		halfMax = 1 + right
	} else if (*root).left != nil && (*root).left.val == (*root).val {
		halfMax = 1 + left
	}
	// halfMax = 1 + max(left, right)

	// if (*root).left != nil && (*root).left.val == (*root).val && (*root).right != nil && (*root).right.val == (*root).val {
	// 	fullMax = 1 + left + right
	// }

	result = max(result, max(fullMax, halfMax))

	return halfMax

}
func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}
