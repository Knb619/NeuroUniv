package main

import "fmt"

// 単方向リストのノード
type Node struct {
        value string
        next  *Node
}

// 単方向リスト
type List struct {
        head *Node
        len  int
}

// 単方向リストを生成する
func NewList() *List {
        return nil
}

// 単方向リストの長さを得る
func (l *List) Len() int {
        return 0
}

// 単方向リストの指定位置 (0 始まり) に値を追加する
func (l *List) Insert(index int, s string) error {
        return nil
}

// 単方向リストの末尾に値を追加する
func (l *List) Add(s string) error {
        return nil
}

// 単方向リストの指定位置 (0 始まり) の値を変更する
func (l *List) Update(index int, s string) error {
        return nil
}

// 単方向リストをクリアする
func (l *List) Clear() {
}

// 単方向リストの指定位置 (0 始まり) の値を得る
func (l *List) Get(index int) (string, error) {
        return "", nil
}

// メイン関数
func main() {
        list := NewList()
        list.Add("a")
        list.Add("b")
        list.Add("c")
        list.Insert(0, "x")
        list.Update(1, "A")
        fmt.Printf("list len: %d\n", list.Len())
        for i := 0; i < list.Len(); i++ {
                value, err := list.Get(i)
                if err != nil {
                        fmt.Printf("get error: %s\n", err)
                }
                fmt.Printf("[%d]: %s\n", i, value)
        }
}