package com.omega.date.structrue

import android.util.Log

/**
 * 双向链表 实现增删改查
 */
class MyLinkedList<T> {

    inner class Node( var next:Node?,
                      var previous:Node?,
                      var element:T?)
    var first:Node?=null
    var last:Node?=null
    var size:Int = 0


    /**
     * design思想
     * 第一步，基本实现
     *
     */

    fun add(index:Int,element:T){
        if (index>size){
            throw IndexOutOfBoundsException("size=$size but index=$index")
        }
        //判断从哪里插入
        if (index>size/2){
            //从后往前插入
            lastInsert(index,element)
        }else{
            //从前往后插入
            beforeInsert(index,element)
        }
        size ++
    }

    fun beforeInsert(index: Int,element: T){
        //创建节点。。拿到前后节点。
        val node = Node(null, null, element)
        if (size==0){
            first = node
            last  = node
        }else{
            Log.i("MyLinkdedList","$element")
            var next:Node? = first
            for (i in 0 until index){
                next = next?.next
            }
            node.previous = next?.previous
            node.next = next
            next?.previous?.next = node

            if (next == first){
             first = node
            }
            if (index == size){
                last = node
            }
        }
    }

    fun lastInsert(index:Int, element: T){
        val node = Node(null, null, element)
        if (size==0){
            first = node
            last  = node  //如果index==0说明直接是在第一个插入
        }else{
            var prev:Node? = last
            for (i in size until index){
                prev = prev?.previous
            }
            node.previous =prev
            node.next =prev?.next
            prev?.next =node
            //如果是最后一个
            if (prev == last){
                last = node
            }
            if (index == 0){
                first = node
            }

        }
    }

    fun del(element:T):T?{
        //增加就行
        return null
    }

    fun set(element:T,changeElement:T){

    }

    fun get(index:Int){

    }

    override fun toString(): String {
        //打印数据结构
        var buffer:StringBuffer = StringBuffer()
        var node = first
        buffer.append(node?.element)
         for (index in 0 until size){
             node = node?.next
             if (node!=null)
             buffer.append("<～～>"+node.element+"")
         }
        buffer.append(" currentSize = $size")
        return buffer.toString()
    }
}