package com.scz.sparsearray;

import javax.print.attribute.standard.JobMessageFromOperator;
import java.util.Scanner;

/**
 * @description: 环形队列
 * @author: sui.chengZhuang
 * @create: 2020-05-24 09:26
 **/
public class CircleQueue {

    // 头指针 , 指向第一个元素
    private int front;

    // 尾指针 , 指向最后一个元素 , 约定最后一个位置空着
    private int rear;

    //最大容量
    private int maxSize;

    private int[] queue;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }

    public void show() {
        for (int i = front; i < getQueueLength(); i++) {
            if (i == front) {
                System.out.print("queue : [" + queue[i % maxSize]);
            } else {
                System.out.print("," + queue[i % maxSize]);
            }
        }
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            System.out.print("]");
            System.out.println();
        }
    }

    private int getQueueLength() {
        return (rear + maxSize - front) % maxSize + front;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("队列中已经没有元素,不能再移除");
            return;
        }

        front = (front + 1) % maxSize;
    }

    private boolean isEmpty() {
        return front == rear;
    }

    public void add(int i) {
        if (isFull()) {
            System.out.println("队列已满,不能再添加元素!");
            return;
        }
        queue[rear] = i;
        rear = (rear + 1) % maxSize;
    }

    private boolean isFull() {
        return (rear + 1 - front) % maxSize == 0;
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(5);
        while (true) {
            System.out.println("请输入需要操作的指令");
            String command = new Scanner(System.in).next();
            switch (command) {
                case "a":
                    System.out.println("请输入一个需要添加数字");
                    queue.add(new Scanner(System.in).nextInt());
                    break;
                case "d":
                    queue.pop();
                    break;
                case "s":
                    queue.show();
            }
        }
    }

}
