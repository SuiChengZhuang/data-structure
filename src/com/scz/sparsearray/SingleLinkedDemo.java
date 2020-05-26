package com.scz.sparsearray;

/**
 * @description: 单链表
 * @author: sui.chengZhuang
 * @create: 2020-05-26 06:56
 **/
public class SingleLinkedDemo {
    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        SingleLinked.HeroNode node = new SingleLinked.HeroNode(1, "宋江", "及时雨");
        SingleLinked.HeroNode node2 = new SingleLinked.HeroNode(2, "卢俊义", "玉麒麟");
        SingleLinked.HeroNode node3 = new SingleLinked.HeroNode(3, "林冲", "豹子头");
        SingleLinked.HeroNode node4 = new SingleLinked.HeroNode(4, "吴用", "智多星");

        /* System.out.println("测试添加 1 2 3 4~~~");
        singleLinked.add(node);
        singleLinked.add(node2);
        singleLinked.add(node3);
        singleLinked.add(node4);
        singleLinked.show();


        System.out.println("测试删除 2 3~~~");
        singleLinked.delete(2);
        singleLinked.delete(3);
        singleLinked.delete(4);
        singleLinked.show();

        System.out.println("测试修改 1 ~~~");
        singleLinked.modify(new SingleLinked.HeroNode(1, "晁盖", "晁天王"));
        singleLinked.show();
           */
        System.out.println("测试有序添加~~~");
        singleLinked.addSort(node2);
        singleLinked.addSort(node3);
        singleLinked.addSort(node);
        singleLinked.addSort(new SingleLinked.HeroNode(7, "武松", "转治西门庆"));
        singleLinked.addSort(node4);

        singleLinked.show();
    }
}

class SingleLinked {

    private HeroNode head = new HeroNode(0, "", "");

    public void addSort(HeroNode node) {
        HeroNode temp = this.head;
        while (temp.next != null) {
            if (temp.next.getNo() == node.getNo()) {
                throw new RuntimeException("重复添加排名为" + node.getNo() + "的英雄");
            }

            if (node.getNo() > temp.getNo() && node.getNo() < temp.next.getNo()) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void add(HeroNode node) {
        HeroNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void delete(int no) {
        HeroNode temp = this.head;
        while (temp.next != null) {
            if (temp.next.getNo() == no) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        if (temp.getNo() != no) {
            System.out.println("未找到排名为" + no + "的英雄");
        }
    }

    private HeroNode find(int no) {
        HeroNode temp = this.head;
        while (temp.next != null) {
            if (temp.next.getNo() == no) {
                return temp.next;
            }
            temp = temp.next;
        }
        throw new RuntimeException("not found no");
    }

    public void modify(HeroNode node) {
        HeroNode temp = find(node.getNo());

        temp.setName(node.getName());
        temp.setNickName(node.nickName);
    }

    static class HeroNode {

        private int no;

        private String name;

        private String nickName;

        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public HeroNode getNext() {
            return next;
        }

        public void setNext(HeroNode next) {
            this.next = next;
        }

        public String toString() {
            return "HeroNode{ no=" + no + ", name=" + name + ", nickName= " + nickName + "}";
        }
    }

    public void show() {
        HeroNode temp = this.head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}
