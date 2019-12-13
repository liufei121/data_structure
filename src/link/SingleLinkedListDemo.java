package link;

import java.util.HashSet;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
       HeroNode heroNode1 = new HeroNode(1,"老大","一一");
        HeroNode heroNode2 = new HeroNode(2,"老二","二二");
        HeroNode heroNode3 = new HeroNode(3,"老三","三三");

        SingleLinkedList list = new SingleLinkedList();
 //       list.add(heroNode1);
  //      list.add(heroNode2);
  //      list.add(heroNode3);
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);

     //   list.list();
        System.out.println(getLength(list.getHead()));
        HashSet hashSet = new HashSet();
        hashSet.add(heroNode1);
    }
    //获取单链表中节点的个数
    public static int getLength(HeroNode head){
        if(head.next==null)return 0;//空链表
        int count=0;
        HeroNode cur=head.next;
        while (cur!=null){
            count++;
            cur=cur.next;//遍历
        }
        return count;
    }
    //获取倒数第n个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if(head.next==null)return null;
        //得到链表的长度
        int size = getLength(head);
        //第二次遍历到size-index的位置
        //先判断index是否合理
        if(index<0 || index >size){
            return null;
        }
        //定义辅助变量cur
        HeroNode cur = head.next;
        for(int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }
    //反转单链表
    public static void reversetList(HeroNode head){
        if(head.next==null || head.next.next==null)return;
        //定义辅助变量
        HeroNode cur = head.next;
        HeroNode next = null;
        //新建一个头结点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原链表
        while(cur!=null){
            next=cur.next;//执行当前链表的下一个节点
            cur.next= reverseHead.next;//每次遍历一个节点就放到新链表的最前端
            cur=next;//经cur后移
        }
        head.next=reverseHead.next;//将原先链表的头结点指向新链表头结点的下一个节点
    }
    //将单链表反转打印输出,可以利用栈的先进后出这个特点来打印输出
    public static void resverPrint(HeroNode head){
        if(head.next==null){
            return;
        }
        //创建栈空间
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur=head.next;
        //将链表的节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        //将栈中节点打印输出
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}

//定义SingleLinkedList,管理数据
class SingleLinkedList{
    //初始化头结点,头结点不能动
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑顺序是,找到链表的最后,将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //定义辅助节点,遍历链表
        HeroNode temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            //当链表最后为空是,指向新的节点
            temp=temp.next;
        }
        temp.next=heroNode;
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //定义temp,辅助遍历,因为头节点不能懂
        HeroNode temp = head;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            System.out.println(temp.next);
            //一定要讲节点后移,不然是个死循环
            temp = temp.next;
        }
    }
    //按照顺序将数据添加到指定位置
    public void addByOrder(HeroNode heroNode){
        //头节点不能动,依然需要辅助变量帮助添加数据
        //因为是单链表,我们要找的位置位于添加的前一个节点,否则添加不进去
        HeroNode temp = head;
        boolean flag= false;
        while (true){
            if(temp.next==null){
                break;//此时说明已经到链表结尾
            }
            if(temp.next.no>heroNode.no){//此时位置已经找到
                break;
            }else if(temp.next.no==heroNode.no){
                flag=true;//说明编号存在
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.println("编号已经存在,不能添加");
        }else{
            heroNode.next=temp.next;//新节点指向下一个节点
            temp.next=heroNode;//原先节点指向新结点,完成添加
        }
    }
    //修改节点信息
    public void update(HeroNode newHero){
        //判断集合是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //定义辅助变量,根据no编号找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//标示


        while (true){
            if(temp==null){
                break;//此时链表已经到尾部
            }
            if(temp.no==newHero.no){
                //已经找到修改的节点
                flag=true;
                break;
            }
            temp = temp.next;//指向下一个节点
        }
        if(flag){
            temp.name=newHero.name;
            temp.nickname=newHero.nickname;
        }else{
            System.out.println("没有找到修改的节点");
        }

    }
    //删除节点
    public void delete(int no){
        //定义辅助变量
        HeroNode temp = head;
        boolean flag = false;
        //判断链表是否为空
       if(temp.next==null)return;
       while (true){
           if(temp.next.no==no){//已经找到删除的节点
               flag=true;
               break;
           }
           temp=temp.next;
       }
       if(flag){
           //删除节点
           temp.next=temp.next.next;
       }else{
           System.out.println("没有找到删除的节点");
       }
    }

}




//定义HreoNode,每个HreoNode就是一个节点

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}